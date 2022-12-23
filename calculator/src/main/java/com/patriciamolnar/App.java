package com.patriciamolnar;

public class App 
{
    public static void main( String[] args )
    {
        Addition addition = new Addition(); 
        int result = addition.add(12, 5); 
        System.out.println("The result is: " + result);
    }
}
