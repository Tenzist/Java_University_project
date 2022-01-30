package com.oleg.pakhomov.ex3;

public abstract class AbstactClass {

    public abstract void setPoint(int i, double x, double y);
    public abstract double getX(int i);
    public abstract double getY(int i);
    public abstract int count();

    public abstract void addPoint(double x, double y);
    public abstract void removeLast();

    public void sortByX() {
        boolean mustSort;
        do {
            mustSort = false;
            for (int i = 0; i < count() - 1; i++) {
                if (getX(i) > getX(i + 1)) {
                    double x = getX(i);
                    double y = getY(i);
                    setPoint(i, getX(i + 1), getY(i + 1));
                    setPoint(i + 1, x, y);
                    mustSort = true;
                }
            }
        }
        while (mustSort);
    }
    @Override
    public String toString() {
        String s = " ";
        for (int i = 0; i < count(); i++) {
            s += "x = " + getX(i) + "\ty = " + getY(i) + "\n";
        }
        return s + "\n";
    }

    public void test() {
        addPoint(33, 1);
        addPoint(58, 11);
        addPoint(21, 45);
        addPoint(-8, 31);
        sortByX();
        System.out.println(this);
    }
}