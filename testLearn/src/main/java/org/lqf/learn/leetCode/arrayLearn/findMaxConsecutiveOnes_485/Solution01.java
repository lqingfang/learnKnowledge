package org.lqf.learn.leetCode.arrayLearn.findMaxConsecutiveOnes_485;

public class Solution01 {
    public static void main(String[] args) {
        int[] arrays = {1,0,0,0,1,1,1,0,1,1,1,1};
        System.out.println(findMaxConsecutiveOnes(arrays));
    }

    private static int findMaxConsecutiveOnes(int[] arrays) {
        int counts = 0;
        int maxCounts = 0;
        for(int i=0;i<arrays.length;i++) {
            if(arrays[i] == 0){
                counts = 0;
            }else {
                counts++;
                if(counts>maxCounts) {
                    maxCounts = counts;
                }
            }
        }
        return maxCounts;
    }
}
