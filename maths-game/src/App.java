import java.util.Random;
import java.util.Scanner;

public class App {
    private int min = 1; 
    private int max = 10; 

    private int count = 0;
    private char[] types = {'+', '-', '*', '/', '%'};
    private Random random = new Random();
    
    private int num1, num2; 
    private int currentTypeIndex;

    public static void main(String[] args) {
        App app = new App();
        String question = app.generateQuestion();

        try(Scanner input = new Scanner(System.in)) {
            System.out.println(question);

            int answer = input.nextInt(); 
            app.checkAnswer(answer);
        }
    }

    private int generateNumber() {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

    private int generateNumber(int max) {
        return random.nextInt(max);
    }

    private String generateQuestion() {
        int num1 = generateNumber();
        int num2 = generateNumber(); 
        currentTypeIndex = generateNumber(types.length);
        char calcType = types[currentTypeIndex];

        if(num1 > num2) {
            this.num1 = num1;
            this.num2 = num2;
        } else {
            this.num1 = num2;
            this.num2 = num1;
        }

        return num1 + " " + calcType + " " + num2;
    }

    private int calculateSolution() {
        int result; 
        
        switch(currentTypeIndex) {
            case 0: 
                result = num1 + num2;
                break;
            case 1: 
                result = num1 - num2;
                break; 
            case 2: 
                result = num1 * num2;
                break;
            case 3: 
                result = num1 / num2;
                break;
            case 4: 
                result = num1 % num2;
                break; 
            default: 
                result = 0; 
        }

        return result; 
    }

    private void checkAnswer(int answer) {
        int solution = calculateSolution();
        System.out.println(solution == answer);
    }

}


/**
 * notes: 
 * 
 * when adding a number to a char, the char will be converted to its ASCII code and the result will be a number
 * e.g. 1 + ' ' will return 33, as ASCII code for space is 32. 
 */