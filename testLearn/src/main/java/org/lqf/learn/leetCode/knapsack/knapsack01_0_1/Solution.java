package org.lqf.learn.leetCode.knapsack.knapsack01_0_1;

/**
 * 0_1背包问题
 *
 * 一个背包的总容量为V,现在有N类物品,第i类物品的重量为weight[i],价值为value[i]
 * 那么往该背包里装东西,怎样装才能使得最终包内物品的总价值最大。
 *
 * 放入第i个物品：F[i][v] = F[i-1][v-C[i]] + W[i]
 * 即如果选择放入第i个物品，那么将前i个物品放入v容量的包中所能获得的最大价值就
 * 等同于前i-1件物品放入空间为v-C[i]的背包所能获得的最大价值加上第i件物品的价值。
 */
public class Solution {
    public static void main(String[] args) {
        int N = 4,V = 5;
        int[] weight = {1,2,3,4};
        int[] value = {2,4,4,5};
        System.out.println(zeroOnePack02(N,V,weight,value));
    }
    /**
     * 商品数量：N
     * 容量：V
     *
     * 每件商品的容量：weight
     * 每件商品的价值：value
     *
     * dp[i][j] 表示第i个商品，容量为j的总价值对大值
     *
     * 一个物品最多放入一次
     */
    public static int zeroOnePack(int N,int V,int[] weight,int[] value) {
        int[][] dp = new int[N+1][V+1];
        dp[0][0] = 0;
        for(int i=1;i<N+1;i++){
            for(int j=0;j<V+1;j++) {
                //不放
                dp[i][j] = dp[i-1][j];
                //放
                if(j>=weight[i-1]) {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i-1]]+value[i-1]);
                }
            }
        }
        return dp[N][V];
    }

    public static int zeroOnePack02(int N,int V,int[] weight,int[] value) {
        int[] dp = new int[V+1];
        dp[0] = 0;
        for(int i=1;i<N+1;i++){
            for(int j=V;j>=weight[i-1];j--) {
                dp[j] = Math.max(dp[j],dp[j-weight[i-1]]+value[i-1]);
            }
        }
        return dp[V];
    }
}
