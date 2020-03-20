package org.lqf.learn.leetCode.stackAndQueue.dailyTemperatures_739;

public class Solution {
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] res = new int[len];
        for(int i=0;i<len;i++) {
            res[i] = getMoreTem(i,T);
        }
        return res;
    }

    private int getMoreTem(int index, int[] t) {
        int res = 0;
        for(int i = index+1;i<t.length;i++) {
            if(t[i] > t[index]) {
                res++;
                return res;
            }
            res++;
        }
        return 0;
    }
}
