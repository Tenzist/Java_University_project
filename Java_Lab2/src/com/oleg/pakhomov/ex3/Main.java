package com.oleg.pakhomov.ex3;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите до кокого количества: ");
        int n = scan.nextInt();
        long a = 0, b = 1, c;
        if (n == 0){
            System.out.println(0);
        }
        for (int i = 1; i <= n; i++) {
            System.out.println(a);
            c = a + b;
            a = b;
            b = c;
        }
    }
}

