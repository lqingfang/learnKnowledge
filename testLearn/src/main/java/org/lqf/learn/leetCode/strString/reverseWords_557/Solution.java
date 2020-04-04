package org.lqf.learn.leetCode.strString.reverseWords_557;

public class Solution {
    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
    public static String reverseWords(String s) {
        String[] strArray = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<strArray.length-1;i++) {
            if(!strArray[i].isEmpty()) {
                String newWord = reverseString(strArray[i]);
                stringBuilder.append(newWord+" ");
            }
        }
        stringBuilder.append(reverseString(strArray[strArray.length-1]));
        return stringBuilder.toString();
    }

    private static String reverseString(String s) {
        int left = 0;
        int right = s.length()-1;
        char[] chars = s.toCharArray();
        while (left < right) {
            char c = chars[left];
            chars[left] = chars[right];
            chars[right] = c;
            left++;
            right--;
        }
        return String.valueOf(chars);
    }
}
