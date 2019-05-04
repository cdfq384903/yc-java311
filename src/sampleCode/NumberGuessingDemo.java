package sampleCode;

import java.util.Scanner;

public class NumberGuessingDemo {
    public static void main(String[] args) {

        int s = (int) (Math.random() * 100);
        int lower = 0, upper = 99; // inclusive
        Scanner input = new Scanner(System.in);

        while (true) {

            System.out.printf("(%d, %d)?\n", lower, upper);
            int g = input.nextInt();

            if (g > upper || g < lower) {
                System.out.println("Out of range.");
                continue;
            }

            if (g > s) {
                upper = g - 1;
                System.out.println("Too large.");
            } else if (g < s) {
                lower = g + 1;
                System.out.println("Too small.");
            } else {
                System.out.println("Bingo.");
                break;
            }

            if (upper == lower) {
                System.out.println("GG.");
                break;
            }

        }

    }
}
