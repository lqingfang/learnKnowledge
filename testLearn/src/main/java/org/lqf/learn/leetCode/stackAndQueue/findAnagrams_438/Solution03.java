package org.lqf.learn.leetCode.stackAndQueue.findAnagrams_438;

import java.util.ArrayList;
import java.util.List;

public class Solution03 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s,p));
    }
    public static List<Integer> findAnagrams(String s, String p) {
        char[] arr_s = s.toCharArray();
        char[] arr_p = p.toCharArray();
        List<Integer> res = new ArrayList<>();

        int[] needs = new int[26];
        int[] windows = new int[26];

        for(int i=0;i<arr_p.length;i++) {
            needs[arr_p[i]-'a']++;
        }
        int left = 0;
        int right = 0;

        while (right < arr_s.length) {
            int cur = arr_s[right] -'a';
            windows[cur]++;
            while (windows[cur] > needs[cur]) {
                int top = arr_s[left] - 'a';
                left++;
                windows[top]--;
            }
            right++;
            if(right - left == arr_p.length) {
                res.add(left);
            }
        }

        return res;
    }
}
