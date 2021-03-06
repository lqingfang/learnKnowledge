package org.lqf.learn.algorithm.sort.selectSort;


import org.lqf.learn.algorithm.sort.PrintArray;
//类似于直接插入，不同的是，每次将指针指向最小的一个
public class SimpleSelectSort {
    private static PrintArray p = new PrintArray();
    public static void main(String[] args) {
        int a[] = {51,49,46,7,15,36,17,35,90,22,4,6};
        sort(a);
    }
    public static void sort(int[] a){
        int length = a.length;
        int temp;
        for (int i=0;i<length;i++) {
            int k=i;
            for (int j=i+1;j<length;j++) {
                if(a[j] < a[k]) {
                    k=j;
                }
            }
            temp = a[k];
            a[k] = a[i];
            a[i] = temp;
        }
        p.printArray(a);
    }
}
