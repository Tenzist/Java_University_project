package com.oleh.pakhomov.ex2;

enum Month {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;
    @Override
    public String toString() {
        return name() + " " + ordinal();
    }
    Month next() {
        Month month = values()[(ordinal() + 1) % values().length];
        return month;
    }
    String season() {
        switch (this) {
            case DECEMBER:
            case JANUARY:
            case FEBRUARY:
                return "Winter";
            case MARCH:
            case APRIL:
            case MAY:
                return "Spring";
            case JUNE:
            case JULY:
            case AUGUST:
                return "Summer";
            case SEPTEMBER:
            case OCTOBER:
            case NOVEMBER:
                return "Autumn";
            default:
                return null;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Month d = Month.DECEMBER;
        for (int i = 0; i < 12; i++) {
            d = d.next();
            System.out.println(d + " " + d.season());
        }
    }
}