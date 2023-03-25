import java.util.Random;
import java.util.Scanner;

public class App {
    private int min = 1; 
    private int max = 10; 

    private int count = 0;
    private char[] types = {'+', '-', '*', '/', '%'};
    private Random random = new Random();

    private int correct = 0;
    
    private int num1, num2; 
    private int currentTypeIndex;

    public static void main(String[] args) {
        App app = new App();

        try(Scanner input = new Scanner(System.in)) {
            do {
                String question = app.generateQuestion();
                System.out.println(question);
                float answer = input.nextFloat();
                app.checkAnswer(answer);
                app.count++;
            } while(app.count < 10);
        }

        System.out.println("Game Over: You got " + app.correct + " out of 10 correct.");
    }

    private int generateNumber() {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

    private int generateNumber(int max) {
        return random.nextInt(max);
    }

    private String generateQuestion() {
        int x = generateNumber();
        int y = generateNumber(); 
        currentTypeIndex = generateNumber(types.length);
        char calcType = types[currentTypeIndex];

        if(x > y) {
            num1 = x;
            num2 = y;
        } else {
            num1 = y;
            num2 = x;
        }

        return num1 + " " + calcType + " " + num2;
    }

    private float calculateSolution() {
        float result; 
        
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

    private void checkAnswer(float answer) {
        float solution = calculateSolution();
        boolean answerCorrect = solution == answer;
        if(answerCorrect) {
            correct++;
        }

        System.out.println("Your answer is: " + (answerCorrect ? "correct" : "false"));
    }
}

/**
 * todo: 
 * allow floats as an input 
 * handle errors
 */


/**
 * notes: 
 * 
 * when adding a number to a char, the char will be converted to its ASCII code and the result will be a number
 * e.g. 1 + ' ' will return 33, as ASCII code for space is 32. 
 */