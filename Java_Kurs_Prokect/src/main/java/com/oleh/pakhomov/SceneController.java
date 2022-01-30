package com.oleh.pakhomov;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import com.google.gson.Gson;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.util.Date;

public class SceneController {
    public static Gson gson = new Gson();
    public static FileChooser fileSystem = new FileChooser();

    static {
        var filter = new FileChooser.ExtensionFilter("JavaScript Object Notation", "*.json");
        fileSystem.getExtensionFilters().add(filter);
    }
    public MathModel function;
    @FXML
    public TextField startX;
    @FXML
    public TextField endX;
    @FXML
    public TextField step;
    @FXML
    public TextField accuracy;
    @FXML
    public Button saveButton;
    @FXML
    public Button loadButton;
    @FXML
    public Button calcButton;
    @FXML
    public LineChart<Number, Number> graph;
    @FXML
    public Pane pane;
    @FXML
    public Text result;
    @FXML
    public Text contextHelp;
    @FXML
    public ImageView infoStartX;
    @FXML
    public ImageView infoEndX;
    @FXML
    public ImageView infoStep;
    @FXML
    public ImageView infoAccuracy;
    @FXML
    private void onSaveClick() {
        if (function == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Notification window");
            alert.setHeaderText("Что то не так =/");
            alert.setContentText("Что б сохранить функцию, вы должны её сгенерировать");
            alert.showAndWait();
        } else {
            fileSystem.setInitialFileName("FuncGraph_" + new Date().getTime());
            fileSystem.setTitle("Сохранить как...");
            var file = fileSystem.showSaveDialog(getStage());
            if (file != null) {
                var json = gson.toJson(generateModel());
                System.out.println(json);
                new FileManager(file).saveToFile(json);
            }
        }
    }
    @FXML
    private void onLoadClick() {
        fileSystem.setTitle("Загрузить данные из файла");
        var file = fileSystem.showOpenDialog(getStage());
        var data = "";
        if (file != null) {
            var raw = new FileManager(file).loadFromFile();
            for (var str : raw) {
                data += str;
            }
            var model = gson.fromJson(data, MathModel.class);
            startX.setText(String.format("%.2f", model.getStartX()) + "");
            endX.setText(String.format("%.2f", model.getEndX()) + "");
            step.setText(String.format("%.2f", model.getStep()) + "");
            accuracy.setText(String.format("%.2f", model.getAccuracy()) + "");
            updateFunction();
        }
    }
    @FXML
    private void onCalculateClick() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Notification window");
        alert.setHeaderText("Что то не так =/");
        if (!endX.getText().isEmpty()) {
            if (Double.parseDouble(endX.getText()) >= Double.parseDouble(startX.getText())) {
                validateArguments();
                updateFunction();
                if (function != null) {
                    var maxPoints = 1000;
                    var fullPath = 0.0;
                    if (function.getStartX() < 0 && function.getEndX() < 0) {
                        fullPath = Math.abs(function.getStartX()) + function.getEndX();
                    } else {
                        fullPath = Math.abs(function.getStartX() - function.getEndX());
                    }
                    var step = fullPath / maxPoints;
                    var minY = 0.0;
                    var maxY = 0.0;
                    var series = new XYChart.Series<Number, Number>();
                    for (var x = function.getStartX(); x <= function.getEndX(); x += step) {
                        var y = function.calculate(x);
                        if (x == function.getStartX()) {
                            minY = y;
                            maxY = y;
                        } else if (y > maxY) {
                            maxY = y;
                        } else if (y < minY) {
                            minY = y;
                        }
                        series.getData().add(new XYChart.Data<Number, Number>(x, y));
                    }
                    graph.getData().clear();
                    graph.getData().add(series);
                    graph.setCreateSymbols(false);
                    result.setText("min x = " + DivideMethod.findMin(function));
                }
            } else {
                alert.setContentText("Конец функции не может быть меньше начала");
                alert.showAndWait();
            }
        } else {
            alert.setContentText("Вы не ввели значение максимума функции");
            alert.showAndWait();
        }
    }
    private void validateArguments() {
        startX.setText(startX.getText().replace(',', '.'));
        endX.setText(endX.getText().replace(',', '.'));
        step.setText(step.getText().replace(',', '.'));
        accuracy.setText(accuracy.getText().replace(',', '.'));
    }
    private void updateFunction() {
        function = generateModel();
    }
    public MathModel generateModel() throws NumberFormatException {
        double step = Double.parseDouble(this.step.getText());
        double start = Double.parseDouble(startX.getText());
        double accuracy = Double.parseDouble(this.accuracy.getText());
        double end = Double.parseDouble(endX.getText());
        return new MathModel(start, end, accuracy, step);
    }
    @FXML
    private void onHoverStop() {
        contextHelp.setVisible(false);
    }
    private Stage getStage() {
        return (Stage) pane.getScene().getWindow();
    }
    public void onAccuracyHover() {
        contextHelp.setText("Допустимая погрешность");
        contextHelp.setVisible(true);
    }
    public void onStartHover() {
        contextHelp.setText("Начальная точка поиска");
        contextHelp.setVisible(true);
    }
    public void onEndHover() {
        contextHelp.setText("Финальная точка поиска");
        contextHelp.setVisible(true);

    }
    public void onStepHover() {
        contextHelp.setText("Начальный шаг поиска");
        contextHelp.setVisible(true);
    }
    public void OnMouseClickAbout(MouseEvent mouseEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Author: ");
        alert.setContentText("Oleh Pakhomov (KN-421c)");
        alert.showAndWait();
    }
}
