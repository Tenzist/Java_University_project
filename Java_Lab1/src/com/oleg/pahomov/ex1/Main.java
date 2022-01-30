package com.oleg.pahomov.ex1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("x: ");
        Scanner scanner = new Scanner(System.in);
        System.out.println("y: " + Func.calc(scanner.nextDouble()));
    }
}

