package org.lqf.learn.leetCode.dynamic.findMaxForm_474;

public class Solution03 {
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
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        for(String str:strs) {
            int[] count_0_1 = calculate(str);
            int count_0 = count_0_1[0];
            int count_1 = count_0_1[1];
            for(int j=m;j>=count_0;j--) {
                for(int k=n;k>=count_1;k--) {
                    dp[j][k] = dp[j][k];
                    if(j>=count_0 && k>=count_1) {
                        dp[j][k] = Math.max(dp[j][k],dp[j-count_0][k-count_1]+1);
                    }
                }
            }
        }
        return dp[m][n];
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
