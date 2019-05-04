package sampleCode;

public class MonteCarloPiDemo {
    public static void main(String[] args) {

        int N = 100000;
        int m = 0;

        for (int i = 1; i <= N; i++) {

            double x = Math.random();
            double y = Math.random();

            if (x * x + y * y < 1) {
                m++;
            }

        }

        System.out.println("pi ~ " + 4.0 * m / N);

    }
}
