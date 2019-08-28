package org.lqf.learn.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetNMax {
    public static void main(String[] args) {
        List list = new ArrayList<Integer>(Arrays.asList(2,5,1,3,9,6));
        getNMax(list,3);
        System.out.println(list);
    }

    private static int getNMax(List<Integer> list, int n) {
        for (int i =0;i<n;i++){
            int temp = list.get(i);
            int t = list.get(i);
            int k=i,j=1;
            while (i+j<list.size()){
                if(list.get(i+j)>temp) {
                    k = i+j;
                    temp =list.get(k);
                }
                j++;
            }
            list.set(i,list.get(k));
            list.set(k,t);
        }
        return list.get(n-1);
    }
}
