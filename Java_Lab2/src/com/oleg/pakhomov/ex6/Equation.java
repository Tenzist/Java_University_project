package com.oleg.pakhomov.ex6;

public class Equation {
    private double a,b,c,d,x,x1,x2;

    public double getD() {
        return d;
    }

    public double getX1() {
        return x1;
    }

    public double getX2() {
        return x2;
    }

    public double getX() {
        return x;
    }

    void solve(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = b * b - 4 * a * c;
        this.x1 = (-b - Math.sqrt(d)) / (2 * a);
        this.x2 = (-b + Math.sqrt(d)) / (2 * a);
        this.x = -b /(2 * a);

    }
}
