import java.util.Scanner;

public class Vacation {

    public static int func(int row, int pos, int n, int[][] ar,Integer[][] dp) {
        if (row >= n) {
            return 0;
        }
        if (dp[row][pos] != -1) return dp[row][pos];


        /*for (int i = 0; i < 3; i++) {
            if ((row != 0 && pos != 0) && i == pos) continue;
            left = Math.max(left, func(row + 1, i, n, ar, dp) + ar[row][i]);
            // right = Math.max(right, func(row + 1, i, n, ar, dp) + ar[row][pos]);
        }
*/
        int left = func(row + 1, (pos+1)%3, n, ar, dp) + ar[row][pos];
        int right = func(row + 1, (pos+2)%3, n, ar, dp) + ar[row][pos];
      // System.out.println(left +" row "+row+" pos "+ pos);

        return dp[row][pos] = Math.max(left,right);
    }

    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[][] ar = new int[n][3];
        Integer[][] dp = new Integer[n][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                ar[i][j] = scanner.nextInt();
                dp[i][j] = -1;
            }
        }

        System.out.println(Math.max(Math.max(func(0, 0, n, ar, dp), func(0, 1, n, ar, dp)),func(0, 2, n, ar, dp)));


    }
}
