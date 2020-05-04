package org.lqf.learn.leetCode.sort.topKFrequent_347;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {4,4,4,2,2,3};
        System.out.println(topKFrequent(nums,2));
    }
    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> countMap = new HashMap<>();
        for(int num:nums) {
            countMap.put(num,countMap.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((o1,o2)->
            countMap.get(o1) - countMap.get(o2)
        );
        for(int n:countMap.keySet()) {
            queue.add(n);
            if(queue.size()>k) {
                queue.poll();
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            res.add(queue.poll());
        }
        Collections.reverse(res);
        return res;
    }
}
