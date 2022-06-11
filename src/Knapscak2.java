import java.util.Scanner;

public class Knapscak2 {

    public static int PROFIT_MAX = 0;
    public static int WEIGHT_MAX = 1000000000;

    public static int solveDp(int CurrentProfit, int i, int[] Weight, int[] Profit, Integer[][] dp, int N) {

        if(CurrentProfit <= 0 ) return 0 ;
        if(i >= N) return WEIGHT_MAX ;

        if(dp[CurrentProfit][i] != null) return dp[CurrentProfit][i] ;

        int left = solveDp(CurrentProfit-Profit[i],i+1,Weight,Profit,dp,N) + Weight[i];
        int right = solveDp(CurrentProfit,i+1,Weight,Profit,dp,N) ;

        return dp[CurrentProfit][i] = Math.min(left,right) ;


    }

    public static void main(String[] args) {
        int N, W;
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        W = scanner.nextInt();

        int[] Weight = new int[N];
        int[] Profit = new int[N];

        for (int i = 0; i < N; i++) {

            Weight[i] = scanner.nextInt();
            Profit[i] = scanner.nextInt();
            PROFIT_MAX += Profit[i];

        }
        Integer[][] dp = new Integer[PROFIT_MAX+1][N];
        for (int CurrentProfit = PROFIT_MAX; CurrentProfit >= 0; CurrentProfit--) {
            if (solveDp(CurrentProfit, 0, Weight, Profit, dp, N) <= W) {
                System.out.println(CurrentProfit);
                break;
            }
        }


    }
}
