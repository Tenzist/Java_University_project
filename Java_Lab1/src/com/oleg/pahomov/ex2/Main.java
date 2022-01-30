package com.oleg.pahomov.ex2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("Введите n от 0 до 10: ");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if (n < 0 || n > 10) {
            System.out.println("AHTUNG!!!!");
            return;
        }
        System.out.println("Арифметически:");
        int num = 8;
        int temp = num;
        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                System.out.println("8 в степени " +  i + " = " + 1);
            } else {
                if (i != 1) {
                    temp *= num;
                }
                System.out.println("8 в степени " + i + " = " + temp);
            }
        }
        System.out.println("Побитово:");
        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                System.out.println("8 в степени " + i + " = " + 1);
            } else {
                System.out.println("8 в степени " + i + " = " +(8 << 3 * (i - 1)));
            }
        }
    }
}
