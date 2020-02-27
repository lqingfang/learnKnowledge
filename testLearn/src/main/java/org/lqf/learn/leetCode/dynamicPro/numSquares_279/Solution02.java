package org.lqf.learn.leetCode.dynamicPro.numSquares_279;

public class Solution02 {
    public static void main(String[] args) {
        Solution02 solution = new Solution02();
//        System.out.println(trie_208.numSquares(12));
//        System.out.println(trie_208.numSquares(13));
        System.out.println(solution.numSquares(14));
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1]; // 默认初始化值都为0
        for (int i = 1; i <= n; i++) {
            dp[i] = i; // 最坏的情况就是每次+1
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1); // 动态转移方程
            }
        }
        return dp[n];
    }
}
