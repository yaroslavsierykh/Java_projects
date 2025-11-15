package task1;

import com.thoughtworks.xstream.XStream;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TramRouteApp extends Application {

    private TableView<Stop> table;
    private TramRouteStream tramRoute;
    private FileWorker fileWorker = new FileWorker();

    @Override
    public void start(Stage stage) {
        tramRoute = new TramRouteStream("1", new ArrayList<>());

        MenuBar menuBar = new MenuBar();

        Menu fileMenu = new Menu("Файл");
        MenuItem newItem = new MenuItem("Новий маршрут");
        MenuItem openItem = new MenuItem("Відкрити XML");
        MenuItem saveItem = new MenuItem("Зберегти XML");
        MenuItem exitItem = new MenuItem("Вихід");

        newItem.setOnAction(e -> {
            tramRoute.getStopsList().clear();
            table.getItems().clear();
        });

        openItem.setOnAction(e -> loadFromXml(stage));
        saveItem.setOnAction(e -> saveToXml(stage));
        exitItem.setOnAction(e -> stage.close());

        fileMenu.getItems().addAll(newItem, openItem, saveItem, new SeparatorMenuItem(), exitItem);

        Menu toolsMenu = new Menu("Інструменти");
        MenuItem searchMin = new MenuItem("Пошук мінімальної кількості пасажирів");
        MenuItem sortByPassengers = new MenuItem("Сортувати за кількістю пасажирів");
        MenuItem sortByNameLength = new MenuItem("Сортувати за довжиною назв");
        toolsMenu.getItems().addAll(searchMin, sortByPassengers, sortByNameLength);

        Menu helpMenu = new Menu("Довідка");
        MenuItem aboutItem = new MenuItem("Про програму");
        helpMenu.getItems().add(aboutItem);

        menuBar.getMenus().addAll(fileMenu, toolsMenu, helpMenu);

        table = new TableView<>();
        TableColumn<Stop, String> nameCol = new TableColumn<>("Назва зупинки");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Stop, Integer> passengersCol = new TableColumn<>("Пасажирів");
        passengersCol.setCellValueFactory(new PropertyValueFactory<>("passengers"));

        table.getColumns().addAll(nameCol, passengersCol);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        Label nameLabel = new Label("Назва зупинки:");
        TextField nameField = new TextField();

        Label passLabel = new Label("Кількість пасажирів:");
        TextField passField = new TextField();

        Button addBtn = new Button("Додати");
        addBtn.setOnAction(e -> {
            String name = nameField.getText();
            String passengersText = passField.getText();
            if (!name.isEmpty() && passengersText.matches("\\d+")) {
                Stop stop = new Stop(name, Integer.parseInt(passengersText));
                table.getItems().add(stop);
                tramRoute.getStopsList().add(stop);
                nameField.clear();
                passField.clear();
            } else {
                showAlert(Alert.AlertType.ERROR, "Помилка", "Некоректні дані!");
            }
        });

        Button deleteBtn = new Button("Видалити вибране");
        deleteBtn.setOnAction(e -> {
            Stop selected = table.getSelectionModel().getSelectedItem();
            if (selected != null) {
                tramRoute.getStopsList().remove(selected);
                table.getItems().remove(selected);
            }
        });

        VBox leftPanel = new VBox(10, nameLabel, nameField, passLabel, passField, addBtn, deleteBtn);
        leftPanel.setPadding(new Insets(10));
        leftPanel.setStyle("-fx-border-color: lightgray; -fx-border-radius: 5;");

        searchMin.setOnAction(e -> {
            Stop[] minStops = tramRoute.findStopsWithFewestPassengers();
            StringBuilder sb = new StringBuilder();
            for (Stop s : minStops) sb.append(s.getName()).append(" (").append(s.getPassengers()).append(")\n");
            showAlert(Alert.AlertType.INFORMATION, "Мінімальна кількість пасажирів", sb.toString());
        });

        sortByPassengers.setOnAction(e -> {
            List<Stop> sorted = tramRoute.sortByPassengersAsc();
            table.getItems().setAll(sorted);
        });

        sortByNameLength.setOnAction(e -> {
            List<Stop> sorted = tramRoute.sortByNameLengthAsc();
            table.getItems().setAll(sorted);
        });

        aboutItem.setOnAction(e -> showAlert(Alert.AlertType.INFORMATION,
                "Про програму",
                "Програма: Обробка трамвайних маршрутів\nАвтор: Ярослав Сєрих\nВерсія: 1.0"));

        BorderPane root = new BorderPane();
        root.setTop(menuBar);
        root.setLeft(leftPanel);
        root.setCenter(table);

        Scene scene = new Scene(root, 700, 400);
        stage.setScene(scene);
        stage.setTitle("Tram Route Manager");
        stage.show();
    }


    private void loadFromXml(Stage stage) {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Відкрити XML");
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML файли", "*.xml"));
        File file = chooser.showOpenDialog(stage);
        if (file != null) {
            Stop[] stops = fileWorker.readStopsFromXmlFile(file.getAbsolutePath());
            tramRoute.setStops(stops);
            table.getItems().setAll(stops);
        }
    }

    private void saveToXml(Stage stage) {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Зберегти XML");
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML файли", "*.xml"));
        File file = chooser.showSaveDialog(stage);
        if (file != null) {
            Stop[] stops = tramRoute.getStops();
            fileWorker.writeStopsToXmlFile(stops, file.getAbsolutePath());
        }
    }

    private void showAlert(Alert.AlertType type, String title, String text) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
