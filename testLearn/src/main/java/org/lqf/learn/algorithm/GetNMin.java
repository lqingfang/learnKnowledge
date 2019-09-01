package org.lqf.learn.algorithm;

import java.util.Arrays;

public class GetNMin {
    public static void main(String[] args) {
        int arr[] = {3,2,8,5,9,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr) {
        for(int i =0;i<arr.length;i++) {
            int temp = arr[i];
            int k =i,j=1;
            while (i+j<arr.length) {
                if(arr[i+j]<temp) {
                    k = i+j;
                }
                j++;
            }
            arr[i] = arr[k];
            arr[k] = temp;
        }
    }
}
