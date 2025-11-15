package task4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class DictionaryUkEng extends Application {
    private final Map<String, String> dictionary = new HashMap<>();

    public void addWord(String english, String ukrainian) {
        dictionary.put(english.toLowerCase(), ukrainian);
    }

    public void remove(String english) {
        dictionary.remove(english.toLowerCase());
    }

    public String findWord(String english) {
        return dictionary.get(english.toLowerCase());
    }

    public boolean isWordExist(String english) {
        return dictionary.containsKey(english.toLowerCase());
    }

    @Override
    public void start(Stage stage) {
        Label translateLabel = new Label("Переклад англійського слова → українською:");
        Label englishLabel = new Label("Англійське слово:");
        TextField english = new TextField();

        Label ukrainianLabel = new Label("Український переклад:");
        TextField ukrainian = new TextField();
        ukrainian.setEditable(false);

        Button translate = new Button("Перекласти");
        translate.setOnAction(e -> {
            String englishText = english.getText().trim();

            if (!englishText.isEmpty() && isWordExist(englishText)) {
                ukrainian.setText(findWord(englishText));
            } else {
                showAlert(Alert.AlertType.ERROR, "Помилка", "Слово не знайдено або поле порожнє!");
            }
        });

        Label addLabel = new Label("Додати нове слово:");
        Label englishAddLabel = new Label("Англійське слово:");
        TextField englishToAdd = new TextField();

        Label ukrainianAddLabel = new Label("Український переклад:");
        TextField ukrainianTranslation = new TextField();

        Button addWord = new Button("Додати слово");
        addWord.setOnAction(e -> {
            String englishToAddText = englishToAdd.getText().trim();
            String ukrainianTranslationText = ukrainianTranslation.getText().trim();

            if (!englishToAddText.isEmpty() && !ukrainianTranslationText.isEmpty() && !isWordExist(englishToAddText)) {
                addWord(englishToAddText, ukrainianTranslationText);
                showAlert(Alert.AlertType.INFORMATION, "Слово додано",
                        englishToAddText + " → " + ukrainianTranslationText + " успішно додано!");
            } else {
                showAlert(Alert.AlertType.ERROR, "Помилка",
                        "Поля порожні або слово вже існує!");
            }
        });

        Button deleteWord = new Button("Видалити слово");
        deleteWord.setOnAction(e -> {
            String englishText = english.getText().trim();
            if (!englishText.isEmpty() && isWordExist(englishText)) {
                remove(englishText);
                english.clear();
                ukrainian.clear();
                showAlert(Alert.AlertType.INFORMATION, "Слово видалено",
                        englishText + " успішно видалено!");

            } else {
                showAlert(Alert.AlertType.ERROR, "Помилка",
                        "Поле порожнє або слово не знайдено!");
            }
        });

        Button clear = new Button("Очистити поля");
        clear.setOnAction(e -> {
            english.clear();
            ukrainian.clear();
            englishToAdd.clear();
            ukrainianTranslation.clear();
        });

        VBox translateBox = new VBox(5, translateLabel, englishLabel, english, ukrainianLabel, ukrainian, translate);
        translateBox.setPadding(new Insets(10));
        translateBox.setStyle("-fx-border-color: lightgray; -fx-border-radius: 5; -fx-padding: 10;");

        VBox addBox = new VBox(5, addLabel, englishAddLabel, englishToAdd, ukrainianAddLabel, ukrainianTranslation, addWord);
        addBox.setPadding(new Insets(10));
        addBox.setStyle("-fx-border-color: lightgray; -fx-border-radius: 5; -fx-padding: 10;");

        HBox buttonBox = new HBox(10, deleteWord, clear);
        buttonBox.setAlignment(Pos.BASELINE_CENTER);
        VBox root = new VBox(15, translateBox, addBox, buttonBox);
        root.setPadding(new Insets(20));

        stage.setScene(new Scene(root, 420, 500));
        stage.setTitle("Dictionary English ↔ Ukrainian");
        stage.show();
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch();
    }
}
