package org.lqf.learn.algorithm.sort.exchangeSort;


import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int a[] = {51,49,46,7,15,36,17,35,90,22,4,6};
        sort(a,0,a.length-1);//坑1：注意最大值是：长度-1
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] a,int low,int hight){
        int start = low;
        int end = hight;
        int temp = a[start];//坑2：先把基准值取出来
        while(start < end){

            while (a[end]>=temp && end>start){//坑3：从后向前找，找到，放到基准位置
                end--;
            }
            if(start < end) {
                a[start] = a[end];
                start++;
            }


            while (a[start]<=temp && end>start){
                start++;
            }
            if(start < end) {
                a[end] = a[start];
                end--;
            }
        }
        a[start] = temp;  //最后基准值放入

        sort(a,low,start-1); //递归
        sort(a,start+1,hight);
    }
}
