package com.oleg.pakhomov.ex5;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String line = scan.nextLine();
//        String line = "Hello my name is oleh";
        String[] words = line.split(" ");
        for(int i = 0;i < words.length;i++){
            words[i] = words[i].substring(0,1);
            System.out.println(words[i].toUpperCase(Locale.ROOT));
        }
    }
}
