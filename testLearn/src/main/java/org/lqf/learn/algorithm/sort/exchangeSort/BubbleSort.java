package org.lqf.learn.algorithm.sort.exchangeSort;


import org.lqf.learn.algorithm.sort.PrintArray;

public class BubbleSort {
    private static PrintArray p = new PrintArray();
    public static void main(String[] args) {
        int a[] = {51,49,46,7,15,36,17,35,90,22,4,6};
        sort(a);
    }
    public static void sort(int[] a){
        //i第一次为最大，这样，第一次排序下来，最后一个肯定是最大或者最小
        //flag为终止条件，每次flag都设为false，当有一次排序完后flag还为false，则说明没有交换，已经有序。
        for(int i=a.length-1;i>0;i--) {
            boolean flag = false;
            for(int j=0;j<i;j++) {
                if(a[j]>a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = true;
                }
            }
            if(!flag) break;
            p.printArray(a);
        }
    }
}
