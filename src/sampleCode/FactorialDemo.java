package sampleCode;

public class FactorialDemo {

    public static int factorial(int n) {

        if (n > 0) {
            return n * factorial(n - 1); // recurrence relation
        } else {
            return 1; // base case
        }

    }

    public static void main(String[] args) {

        System.out.println("4! = " + factorial(4));

    }

}