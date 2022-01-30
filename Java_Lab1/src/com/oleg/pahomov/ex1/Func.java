package com.oleg.pahomov.ex1;

public class Func {
    public static double calc(double x) {
        if (x <= 5.0) {
            double result = 1;
            int n = 7;
            for (int k = 1; k <= n; k++) {
                result *= Math.pow(Math.sin(0.5 * x - 2.5), k);
                System.out.println(result);
            }
            return x + result;
        } else {
            double sqrt = Math.sqrt(Math.sqrt(x - 4));
            return (sqrt / Math.pow(Math.E, x - 5)) + 4;
        }
    }
}