package sampleCode;

public class NumericalErrorDemo {
    public static void main(String[] args) {

        System.out.println(0.5 - 0.1 - 0.1 - 0.1 - 0.1 - 0.1);
        System.out.println(0.3 - 0.2);

        System.out.println(3.14 + 1e20 - 1e20);
        System.out.println(3.14 + (1e20 - 1e20));

        System.out.println(1 / 2);
        System.out.println(1.0 / 2.0);

    }
}
