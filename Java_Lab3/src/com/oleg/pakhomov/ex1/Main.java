package com.oleg.pakhomov.ex1;

import java.io.FileNotFoundException;
import java.util.*;

public class Main extends Sorting {

    public static void main(String[] args) throws FileNotFoundException {
        Sorting sorting = new Sorting();
        sorting.defaultBands();

        System.out.println("Просто Список" + sorting.Default());
        System.out.println("Сортировка по концертам" + sorting.SortByConcert());
        System.out.println("Сортировка по городам" + sorting.SortByName());

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название Города: ");
        String category = scanner.nextLine();
        System.out.println("Ваш город: "  + sorting.FindLetter(category));

    }
}


