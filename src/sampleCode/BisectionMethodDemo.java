package sampleCode;

public class BisectionMethodDemo {
    public static void main(String[] args) {

        // input
        // (1) target function: f(x) = x ^ 3 - x - 2
        // (2) initial guess: [a, b] = [1, 2]
        // (3) error tolerance: eps = 1e-9

        double a = 1, b = 2, c = 0, eps = 1e-10;

        while (b - a > eps) {

            c = (a + b) / 2;

            double fa = a * a * a - a - 2;
            double fb = b * b * b - b - 2;
            double fc = c * c * c - c - 2;

            // if ((fa > 0 & fc < 0) || (fa < 0 & fc > 0))
            if (fa * fc < 0) {
                b = c;
            } else {
                a = c;
            }

        }

        System.out.println("Root = " + c);
        double residue = c * c * c - c - 2;
        System.out.println("Residue: "  + residue);

    }
}
