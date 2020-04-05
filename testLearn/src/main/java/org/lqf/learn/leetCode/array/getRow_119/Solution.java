package org.lqf.learn.leetCode.array.getRow_119;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(1));
        if(rowIndex == 0) {
            return Arrays.asList(1);
        }
        res.add(Arrays.asList(1,1));
        if(rowIndex == 1) {
            return Arrays.asList(1,1);
        }

        for(int i=2;i<=rowIndex;i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for(int j=1;j<i;j++) {
                list.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
            }
            list.add(1);
            res.add(list);
        }

        return res.get(rowIndex);
    }
}
