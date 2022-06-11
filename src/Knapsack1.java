import java.lang.reflect.WildcardType;
import java.util.Scanner;

public class Knapsack1 {

    public static long func(int i, int W, int[] Weight, int[] Value, Long[][] dp, int N) {
        if (i >= N || W <= 0) {
            return 0;
        }

        if (dp[i][W] != null ) return dp[i][W];

        long left;
        if (( W-Weight[i]) < 0) {
            left = func(i + 1, W, Weight, Value, dp, N);
        } else {
            long var1 = Value[i] + ( func(i + 1, (W - Weight[i]), Weight, Value, dp, N)) ;
            long var2 = func(i + 1, W, Weight, Value, dp, N) ;
            //System.out.println(var1+" i " + var2);
            left= Math.max(var1,var2) ;

        }

        return dp[i][W] = left;

    }

    public static void main(String[] args) {
        int N, W;
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        W = scanner.nextInt();
        int[] Weight = new int[N];
        int[] Value = new int[N];
        Long[][] dp = new Long[N][W+1];
        for (int i = 0; i < N; i++) {
            Weight[i] = scanner.nextInt();
            Value[i] = scanner.nextInt();
        }


        System.out.println(func(0, W, Weight, Value, dp, N));


    }
}
