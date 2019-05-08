package sampleCode;

public class ArrayDemo {

    public static void main(String[] args) {

        int size = 5;
        int[] A = new int[size];

        // generate random integers
        for (int i = 0; i < A.length; i++) {
            A[i] = (int) (Math.random() * 101) - 50;
        }

        // display all elements in A
        for (int i = 0; i < A.length; i++) {
            System.out.printf("%4d", A[i]);
        }
        System.out.println();

        // find max of A
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] > max) {
                max = A[i];
            }
        }
        System.out.println("MAX = " + max);

        // sum over A
        int s = 0;
        for (int i = 0; i < A.length; i++) {
            s = s + A[i];
        }
        System.out.println("SUM = " + s);

        // shuffling algorithm
        int[] B = {10, 20, 30, 40, 50};

        for (int i = 0; i < B.length; i++) {

            // pick a random j between 0 and B.length - 1
            int j = (int) (Math.random() * B.length);

            // swap
            int tmp = B[i];
            B[i] = B[j];
            B[j] = tmp;

        }

        // display all elements in B
        for (int i = 0; i < B.length; i++) {
            System.out.printf("%3d", B[i]);
        }
        System.out.println();

    }

}