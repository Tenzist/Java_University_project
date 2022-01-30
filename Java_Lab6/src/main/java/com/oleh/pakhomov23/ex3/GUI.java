package com.oleh.pakhomov23.ex3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUI extends JPanel {
    private JButton button;
    private JTextArea result;
    private JLabel lableFrom;
    private JLabel lableTo;
    private JTextField firstnum;
    private JTextField secondnum;
    private JScrollPane scroll;

    public GUI() {
        button = new JButton("Generate");
        result = new JTextArea(5, 5);
        lableFrom = new JLabel("From:");
        lableTo = new JLabel("To:");
        firstnum = new JTextField(5);
        secondnum = new JTextField(5);
        scroll = new JScrollPane();

        setPreferredSize(new Dimension(481, 427));
        setLayout(null);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.getViewport().add(result);

        add(button);
        add(scroll);
        add(lableFrom);
        add(lableTo);
        add(firstnum);
        add(secondnum);

        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PrimeFinder primeFinder = new PrimeFinder();
                if (firstnum.getText().isEmpty() || secondnum.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "You need to feel ALL feelds", "Error", JOptionPane.PLAIN_MESSAGE);
                } else {
                    int from = Integer.parseInt(firstnum.getText());
                    int to = Integer.parseInt(secondnum.getText());
                    String s = "";
                    for(int i : primeFinder.getAllPrimes(from,to)){
                        s += i + "\n";
                    }
                    result.setText(s);
                }
            }
        });

        firstnum.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                    firstnum.setEditable(true);
                } else if (ke.getKeyCode() == KeyEvent.VK_BACK_SPACE || ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    firstnum.setEditable(true);
                } else {
                    firstnum.setEditable(false);
                }
            }
        });
        secondnum.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                    secondnum.setEditable(true);
                } else if (ke.getKeyCode() == KeyEvent.VK_BACK_SPACE || ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    secondnum.setEditable(true);
                } else {
                    secondnum.setEditable(false);
                }
            }
        });


        button.setBounds(10, 340, 185, 75);
        scroll.setBounds(205, 5, 270, 420);
        result.setBounds(205, 5, 270, 420);
        lableFrom.setBounds(10, 5, 100, 25);
        lableTo.setBounds(10, 55, 100, 25);
        firstnum.setBounds(10, 30, 185, 25);
        secondnum.setBounds(10, 75, 185, 25);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MyPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new GUI());
        frame.pack();
        frame.setVisible(true);
    }
}
