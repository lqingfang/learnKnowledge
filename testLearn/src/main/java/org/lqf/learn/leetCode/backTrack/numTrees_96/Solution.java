package org.lqf.learn.leetCode.backTrack.numTrees_96;

/**
 * 分治
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }
    public static int numTrees(int n) {
        return getTrees(1,n);
    }

    private static int getTrees(int start, int end) {
        int ans =0;
        if(start >=end) {
            return 1;
        }
        //以每一个数字为父节点
        for(int i=start;i<= end;i++) {
            int left = getTrees(start,i-1);
            int right = getTrees(i+1,end);
            ans += left*right;
        }
        return ans;
    }
}
