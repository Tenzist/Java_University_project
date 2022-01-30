package com.oleg.pahomov.ex3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Введите факториал n: ");
        Scanner scanner = new Scanner(System.in);
        int factorial = scanner.nextInt();
        if (factorial < 0) {
            System.out.println("AHTUNG!!!!");
            return;
        }
        long res = 1;
        // Цикл
        for (int i = 1; i <= factorial; i++) {
            res *= i;
        }
        System.out.println("Цикл: " + res);
        System.out.println("Рекурсия: " + recur(factorial));
    }
    public static long recur(int n) {
        if (n == 1) return 1;
        else {
            return n * recur(n - 1);
        }
    }
}
