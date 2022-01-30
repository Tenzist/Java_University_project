package com.oleh.pakhomov.ex1;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileWrite {

    public void write(ArrayList<BandsTour> arrayList) {
        try (FileWriter writer = new FileWriter("Sorted.txt", false)) {
            Sorting sorting = new Sorting();
            sorting.bandtour = (ArrayList<BandsTour>) arrayList.clone();
            writer.write("Просто Список" + sorting.Default() + "\n");
            writer.write("Сортировка по концертам" + sorting.SortByConcert() + "\n");
            writer.write("Сортировка по городам" + sorting.SortByName() + "\n");
            System.out.println("Записано в файл!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public ArrayList<BandsTour> read(String filename, ArrayList<BandsTour> arrayList) throws FileNotFoundException {
        Sorting sorting = new Sorting();
        try {
            Scanner s = new Scanner(new File(filename));
            while (s.hasNextLine()) {
                String[] str = s.nextLine().split(" ");
                if (str.length == 5) {
                    String name = str[0];
                    String owner = str[1];
                    String city = str[2];
                    int amount = Integer.parseInt(str[3]);
                    int year = Integer.parseInt(str[4]);
                    arrayList.add(sorting.createBand(name, owner, city, amount, year));
                } else System.out.println("wrong parrametrs on file");
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        return arrayList;
    }
}
