package com.patriciamolnar.games.Snake;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Snake extends JFrame {
    public Snake() {
        initUI(); 
    }

    private void initUI() {
        add(new Board());

        setResizable(false);
        pack(); 

        setTitle("Snake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame ex = new Snake();
            ex.setVisible(true);
        });
    }

}

/*
 * Notes: 
 * JFrame: is a Swing top-level container that reders a window on screen. 
 * A frame is a base window on which other components rely, e.g. menu bar, panels, labels, text fields, buttons
 * Almost all Swing applications start with a JFrame window
 */
