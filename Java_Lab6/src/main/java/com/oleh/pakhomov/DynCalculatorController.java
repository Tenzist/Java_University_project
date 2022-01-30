package com.oleh.pakhomov;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class DynCalculatorController {
    @FXML
    private TextField argumentA;
    private final String defaultArgA = "4";

    @FXML
    private TextField argumentB;
    private final String defaultArgB = "6";

    @FXML
    private TextArea errText;

    @FXML
    private TextArea functionF;
    private final String defaultF = "return x;";

    @FXML
    private TextArea functionG;
    private final String defaultG = "return x;";

    @FXML
    private TextField startRange;
    private final String defaultStartRange = "-1.5";

    @FXML
    private TextField endRange;
    private final String defaultEndRange = "2";

    @FXML
    private LineChart<Number, Number> graph;

    @FXML
    private NumberAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    private Object userF;
    private Object userG;

    @FXML
    private void onCalcClick() {
        try {
            updateFunctions();
            var start = Double.parseDouble(startRange.getText());
            var end = Double.parseDouble(endRange.getText());
            var maxPoints = 1000;
            var step = (end - start) / maxPoints;
            var minY = 0.0;
            var maxY = 0.0;
            var series = new XYChart.Series<Number, Number>();
            for (var x = start; x <= end; x += step) {
                var y = mainFunction(x);
                if (x == start) {
                    minY = y;
                    maxY = y;
                } else if (y > maxY) {
                    maxY = y;
                } else if (y < minY) {
                    minY = y;
                }
                series.getData().add(new XYChart.Data<Number, Number>(x, y));
            }
            graph.getData().add(series);
            graph.setCreateSymbols(false);
            errText.clear();
        } catch (Exception e) {
            errText.setText(e.getMessage());
        }
    }

    @FXML
    private void onClearClick() {
        graph.getData().clear();
        argumentA.setText(defaultArgA);
        argumentB.setText(defaultArgB);
        functionF.setText(defaultF);
        functionG.setText(defaultG);
        startRange.setText(defaultStartRange);
        endRange.setText(defaultEndRange);
        errText.clear();
    }

    private void updateFunctions() throws Exception {
        userF = InlineCompiler.getFunction(
                FuncGeneration.generateCodeFunctionF(this.functionF.getText()),
                "FunctionF"
        );

        userG = InlineCompiler.getFunction(
                FuncGeneration.generateCodeFunctionG(this.functionG.getText()),
                "FunctionG"
        );
    }

    private double calculateObjHelper(Object obj, double x) throws Exception {
        Exception ex;
        try {
            var methods = Arrays.asList(obj.getClass().getMethods());
            var clazz = Double.valueOf(x).getClass();
            var method = obj.getClass().getMethod("calculate", clazz);
            return (double) method.invoke(obj, x);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
            ex = e;
        }
        throw ex;
    }

    private double mainFunction(double x) throws Exception {
        var a = Double.parseDouble(argumentA.getText());
        var b = Double.parseDouble(argumentB.getText());
        var userFResult = calculateObjHelper(userF, a / x);
        var userGResult = calculateObjHelper(userG, b / x);
        return userFResult + userGResult;
    }

}