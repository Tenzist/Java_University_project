package com.oleh.pakhomov.ex4;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame{
    private JButton button = new JButton("Calculate");
    private JTextField input = new JTextField("",5);
    private JLabel label = new JLabel("Input first number:");
    private JTextField input2 = new JTextField("",5);
    private JLabel label2 = new JLabel("Input second number:");
    private JTextField input3 = new JTextField("",5);
    private JLabel resault = new JLabel("Resault:");
    private JRadioButton rbPlus = new JRadioButton("+");
    private JRadioButton rbMinus = new JRadioButton("-");
    private JRadioButton rbMultiply = new JRadioButton("*");
    private JRadioButton rbDivide = new JRadioButton("/");

    public GUI(){
        super("Calculator");
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(500,250,250,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(5,2,2,2));
        container.add(label);
        container.add(input);
        container.add(label2);
        container.add(input2);
        ButtonGroup group = new ButtonGroup();
        group.add(rbPlus);
        group.add(rbMinus);
        group.add(rbMultiply);
        group.add(rbDivide);
        container.add(rbPlus);
        rbPlus.setSelected(true);
        container.add(rbMinus);
        container.add(rbMultiply);
        container.add(rbDivide);

        button.addActionListener(new ButtonEvent());
        container.add(button);
        container.add(input3);
        input3.setEditable(false);
    }

    class ButtonEvent implements ActionListener{
        public void actionPerformed (ActionEvent e){
            String result = "";
            double num1 = Double.parseDouble(input.getText());
            double num2 = Double.parseDouble(input2.getText());
            if (rbPlus.isSelected()){
                result += num1 + num2;
            }else if (rbMinus.isSelected()){
                result += num1 - num2;
            }else if(rbMultiply.isSelected()){
                result += num1 * num2;
            }else if(rbDivide.isSelected()){
                result += num1 / num2;
            }
            input3.setText(result);
        }
    }
}
