package com.patriciamolnar;

import java.awt.*;
import java.awt.event.*;

public class ALPractice extends Frame implements ActionListener, WindowListener {
    TextField text = new TextField(20); 
    Button b; 
    private int numClicks = 0; 
    public static void main(String[] args) {
        ALPractice window = new ALPractice("My first window");
        window.setSize(350, 100); 
        window.setVisible(true);
    }

    public ALPractice(String title) {
        super(title); 
        setLayout(new FlowLayout());
        addWindowListener(this);
        b = new Button("Click me"); 
        add(b);
        add(text); 
        b.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        numClicks++; 
        text.setText("Button clicked: " + numClicks + " times.");
    }

    public void windowClosing(WindowEvent e) {
        dispose(); 
        System.exit(0);
    }

    public void windowOpened(WindowEvent e) {
        System.out.println("Window opened");
    }

    public void windowActivated(WindowEvent e) {
        System.out.print("Window activated");
    }

    public void windowIconified(WindowEvent e) {
        System.out.print("Window iconified");
    }

    public void windowDeiconified(WindowEvent e) {
        System.out.print("Window deiconified");
    }

    public void windowDeactivated(WindowEvent e) {
        System.out.print("Window deactivated");
    }

    public void windowClosed(WindowEvent e) {
        System.out.print("Window closed");
    }
}
