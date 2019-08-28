package org.lqf.learn.huawei;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//华为面试题  处理器
public class HuaweiTest {
    public static void main(String[] args) {
        int[] arr = {8,4,3,1,10};
        //1、对处理时长进行排序
        sort(arr);
        //2、假设有3个处理器，5个任务
        //每个处理器是一个map，key是处理器名称，键是任务时长
        //最长的处理器对应的时间总和就是总处理时长
        Map map = new HashMap<>();
        for(int i =0;i<3;i++){
            int coast=0;
            int j= i;
            while (j<arr.length) {
                coast +=arr[j];
                j=j+3;
            }
            map.put(i+1,coast);
        }
        System.out.println(map.toString());
    }
    public static void sort(int[] arr) {
        for(int i=1;i<arr.length;i++) {
            int temp = arr[i];
            int j;
            for(j=i-1;j>=0 && arr[j]>temp;j--){
                arr[j+1] = arr[j];
            }
            arr[j+1] = temp;
        }
        System.out.println(Arrays.toString(arr));


    }

}
