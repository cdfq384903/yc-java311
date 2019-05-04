package sampleCode;

public class StarDemo {
    public static void main(String[] args) {

        // case (A)
		/*
		for (int j = 1; j <= 5; j++) {

			for (int i = 1; i <= j; i++) {
				System.out.printf("*");
			}
			System.out.printf("\n");

		}
		*/

        // case (B)
		/*
		for (int j = 5; j >= 1; j--) {

			for (int i = 1; i <= j; i++) {
				System.out.printf("*");
			}
			System.out.printf("\n");

		}
		*/
		/*
		for (int j = 1; j <= 5; j++) {

			for (int i = j; i <= 5; i++) {
				System.out.printf("*");
			}
			System.out.printf("\n");

		}
		*/
		/*
		for (int j = 1; j <= 5; j++) {

			for (int i = 1; i <= 6 - j; i++) {
				System.out.printf("*");
			}
			System.out.printf("\n");

		}
		*/

        // case (C)
		/*
		for (int j = 1; j <= 5; j++) {

			for (int i = 1; i <= 5 - j; i++) {
				System.out.printf(" ");
			}
			for (int i = 1; i <= j; i++) {
				System.out.printf("*");
			}
			System.out.printf("\n");

		}
		*/

        // case (D)
        for (int j = 5; j >= -1; j--) {

            for (int i = 1; i <= 5 - j; i++) {
                System.out.printf(" ");
            }
            for (int i = 1; i <= j; i++) {
                System.out.printf("*");
            }
            System.out.printf("\n");

        }

    }
}
