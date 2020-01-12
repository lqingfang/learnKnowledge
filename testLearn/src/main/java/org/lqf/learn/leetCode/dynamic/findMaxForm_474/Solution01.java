package org.lqf.learn.leetCode.dynamic.findMaxForm_474;

public class Solution01 {
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
        return tryFindMaxForm(strs,strs.length-1,m,n);
    }

    private static int tryFindMaxForm(String[] strs, int index, int m, int n) {
        if(index<0) {
            return 0;
        }
        String str = strs[index];
        int num_0 = 0;
        int num_1 = 0;
        for(int i=0;i<str.length();i++) {
            if(str.charAt(i)=='0') {
                num_0++;
            }else {
                num_1++;
            }
        }
        if(m>=num_0 && n>=num_1) {
            return Math.max(tryFindMaxForm(strs,index-1,m,n),1+tryFindMaxForm(strs,index-1,m-num_0,n-num_1));
        }else {
            return tryFindMaxForm(strs,index-1,m,n);
        }
    }
}
