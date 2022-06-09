import java.util.Scanner;

public class Frog_2 {

    static int func(int pos, int n, int[] ar, int[] dp, int k) {

        if (pos == 1) {
            dp[0] = 0;
            return 0;
        }
        if (pos == 2) {
            dp[2] = Math.abs(ar[1] - ar[2]);
            return dp[2];
        }

        if (dp[pos] != -1) {
            return dp[pos];
        }
      //  System.out.println(pos);
        int left = Integer.MAX_VALUE;
        for (int i = 1; i <= Math.min(n, k); i++) {
            if (pos - i >= 1) {
                left = Math.min(left, func(pos - i, n, ar, dp, k) + Math.abs(ar[pos] - ar[pos - i]));
            }
        }
        return dp[pos] = left;

    }

    public static void main(String[] args) {
        int n, k;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        int[] ar = new int[n + 1];
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ar[i] = scanner.nextInt();

        }

        for (int j = 1; j <= n; j++)
            dp[j] = -1;


        System.out.println(func(n, n, ar, dp, k));


    }

}