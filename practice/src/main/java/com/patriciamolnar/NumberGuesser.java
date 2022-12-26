package com.patriciamolnar;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class NumberGuesser {
    private final int MIN = 1; 
    private final int MAX = 10; 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); 
        NumberGuesser guesser = new NumberGuesser(); 
        int solution = guesser.generateRandomNumber(); 
        int guess; 

        guesser.showIntro(); 

        do {
            guess = input.nextInt(); 
        } while (guesser.checkGuess(guess, solution));

        System.out.println(Ansi.ANSI_GREEN + "You got it! Thanks for playing ^_^" + Ansi.ANSI_RESET);
        input.close(); 
    }

    private void showIntro() {
        System.out.println(Ansi.ANSI_GREEN + "===================================");
        System.out.println("Welcome to the number guessing game");
        System.out.println("===================================");
        System.out.println("You will need to guess a number between 1 - 10 (inclusive). So let's go!");
        System.out.println("Type in your first guess:" + Ansi.ANSI_RESET);
    }

    private boolean checkGuess(int guess, int solution) {
        if(guess != solution) {
            System.out.println(Ansi.ANSI_RED + "Wrong! Try again:" + Ansi.ANSI_RESET);
            return true;
        } else {
            return false; 
        }
    }

    private int generateRandomNumber() {
        return ThreadLocalRandom.current().nextInt(MIN, MAX + 1);
    }
}