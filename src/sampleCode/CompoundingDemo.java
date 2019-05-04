package sampleCode;

public class CompoundingDemo {
    public static void main(String[] args) {

        int balance = 100, goal = 200, r = 2;

		/*
		int years = 0;
		while (balance < goal) {
			balance *= (1 + r / 100.0);
			years++;
		}
		*/

        int years = 0; // scope issue
        for (; balance < goal; years++) {
            balance *= (1 + r / 100.0);
        }

        System.out.println("Balance = " + balance);
        System.out.println("Years = " + years);

    }
}
