package sampleCode;

import java.util.Scanner;

public class RandomDemo {
    public static void main(String[] args) {

        // (1) generate two random integers: 0 ~ 9
        int x = (int) (Math.random() * 10);
        int y = (int) (Math.random() * 10);

        // (2) display the math equation
        System.out.println(x + " + " + y + " = ?");

        // (3) input by user
        Scanner input = new Scanner(System.in);
        int g = input.nextInt();

        // (4) judge the input
		/*
		if (g == x + y) {
			System.out.println("Correct.");
		} else {
			System.out.println("Wrong. The answer is " + (x + y) + ".");
		}
		*/

        while (g != x + y) {
            System.out.println("Try again?");
            g = input.nextInt();
        }

        System.out.println("Correct.");

    }
}
