package org.lqf.learn.algorithm.sort.exchangeSort;


import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int a[] = {51,49,46,7,15,36,17,35,90,22,4,6};
        sort(a,0,a.length-1);//坑1：注意最大值是：长度-1
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] a,int i,int il){
        int mid;
        int start = i;
        int end = il;
        int temp=a[i];
        while (i<il) {
            while (i<il && a[il]>temp) {
                il--;
            }
            a[i] = a[il];
            while (i<il && a[i]<temp) {
                i++;
            }
            a[il] = a[i];
        }
        a[i] = temp;
        mid = i;
        while (start<end) {
            sort(a,start,mid-1);
            sort(a,mid+1,end);
        }

    }
}
