package com.oleg.pakhomov.ex6;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите x1");
        double a = scan.nextDouble();
        System.out.println("Введите x2");
        double b = scan.nextDouble();
        System.out.println("Введите x3");
        double c = scan.nextDouble();

        Equation equation = new Equation();
        equation.solve(a, b, c);
        System.out.println("D = " + equation.getD());
        if(equation.getD() > 0) {
            System.out.println("x1 = " + equation.getX1());
            System.out.println("x2 = " + equation.getX2());
        }
        else if(equation.getD() == 0){
            System.out.println("x = " + equation.getX());
        }
        else{
            System.out.println("Так как дискриминант меньше нуля, то уравнение не имеет действительных решений");
        }
    }

}

