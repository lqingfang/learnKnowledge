package org.lqf.learn.leetCode.strString.reverseVowels_345;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String res = reverseVowels("aA");
        System.out.println(res);
    }
    public static String reverseVowels(String s) {
        int left = 0;
        int right = s.length()-1;
        char[] chars = s.toCharArray();
        List<Character> list = new ArrayList<Character>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        while (left<right) {
            while (left<right && !list.contains(chars[left])) {
                left++;
            }
            while (left<right && !list.contains(chars[right])) {
                right--;
            }
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return String.valueOf(chars);
    }
}
