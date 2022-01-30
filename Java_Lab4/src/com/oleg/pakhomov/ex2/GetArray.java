package com.oleg.pakhomov.ex2;

import java.io.*;
import java.util.*;

public class GetArray {

    public int[] GetArray() throws FileNotFoundException {
        String filename = "numbers.txt";
        Scanner s = new Scanner(new File(filename));
        String [] str = s.nextLine().split(" ");
        int [] arr = new int[str.length];
        for(int i = 0;i < str.length;i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        return arr;
    }

}
