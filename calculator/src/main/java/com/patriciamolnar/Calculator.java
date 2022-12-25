package com.patriciamolnar;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        int operand = 0;
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator(); 

        try {
            System.out.println("Welcome to Patricia's first Java Calculater!");
            System.out.println("Please enter your 1st number:");
            float x = scanner.nextFloat(); 
            System.out.println("Thanks! Please enter the 2nd number:");
            float y = scanner.nextFloat(); 
            do {
                calculator.printOptions(operand);
                operand = scanner.nextInt();
            } while (operand < 0 || operand > 5);
            
            String result = calculator.calculate(x, y, operand);
            System.out.println(result);
        } 
        catch (InputMismatchException ime) {
            System.out.println("You messed up! I'm gonna quit on you! Bye...");
        }
        finally {
            scanner.close();
        }
    }

    void printOptions(int operand) {
        System.out.println("Now please choose one of the following operations");
        System.out.println("Press 1 for ADDITION");
        System.out.println("Press 2 for SUBTRACTION");
        System.out.println("Press 3 for MULTIPLICATION");
        System.out.println("Press 4 for DIVISION");
        System.out.println("Press 5 for MODULUS");
    }

    String calculate(float x, float y, int operand) {
        String result;
        switch(operand) {
            case 1: {
                result = "The result of " + x + " + " + y + " is " + Float.sum(x, y); 
                break;
            }
            case 2: {
                result = "The result of " + x + " - " + y + " is " + (x - y); 
                break;
            }
            case 3: {
                result = "The result of " + x + " * " + y + " is " + (x * y); 
                break;
            }
            case 4: {
                result = "The result of " + x + " / " + y + " is " + (x / y); 
                break;
            }
            case 5: {
                result = "The result of " + x + " % " + y + " is " + (x % y);
                break;
            }
            default: {
                result = "The result of " + x + " + " + y + " is " + (x + y);
            }
        }

        return result; 
    }
    
}
