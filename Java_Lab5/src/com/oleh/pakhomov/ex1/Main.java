package com.oleh.pakhomov.ex1;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.*;

public class Main{

    public static void main(String[] args) throws FileNotFoundException {
        JFrame frame = new JFrame("MyPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new MyPanel());
        frame.pack();
        frame.setVisible(true);
    }
}


