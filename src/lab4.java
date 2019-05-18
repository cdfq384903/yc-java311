//TODO
//寫一支X^n的程式,透過recursion的方式,
//不能使用Math.power和loop的方式,且時間複雜度要在O(log n)
//example(整除): 2^10 = 2^5 * [x] 其中[x]屬於2^5,因此必須定義N/2整除時的case與非整除時的case
//example(非整除): 2^9 = 2^4 * [x] * [y]其中[x]屬於2^4;[y]屬於2,因此必須定義N/2整除時的case與非整除時的case


import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Scanner;

public class lab4 {

    public static float power(float x, int n){
        if (n>0){
            n = n-1;
            return (x*power(x,n));
        }else if(n == 0 ){
            return 1;
        }else if(n < 0){
            int y = Math.abs(n);
            return (1 / power(x,y));
        }
        return n;
    }

    //O(log n) time
    public static double power1(float x, int n){

        System.out.println("n:" + n);
        if (n == 0) return 1;
        double y = power1(x , n / 2);
        y = y * y;
        if (n % 2 == 1) {
            y = y * x;
        }
        return y;
    }


    public static void main(String[] args) {

//        Scanner input = new Scanner(System.in);
//        System.out.println("Please input x and n, x ^ n");
//        int x = input.nextInt();
//        int n = input.nextInt();
//
//        double z = power(x,n);
//        System.out.println(z);
//        input.close();

        double test = power1(2,10);
        System.out.println(test);


    }

}
