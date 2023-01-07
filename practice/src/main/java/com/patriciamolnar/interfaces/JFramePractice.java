package com.patriciamolnar.interfaces;

import java.awt.*;
import javax.swing.JFrame;

public class JFramePractice extends JFrame {
    public JFramePractice() {
        super("Demo of JFrame");
    }

    public static void main(String[] args) {
        JFramePractice frame = new JFramePractice();

        /* setLayout
         * default: BorderLayout 
         */
        frame.setLayout(new GridBagLayout());
    }
}

/*
 * Alternative initiation of JFrame
 * Instead of extending, just use JFrame frame = new JFrame("Some string that should be the title"); 
 */
