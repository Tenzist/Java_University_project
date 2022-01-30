package com.oleg.pakhomov.ex4;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите сколько пробелов добавить: ");
        int n = scan.nextInt();
        System.out.print(n);
        for(int i = 0;i < n; i++){
            System.out.print(" ");
        }
        System.out.print("|");
    }
}

