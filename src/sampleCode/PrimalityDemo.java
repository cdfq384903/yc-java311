package sampleCode;

public class PrimalityDemo {
    public static void main(String[] args) {

        int x = 101;
        boolean isPrime = true; // a flag; status

        // stage 1: check if x is divided by any integer
        for (int y = 2; y < x; y++) {
            if (x % y == 0) {
                isPrime = false;
                break; // early termination
            }
        }

        // stage 2: judge by the status isPrime
        if (isPrime) {
            System.out.println("Is a prime.");
        } else {
            System.out.println("Not a prime.");
        }

    }
}
