package com.oleh.pakhomov.ex1;

import javafx.stage.FileChooser;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class MyPanel extends JPanel {
    Sorting sorting = new Sorting();
    FileWrite fileWrite = new FileWrite();
    private JButton sortingButton = new JButton("Sort!");
    private JTextArea output = new JTextArea();
    private JRadioButton rbDef = new JRadioButton("Default");
    private JRadioButton rbConc = new JRadioButton("By Concert");
    private JRadioButton rbCity = new JRadioButton("By City Name");
    private JTextField name = new JTextField(1);
    private JTextField owner = new JTextField(1);
    private JTextField city = new JTextField(1);
    private JTextField amount = new JTextField(1);
    private JTextField year = new JTextField(1);
    private JLabel lablename = new JLabel("Name");
    private JLabel lableowner = new JLabel("Owner");
    private JLabel lablecity = new JLabel("City");
    private JLabel lableconcert = new JLabel("Concert");
    private JLabel lableyear = new JLabel("Year");
    private JButton buttonAdd = new JButton("Add");
    private JButton buttonDefaultGen = new JButton("GenDefault");
    private JLabel lableresult = new JLabel("Result");
    private JScrollPane scroll = new JScrollPane();
    private JButton buttonLoad = new JButton("↓");
    private JButton buttonSave = new JButton("↑");
    private FileChooser fileChooser = new FileChooser();
    private JButton about = new JButton ("About");

    public MyPanel() {
        setPreferredSize(new Dimension(586, 391));
        setLayout(null);

        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        output.setBorder(new LineBorder(Color.BLACK));
        scroll.getViewport().add(output);
        fileChooser.setTitle("Open Resource File");
        ButtonGroup group = new ButtonGroup();
        group.add(rbDef);
        group.add(rbConc);
        group.add(rbCity);
        rbDef.setSelected(true);
        output.setEditable(false);
        sortingButton.addActionListener(new MyPanel.ButtonEvent());
        buttonAdd.addActionListener(new MyPanel.AddEvent());
        buttonDefaultGen.addActionListener(new MyPanel.DefGen());
        buttonLoad.addActionListener(new MyPanel.Download());
        buttonSave.addActionListener(new MyPanel.Upload());
        about.addActionListener(new MyPanel.About());
        output.setText("");

        add(sortingButton);
        add(scroll);
        add(rbDef);
        add(rbConc);
        add(rbCity);
        add(name);
        add(owner);
        add(city);
        add(amount);
        add(year);
        add(lablename);
        add(lableowner);
        add(lablecity);
        add(lableconcert);
        add(lableyear);
        add(buttonAdd);
        add(buttonDefaultGen);
        add(lableresult);
        add(buttonLoad);
        add(buttonSave);
        add (about);

        sortingButton.setBounds(215, 195, 150, 35);
        output.setBounds(10, 235, 565, 150);
        scroll.setBounds(10, 235, 565, 150);
        rbDef.setBounds(20, 25, 100, 25);
        rbConc.setBounds(20, 70, 100, 25);
        rbCity.setBounds(20, 110, 100, 25);
        name.setBounds(475, 15, 100, 25);
        owner.setBounds(475, 40, 100, 25);
        city.setBounds(475, 65, 100, 25);
        amount.setBounds(475, 90, 100, 25);
        year.setBounds(475, 115, 100, 25);
        lablename.setBounds(395, 15, 100, 25);
        lableowner.setBounds(395, 40, 100, 25);
        lablecity.setBounds(395, 65, 100, 25);
        lableconcert.setBounds(395, 90, 100, 25);
        lableyear.setBounds(395, 115, 100, 25);
        buttonAdd.setBounds(395, 145, 180, 30);
        buttonDefaultGen.setBounds(10, 145, 180, 30);
        lableresult.setBounds(10, 210, 100, 25);
        buttonLoad.setBounds(255, 75, 70, 50);
        buttonSave.setBounds(255, 15, 70, 50);
        about.setBounds (505, 210, 70, 20);


        amount.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                    amount.setEditable(true);
                } else if (ke.getKeyCode() == KeyEvent.VK_BACK_SPACE || ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    amount.setEditable(true);
                } else {
                    amount.setEditable(false);
                }
            }
        });
        year.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                    year.setEditable(true);
                } else if (ke.getKeyCode() == KeyEvent.VK_BACK_SPACE || ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    year.setEditable(true);
                } else {
                    year.setEditable(false);
                }
            }
        });
    }

    class ButtonEvent implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String result = "";
            if (!sorting.bandtour.isEmpty()) {
                if (rbDef.isSelected()) {
                    result += sorting.Default();
                } else if (rbConc.isSelected()) {
                    result += sorting.SortByConcert();
                } else if (rbCity.isSelected()) {
                    result += sorting.SortByName();
                }
                output.setText(result);
            } else {
                output.setText("Nothing to Sort");
            }
        }
    }

    class DefGen implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String result = "";
            sorting.defaultBands();
            result += sorting.bandtour;
            output.setText(result);
            buttonDefaultGen.setEnabled(false);
        }
    }

    class AddEvent implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String result = "";
            if (name.getText().isEmpty() || owner.getText().isEmpty()
                    || city.getText().isEmpty() || amount.getText().isEmpty()
                    || year.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "You need to feel ALL feelds", "Error", JOptionPane.PLAIN_MESSAGE);
            } else {
                String gname = name.getText();
                String gowner = owner.getText();
                String gcity = city.getText();
                int gamount = Integer.parseInt(amount.getText());
                int gyear = Integer.parseInt(year.getText());
                sorting.bandtour.add(sorting.createBand(gname, gowner, gcity, gamount, gyear));
                result += sorting.bandtour;
                output.setText(result);
                name.setText("");
                owner.setText("");
                city.setText("");
                amount.setText("");
                year.setText("");
            }
        }
    }
    class Download implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String filename = "BandsTour.txt";
            try {
                fileWrite.read(filename, sorting.bandtour);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            String result = "";
            result += sorting.bandtour;
            output.setText(result);
        }
    }
    class Upload implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            fileWrite.write(sorting.bandtour);
        }
    }
    class About implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Group: KN-421C \nCreator: Pakhomov Oleh\n", "About", JOptionPane.PLAIN_MESSAGE);
        }
    }
}



