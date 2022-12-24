package com.patriciamolnar;

import java.util.Scanner;

public class Addition {
    public static void main(String[] args) {
        System.out.println("Please input first number and press enter:");
        Scanner input = new Scanner(System.in); 
        float a = input.nextFloat(); 
        System.out.println("Please input second number and press enter:");
        float b = input.nextFloat();
        input.close();
        System.out.println("The sum of " + a + " + " + b + " = " + Float.sum(a, b));
    }
}
