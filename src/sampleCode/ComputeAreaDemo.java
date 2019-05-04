package sampleCode;

import java.util.Scanner;

public class ComputeAreaDemo {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // input
        System.out.println("Enter r?");
        int r = input.nextInt();

        if (r > 0) {

            // algorithm
            double A = r * r * 3.14;
            // output
            System.out.println(A);

        } else {

            System.out.println("Not a circle.");
            System.out.println("Try again.");

        }
    }
}
