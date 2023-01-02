package com.patriciamolnar.games.Snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {
    private final int BOARD_WIDTH = 300, 
                      BOARD_HEIGHT = 300,
                      DOT_SIZE = 10,
                      ALL_DOTS = 900, 
                      RAND_POS = 29,
                      DELAY = 140;

    private final int x[] = new int[ALL_DOTS], y[] = new int[ALL_DOTS]; 
    
    private int dots, apple_x, apple_y; 

    private boolean leftDir = false, 
                    rightDir = true, 
                    upDir = false, 
                    downDir = false, 
                    inGame = true;
    
    private Timer timer; 
    private Image dot, apple, head;

    public Board() {
        initBoard(); 
    }

    private void initBoard() {
        addKeyListener(new TAdapter());
    }

    public static void main(String[] args) {
        Board board = new Board(); 
        board.loadImages(); 
    }

    private void loadImages() {
        ImageIcon iia = new ImageIcon("practice/src/main/java/com/patriciamolnar/games/Snake/resources/apple.png");
        apple = iia.getImage(); 
        ImageIcon iid = new ImageIcon("practice/src/main/java/com/patriciamolnar/games/Snake/resources/dot.png");
        dot = iid.getImage();
        ImageIcon iih = new ImageIcon("practice/src/main/java/com/patriciamolnar/games/Snake/resources/head.png");
        head = iih.getImage(); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (inGame) {
            System.out.println("In Game");
            // checkApple();
            // checkCollision();
            // move();
        }

        repaint();
    }

    private class TAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode(); 
            System.out.println(key);
        }
    }
}
