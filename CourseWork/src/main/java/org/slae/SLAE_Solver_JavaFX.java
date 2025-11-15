package org.slae;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.util.*;

public class SLAE_Solver_JavaFX extends Application {

    private TextArea inputArea;
    private TextArea outputArea;
    private ComboBox<String> methodBox;
    private TextField epsField;
    private TextField maxIterField;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("SLAE Solver (Cramer, Gauss, Gauss-Jordan, Jacobi, Seidel)");

        inputArea = new TextArea();
        inputArea.setPromptText("Вставте тут вміст файлу або введіть вручну (див. інструкцію у коментарях коду)...");
        inputArea.setPrefRowCount(10);

        outputArea = new TextArea();
        outputArea.setEditable(false);
        outputArea.setPrefRowCount(10);

        methodBox = new ComboBox<>();
        methodBox.getItems().addAll("Cramer (n<=4)", "Gauss", "Gauss-Jordan", "Jacobi (iter)", "Gauss-Seidel (iter)");
        methodBox.getSelectionModel().selectFirst();

        Button loadBtn = new Button("Завантажити файл");
        loadBtn.setOnAction(e -> loadFile(stage));

        Button solveBtn = new Button("Розв'язати");
        solveBtn.setOnAction(e -> solve());

        Button clearBtn = new Button("Очистити");
        clearBtn.setOnAction(e -> {
            inputArea.clear();
            outputArea.clear();
        });

        epsField = new TextField("1e-8");
        maxIterField = new TextField("1000");

        GridPane top = new GridPane();
        top.setPadding(new Insets(10));
        top.setVgap(8);
        top.setHgap(10);

        top.add(new Label("Метод:"), 0, 0);
        top.add(methodBox, 1, 0);
        top.add(new Label("Епс (точність):"), 0, 1);
        top.add(epsField, 1, 1);
        top.add(new Label("Max ітерацій:"), 0, 2);
        top.add(maxIterField, 1, 2);

        HBox buttons = new HBox(10, loadBtn, solveBtn, clearBtn);
        VBox root = new VBox(10, top, new Label("Вхідні дані:"), inputArea, buttons, new Label("Результат:"), outputArea);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 800, 700);
        stage.setScene(scene);
        stage.show();
    }

    private void loadFile(Stage stage) {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Оберіть текстовий файл зі SLAE");
        File f = chooser.showOpenDialog(stage);
        if (f != null) {
            try {
                String content = new String(Files.readAllBytes(f.toPath()));
                inputArea.setText(content);
            } catch (IOException ex) {
                showError("Помилка читання файлу: " + ex.getMessage());
            }
        }
    }

    private void solve() {
        outputArea.clear();
        String text = inputArea.getText().trim();
        if (text.isEmpty()) { showError("Вхідні дані порожні"); return; }
        try {
            ParsedInput parsed = parseInput(text);
            int n = parsed.n;
            double[][] A = parsed.A;
            double[] B = parsed.B;

            String method = methodBox.getValue();
            double eps = Double.parseDouble(epsField.getText());
            int maxIter = Integer.parseInt(maxIterField.getText());

            double[] X = null;
            switch (method) {
                case "Cramer (n<=4)":
                    if (n > 4) { showError("Крамера можна застосувати лише для n<=4"); return; }
                    X = SLAESolver.cramer(A, B);
                    break;
                case "Gauss":
                    X = SLAESolver.gauss(A, B);
                    break;
                case "Gauss-Jordan":
                    X = SLAESolver.gaussJordan(A, B);
                    break;
                case "Jacobi (iter)":
                    X = SLAESolver.jacobi(A, B, eps, maxIter);
                    break;
                case "Gauss-Seidel (iter)":
                    X = SLAESolver.gaussSeidel(A, B, eps, maxIter);
                    break;
                default:
                    showError("Невідомий метод");
                    return;
            }

            if (X == null) {
                showError("Не вдалося знайти рішення (можливо вироджена матриця або ітерації не збіжні)");
                return;
            }

            boolean ok = SLAESolver.checkSolution(A, B, X, eps * 10);

            StringBuilder sb = new StringBuilder();
            sb.append("Розв'язок (X):\n");
            for (int i = 0; i < X.length; i++)
                sb.append(String.format("x[%d] = %.12g\n", i + 1, X[i]));
            sb.append("\nПеревірка: ").append(ok ? "успішна" : "НЕ пройшла").append("\n");

            if (!ok) {
                sb.append("A*X =\n");
                double[] AX = SLAESolver.multiply(A, X);
                for (double v : AX) sb.append(String.format("%.12g\n", v));
                sb.append("\nB =\n");
                for (double v : B) sb.append(String.format("%.12g\n", v));
            }

            outputArea.setText(sb.toString());

        } catch (Exception ex) {
            showError("Помилка: " + ex.getMessage());
        }
    }

    private void showError(String msg) {
        Alert a = new Alert(Alert.AlertType.ERROR, msg, ButtonType.OK);
        a.setHeaderText(null);
        a.showAndWait();
    }

    private ParsedInput parseInput(String text) throws Exception {
        String[] tokens = text.split("\\s+");
        List<Double> nums = new ArrayList<>();
        for (String t : tokens) {
            if (t.trim().isEmpty()) continue;
            try {
                nums.add(Double.parseDouble(t));
            } catch (NumberFormatException ex) {
                throw new Exception("Неможливо розпізнати число: '" + t + "'");
            }
        }
        if (nums.size() < 1) throw new Exception("Немає чисел у вхідних даних");
        int idx = 0;
        int n = nums.get(idx++).intValue();
        if (n <= 0) throw new Exception("Невірне n: " + n);
        int need = n * n + n;
        if (nums.size() - 1 < need)
            throw new Exception("Недостатньо чисел для матриці A і вектора B. Потрібно: " + need);
        double[][] A = new double[n][n];
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) A[i][j] = nums.get(idx++);
        double[] B = new double[n];
        for (int i = 0; i < n; i++) B[i] = nums.get(idx++);
        return new ParsedInput(n, A, B);
    }

    private static class ParsedInput {
        int n; double[][] A; double[] B;
        ParsedInput(int n, double[][] A, double[] B) { this.n = n; this.A = A; this.B = B; }
    }
}
