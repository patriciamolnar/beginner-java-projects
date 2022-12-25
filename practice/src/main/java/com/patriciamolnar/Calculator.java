package com.patriciamolnar;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        int operand = 0;
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator(); 

        try {
            System.out.println(Ansi.ANSI_PURPLE + "===============================================" + Ansi.ANSI_RESET);
            System.out.println(Ansi.ANSI_PURPLE + "Welcome to Patricia's first Java Calculater! ♥" + Ansi.ANSI_RESET);
            System.out.println(Ansi.ANSI_PURPLE + "===============================================" + Ansi.ANSI_RESET);
            System.out.println(Ansi.ANSI_BLUE + "Please enter your 1st number:" + Ansi.ANSI_RESET);
            float x = scanner.nextFloat(); 
            System.out.println(Ansi.ANSI_BLUE + "Thanks! Please enter the 2nd number:" + Ansi.ANSI_RESET);
            float y = scanner.nextFloat(); 
            do {
                calculator.printOptions(operand);
                operand = scanner.nextInt();
            } while (operand < 0 || operand > 5);
            
            String result = calculator.calculate(x, y, operand);
            System.out.println(Ansi.ANSI_PURPLE + result + Ansi.ANSI_RESET);
        } 
        catch (InputMismatchException ime) {
            System.out.println(Ansi.ANSI_RED + "You messed up! I'm gonna quit on you! Bye..." + Ansi.ANSI_RESET);
        }
        finally {
            scanner.close();
        }
    }

    void printOptions(int operand) {
        System.out.println(Ansi.ANSI_BLUE + "Now please choose one of the following operations" + Ansi.ANSI_RESET);
        System.out.println("Press + " + Ansi.ANSI_BLUE + "1" + Ansi.ANSI_RESET + " for " + Ansi.ANSI_BLUE + "addition" + Ansi.ANSI_RESET);
        System.out.println("Press + " + Ansi.ANSI_BLUE + "2" + Ansi.ANSI_RESET + " for " + Ansi.ANSI_BLUE + "subtraction" + Ansi.ANSI_RESET);
        System.out.println("Press + " + Ansi.ANSI_BLUE + "3" + Ansi.ANSI_RESET + " for " + Ansi.ANSI_BLUE + "multiplication" + Ansi.ANSI_RESET);
        System.out.println("Press + " + Ansi.ANSI_BLUE + "4" + Ansi.ANSI_RESET + " for " + Ansi.ANSI_BLUE + "division" + Ansi.ANSI_RESET);
        System.out.println("Press + " + Ansi.ANSI_BLUE + "5" + Ansi.ANSI_RESET + " for " + Ansi.ANSI_BLUE + "modulus" + Ansi.ANSI_RESET);
    }

    String calculate(float x, float y, int operand) {
        String result;
        switch(operand) {
            case 1: {
                result = "The result of " + x + " + " + y + " is " + Float.sum(x, y) + "."; 
                break;
            }
            case 2: {
                result = "The result of " + x + " - " + y + " is " + (x - y) + "."; 
                break;
            }
            case 3: {
                result = "The result of " + x + " * " + y + " is " + (x * y) + "."; 
                break;
            }
            case 4: {
                result = "The result of " + x + " / " + y + " is " + (x / y) + "."; 
                break;
            }
            case 5: {
                result = "The result of " + x + " % " + y + " is " + (x % y) + ".";
                break;
            }
            default: {
                result = "The result of " + x + " + " + y + " is " + (x + y) + ".";
            }
        }

        return result; 
    }
    
}
