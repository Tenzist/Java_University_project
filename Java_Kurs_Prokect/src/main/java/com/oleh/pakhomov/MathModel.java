package com.oleh.pakhomov;

public class MathModel{
    public double startX;
    public double endX;
    public double accuracy;
    public double step;

    public MathModel(double startX, double endX, double accuracy, double step) {
        this.startX = startX;
        this.endX = endX;
        this.accuracy = accuracy;
        this.step = step;
    }

    public double getStartX() {
        return startX;
    }

    public double getEndX() {
        return endX;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public double getStep() {
        return step;
    }

    public void setStep(double step) {
        this.step = step;
    }

    public static double calculate(double x) {
        return Math.pow((Math.PI - 2)
                , (3 * Math.pow(x, 4.0)) - (8 * Math.pow(x, 3.0)) + 16);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathModel mathModel = (MathModel) o;
        if (Double.compare(mathModel.startX, startX) != 0) return false;
        if (Double.compare(mathModel.endX, endX) != 0) return false;
        return Double.compare(mathModel.accuracy, accuracy) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(startX);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(endX);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(accuracy);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "MathModel{" +
                "startX=" + startX +
                ", step=" + endX +
                ", accuracy=" + accuracy +
                '}';
    }
}
