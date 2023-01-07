package com.patriciamolnar.interfaces;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class TextFieldPractice {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Example");
        JTextField field = new JTextField("Hello world!"); 

        field.setBackground(Color.decode("#ccffcc"));
        field.setBounds(50, 35, 200, 50);

        frame.add(field);
        frame.setSize(300, 150);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.decode("#00cc99"));
    }
}
