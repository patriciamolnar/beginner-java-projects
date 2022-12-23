package com.patriciamolnar;

public class App 
{   
    final String name = "Patricia Molnar";

    public static void main( String[] args )
    {
        // Addition addition = new Addition(); 
        // int result = addition.add(12, 5); 
        // System.out.println("The addition's result is: " + result);

        // Subtraction subtraction = new Subtraction(); 
        // result = subtraction.subtract(12, 5);
        // System.out.println("The subtraction's result is: " + result);

        // Multiplication multiplication = new Multiplication(); 
        // result = multiplication.multiply(5, 2);
        // System.out.println("The subtraction's result is: " + result);

        // Division division = new Division(); 
        // result = division.divide(10, 4); 
        // System.out.println("The subtraction's result is: " + result);

        // App test = new App(); 
        // System.out.println("My name is " + test.name);

        String numberFormat = args[0];
        Numbers numbers = new Numbers(); 
        numbers.printNumber(numberFormat);
    }

}
