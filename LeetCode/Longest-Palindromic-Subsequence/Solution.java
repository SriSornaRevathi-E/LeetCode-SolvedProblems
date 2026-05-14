1class Solution {
2    public int longestPalindromeSubseq(String s){
3        String s1=new StringBuilder(s).reverse().toString();
4        int n = s.length();
5        int m = s1.length();
6        int[][] dp = new int[n + 1][m + 1];
7        for (int i = 1; i <= n; i++) {
8            for (int j = 1; j <= m; j++){
9                if (s.charAt(i - 1) == s1.charAt(j - 1)){
10                    dp[i][j] = 1 + dp[i - 1][j - 1];
11                } else {
12                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
13                }
14            }
15        }
16        return dp[n][m];
17    }
18}
19    