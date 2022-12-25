package com.patriciamolnar;

import java.util.Scanner;

public class StringReverser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        StringReverser reverser = new StringReverser(); 

        System.out.println(Ansi.ANSI_CYAN + "===========================" + Ansi.ANSI_RESET);
        System.out.println(Ansi.ANSI_CYAN + "Let's reverse some strings!" + Ansi.ANSI_RESET);
        System.out.println(Ansi.ANSI_CYAN + "===========================" + Ansi.ANSI_RESET);
        System.out.println(Ansi.ANSI_GREEN + "Please enter a word / sentence" + Ansi.ANSI_RESET);
        String word = scanner.nextLine(); 
        String reversedWord = reverser.reverseString(word);

        System.out.println(Ansi.ANSI_GREEN + "And the result is: "+ Ansi.ANSI_RESET + reversedWord);
        scanner.close();
    }

    String reverseString(String word) {
        int length = word.length(); 
        String reversed = ""; 
        for(int i = 0; i < length; i++) {
            reversed = word.charAt(i) + reversed;
        }
        return reversed;
    }
}
