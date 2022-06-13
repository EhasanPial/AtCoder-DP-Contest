public class LongestPalindromicSubsequence {

    public static int func(int start, int end, String checkString, int[][] dp, Pair[][] next) {

        if (start == end) return 1;
        if (start > end) return 0;

        if (checkString.charAt(start) == checkString.charAt(end)) {

            next[start][end] = new Pair(start + 1, end - 1);
            return dp[start][end] = func(start + 1, end - 1, checkString, dp, next) + 2;
        } else {

            int val1 = func(start + 1, end, checkString, dp, next);
            int val2 = func(start, end - 1, checkString, dp, next);
            if (val1 > val2) {
                next[start][end] = new Pair(start + 1, end);
            } else {
                next[start][end] = new Pair(start, end - 1);
            }
            return dp[start][end] = Math.max(val2, val1);

        }
    }


    public static void main(String[] args) {
        String checkString = "BBABCBCAB";
        int[][] dp = new int[checkString.length()][checkString.length()];
        Pair[][] next = new Pair[checkString.length()][checkString.length()];
        System.out.println(func(0, checkString.length() - 1, checkString, dp, next));

        int i = 0, j = 0, start = 0, end = 0, flag = 0;
        for (i = 0; i < checkString.length(); i++) {
            for (j = 0; j < checkString.length(); j++) {

                if (next[i][j] != null) {
                    System.out.println(next[i][j].start + " " + next[i][j].end);
                    flag = 1;
                    break;
                }

            }

            if (flag == 1) break;
        }

       // System.out.println(next[start][end].start);

        while ((next[start][end] != null)){
            for (int k = start; k <= end; k++) {
                System.out.print(checkString.charAt(k));
            }

            start = next[start][end].start;
            end = next[start][end].end;
        }


    }

    static class Pair {
        public int start;
        public int end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
