package sampleCode;

public class StackoverflowDemo {

    public static void main(String[] args) {
        crash_me(1);
    }

    public static void crash_me(int n) {
        System.out.println(n);
        crash_me(n + 1);
    }

}