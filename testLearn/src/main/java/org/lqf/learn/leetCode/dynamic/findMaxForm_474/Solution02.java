package org.lqf.learn.leetCode.dynamic.findMaxForm_474;

public class Solution02 {
    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5;
        int n = 3;
        System.out.println(findMaxForm(strs,m,n));
    }
    public static int findMaxForm(String[] strs, int m, int n) {
        if(strs.length ==0 ||(m==0 && n==0)) {
            return 0;
        }
        int[][][] dp = new int[strs.length+1][m+1][n+1];
        for(int i=1;i<=strs.length;i++) {
            int[] count_0_1 = calculate(strs[i-1]);
            for(int j=0;j<=m;j++) {
                for(int k=0;k<=n;k++) {
                    int count_0 = count_0_1[0];
                    int count_1 = count_0_1[1];
                    dp[i][j][k] = dp[i-1][j][k];
                    if(j>=count_0 && k>=count_1) {
                        dp[i][j][k] = Math.max(dp[i-1][j][k],dp[i-1][j-count_0][k-count_1]+1);
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }

    private static int[] calculate(String str) {
        int[] count_0_1 = new int[2];
        for(int i=0;i<str.length();i++) {
            if(str.charAt(i) =='0') {
                count_0_1[0]++;
            }else {
                count_0_1[1]++;
            }
        }
        return count_0_1;
    }
}
