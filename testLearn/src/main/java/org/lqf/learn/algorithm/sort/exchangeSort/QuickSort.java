package org.lqf.learn.algorithm.sort.exchangeSort;


import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int a[] = {51,49,46,7,15,36,17,35,90,22,4,6};
        sort(a,0,a.length-1);//坑1：注意最大值是：长度-1
        System.out.println(Arrays.toString(a));
    }

    private static void sort(int[] arr,int l,int r) {
        int start = l;
        int end = r;
        int temp = arr[l];
        while (l<r) {
            while (l<r && arr[r]>temp) {
                r--;
            }
            if(l<r) {
                arr[l] = arr[r];
                l++;
            }

            while (l<r && arr[l]<temp){
                l++;
            }
            if(l<r) {
                arr[r] = arr[l];
                r--;
            }
        }

        arr[l] = temp;
        if(start<l){
            sort(arr,start,l-1);
        }
        if(l<end) {
            sort(arr,l+1,end);
        }

    }
}
