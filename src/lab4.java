//TODO
//寫一支X^n的程式,透過recursion的方式,
//不能使用Math.power和loop的方式,且時間複雜度要在O(log n)
//example(整除): 2^10 = 2^5 * [x] 其中[x]屬於2^5,因此必須定義N/2整除時的case與非整除時的case
//example(非整除): 2^9 = 2^4 * [x] * [y]其中[x]屬於2^4;[y]屬於2,因此必須定義N/2整除時的case與非整除時的case

public class lab4 {

    public static float powerNaive1(float x, int n){

        if (n>0){
            n = n-1;
            return (x*powerNaive1(x,n));
        }else if(n == 0 ){
            return 1;
        }else if(n < 0){
            int y = Math.abs(n);
            return (1 / powerNaive1(x,y));
        }
        return n;
    }

    //O(n) time
    public static double powerNaive2(float x, int n){

        double result = 1;
        for (int i = 1; i <= n; i++){
//            System.out.println("n:" + i);
            result *= x;
        }
        return result;
    }

    //O(log n) time
    public static double powerLog(float x, int n){

//        System.out.println("n:" + n);
        if (n == 0) return 1;
        double retult = powerLog(x , n / 2);
        retult = retult * retult;
        if (n % 2 == 1) {
            retult = retult * x;
        }
        return retult;
    }

    public static void main(String[] args) {

        int[] n = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
        double x = 2;
        System.out.printf("%4s ^ %11s| %11s \n", "x", "n", "Speedup");

        for (int size:n){
            long t0 = System.nanoTime();
            double powerLog = powerLog((float) x,size);
            long t1 = System.nanoTime();

            long t2 = System.nanoTime();
            double powerNaive2 = powerNaive2((float) x,size);
            long t3 = System.nanoTime();

            if (powerLog != powerNaive2){
                System.err.printf("%f %f\n", powerLog, powerNaive2);
            }
            System.out.printf("%.2f ^ %11d| %10.2f\n", x, size, (double) (t3-t2)/(t1-t0));
        }

    }

}
