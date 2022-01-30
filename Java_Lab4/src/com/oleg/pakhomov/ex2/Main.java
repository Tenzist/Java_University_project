package com.oleg.pakhomov.ex2;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Comparator sort = new Sort();
        System.out.println(Arrays.toString(sort.upSort()));
        try (FileWriter writerUp = new FileWriter("upSortNumb.txt", false)) {
            writerUp.write(Arrays.toString(sort.upSort()));
            writerUp.write(" Summ = " + sort.summ());
            System.out.println("Массив 1 → 9 записан в файл!");
        }
        System.out.println(Arrays.toString(sort.downSort()));
        try (FileWriter writerDown = new FileWriter("downSortNumb.txt", false)) {
            writerDown.write(Arrays.toString(sort.downSort()));
            writerDown.write(" Summ = " + sort.summ());
            System.out.println("Массив 9 → 1 записан в файл!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
