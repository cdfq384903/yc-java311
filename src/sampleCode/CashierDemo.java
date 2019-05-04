package sampleCode;

import java.util.Scanner;

public class CashierDemo {
    public static void main(String[] args) {

        int total = 0;
        int price = 0;
        Scanner input = new Scanner(System.in);

        do {
            total = total + price;
            System.out.println("Enter price?");
            price = input.nextInt();
        } while (price > 0);

        System.out.println("Total = " + total);
        input.close();
    }
}
