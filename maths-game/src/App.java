import java.util.Random;

public class App {
    private int min = 1; 
    private int max = 10; 

    private int count = 0;
    private char[] types = {'+', '-', '*', '/', '%'};
    private Random random = new Random(); 

    public static void main(String[] args) {
        App app = new App();
        app.generateQuestion();
    }

    public int generateNumber() {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

    public int generateNumber(int max) {
        return random.nextInt(max);
    }

    public void generateQuestion() {
        int num1 = generateNumber();
        int num2 = generateNumber(); 
        char calcType = types[generateNumber(types.length)];

        System.out.println(num1 + " " + calcType + " " + num2);
    }

}


/**
 * notes: 
 * 
 * when adding a number to a char, the char will be converted to its ASCII code and the result will be a number
 * e.g. 1 + ' ' will return 33, as ASCII code for space is 32. 
 */