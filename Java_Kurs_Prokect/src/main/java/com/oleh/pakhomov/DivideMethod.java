package com.oleh.pakhomov;

public class DivideMethod {
    public static double findMin(MathModel function) {
        var from = function.startX;
        var to = function.endX;
        var middle = 0.0;
        var notFinished = true;
        var step = function.step;
        do {
            var toAdd = (to - from) / 2;
            middle = from + toAdd;
            var startX = middle - step;
            var endX = middle + step;
            if (function.calculate(startX) < function.calculate(endX)) {
                to = endX;
            } else {
                from = startX;
            }
            if (from < 0 && to < 0) {
                notFinished = Math.abs(from) + to > function.accuracy;
            } else {
                notFinished = Math.abs(from - to) > function.accuracy;
            }
            step /= 2;
        } while (notFinished);
        return (to + from)/2;
    }
}
