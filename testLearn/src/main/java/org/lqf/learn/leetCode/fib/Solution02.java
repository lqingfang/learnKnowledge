package org.lqf.learn.leetCode.fib;

public class Solution02 {
    public static void main(String[] args) {
        System.out.println(fib(40)+"---"+count);
    }

    static int count = 0;
    private static int fib(int n) {
        int[] arr = new int[n];
        arr[0] = 0;
        arr[1] = 1;
        for(int i=2;i<n;i++) {
            count++;
            arr[i] = arr[i-2]+arr[i-1];
        }
        return arr[n-2]+arr[n-1];
    }
}
