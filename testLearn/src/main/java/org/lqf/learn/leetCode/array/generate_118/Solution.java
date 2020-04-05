package org.lqf.learn.leetCode.array.generate_118;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1
 * 1 1
 * 1 2 1
 * 1 3 3 1
 * 1 4 6 4 1
 */
public class Solution {
    public static void main(String[] args) {

    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows == 0){
            return res;
        }
        res.add(Arrays.asList(1));
        if(numRows == 1) {
            return res;
        }
        res.add(Arrays.asList(1,1));
        if(numRows == 2) {
            return res;
        }
        for(int i=2;i<numRows;i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for(int j=1;j<i;j++) {
                list.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
            }
            list.add(1);
            res.add(list);
        }
        return res;
    }
}
