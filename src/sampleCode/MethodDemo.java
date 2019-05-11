package sampleCode;

public class MethodDemo {

    public static int max(int[] A) {

        int result = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] > result) {
                result = A[i];
            }
        }

        return result;
    }


    public static void display(int[] A) {

        for (int i = 0; i < A.length; i++) {
            System.out.printf("%d ", A[i]);
        }
        System.out.println();

    }

    public static int sum(int[] A) {

        int s = 0;
        for (int i = 0; i < A.length; i++) {
            s = s + A[i];
        }

        return s;
    }

    public static void shuffle(int[] A) {

        for (int i = 0; i < A.length; i++) {
            int j = (int) (Math.random() * A.length);
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
        }
    }

    public static int[] genRandArray(int size, int lower, int upper) {

        int[] A = new int[size];
        for (int i = 0; i < A.length; i++) {
            A[i] = (int) (Math.random() * (upper - lower + 1)) + lower;
        }

        return A;

    }

    public static int x = 100; // class variable (global)

    public static void main(String[] args) {

        System.out.println(x);
        int x = 10;
        System.out.println(x); // shadow effect: local over global

        int size = 10;
        int[] A = genRandArray(size, -500, 500);

        display(A);
        System.out.println("MAX = " + max(A));
        System.out.println("SUM = " + sum(A));

        // shuffling algorithm
        int[] B = {10, 20, 30, 40, 50};
        shuffle(B);
        display(B);

    }

}