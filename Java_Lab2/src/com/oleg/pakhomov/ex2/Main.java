package com.oleg.pakhomov.ex2;

public class Main {
    public static void main(String[] args) {
        int n = 300;
        boolean num[] = new boolean[n + 1];
        for (int i = 0; i <= n; i++)
            num[i] = true;

        for (int p = 2; p * p <= n; p++)
        {
            if (num[p] == true)
            {
                for (int i = p * p; i <= n; i += p)
                    num[i] = false;
            }
        }
        for (int i = 2; i <= n; i++)
        {
            if (num[i] == true)
                System.out.println(i);
        }
    }
}
