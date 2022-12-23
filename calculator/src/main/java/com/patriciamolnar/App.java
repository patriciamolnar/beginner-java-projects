package com.patriciamolnar;

public class App 
{
    public static void main( String[] args )
    {
        Addition addition = new Addition(); 
        int result = addition.add(12, 5); 
        System.out.println("The addition's result is: " + result);

        Subtraction subtraction = new Subtraction(); 
        result = subtraction.subtract(12, 5);
        System.out.println("The subtraction's result is: " + result);
    }
}
