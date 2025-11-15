package task3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculator extends Application {

    private static boolean isInputValid(TextField input1, TextField input2) {
        if (input1.getText().isEmpty() || input2.getText().isEmpty()) {
            return false;
        }
        return input1.getText().matches("-?\\d+(\\.\\d+)?") && input2.getText().matches("-?\\d+(\\.\\d+)?");
    }

    @Override
    public void start(Stage stage) {

        Label forInputLabel1 = new Label("Number 1:");
        Label forInputLabel2 = new Label("Number 2:");
        TextField input1 = new TextField();
        TextField input2 = new TextField();

        RadioButton add = new RadioButton("Add");
        RadioButton minus = new RadioButton("Minus");
        RadioButton multi = new RadioButton("Multiply");
        RadioButton div = new RadioButton("Divide");

        ToggleGroup group = new ToggleGroup();
        group.getToggles().addAll(add, minus, multi, div);

        Button submit = new Button("Submit");
        Button clear = new Button("Clear");
        Button changeNumbers = new Button("Swap Numbers");
        Label forResultLabel = new Label("Result:");
        TextField result = new TextField();

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Input is invalid");
        alert.setHeaderText(null);
        alert.setContentText("Input is empty or not a number!");

        clear.setOnAction(e -> {
            input1.clear();
            input2.clear();
            result.clear();
        });

        changeNumbers.setOnAction(e -> {
            if (isInputValid(input1, input2)) {
                String temp = input1.getText();
                input1.setText(input2.getText());
                input2.setText(temp);
            } else {
                alert.showAndWait();
            }
        });

        submit.setOnAction(e -> {
            Toggle selected = group.getSelectedToggle();
            if (selected == null) {
                Alert noChoice = new Alert(Alert.AlertType.WARNING);
                noChoice.setTitle("No operation selected");
                noChoice.setHeaderText(null);
                noChoice.setContentText("Please select an operation first!");
                noChoice.showAndWait();
                return;
            }

            RadioButton chosen = (RadioButton) selected;
            String op = chosen.getText();

            if (!isInputValid(input1, input2)) {
                alert.showAndWait();
                return;
            }

            double n1 = Double.parseDouble(input1.getText());
            double n2 = Double.parseDouble(input2.getText());

            switch (op) {
                case "Add" -> result.setText(String.valueOf(n1 + n2));
                case "Minus" -> result.setText(String.valueOf(n1 - n2));
                case "Multiply" -> result.setText(String.valueOf(n1 * n2));
                case "Divide" -> {
                    if (n2 == 0) result.setText("Can't divide by zero");
                    else result.setText(String.valueOf(n1 / n2));
                }
            }
        });

        HBox hBox = new HBox(10, clear, changeNumbers);
        VBox root = new VBox(10, forInputLabel1, input1, forInputLabel2, input2, add, minus, multi, div, hBox, submit,forResultLabel, result);
        root.setPadding(new Insets(20));

        stage.setScene(new Scene(root, 400, 400));
        stage.setTitle("Calculator App");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
