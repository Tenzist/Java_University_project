package com.oleg.pakhomov.ex2;

import java.io.FileNotFoundException;

public class Sort implements Comparator {
    public Sort() throws FileNotFoundException {
    }
    GetArray g = new GetArray();
    int [] arr = g.GetArray();

    @Override
    public int summ() {
        int sum = 0;
        for(int num : arr){
            sum += num;
        }
        return sum;
    }

    @Override
    public int[] upSort() {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }

    @Override
    public int[] downSort() {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }
}
