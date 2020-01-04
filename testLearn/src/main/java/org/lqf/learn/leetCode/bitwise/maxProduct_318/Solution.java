package org.lqf.learn.leetCode.bitwise.maxProduct_318;

public class Solution {
    public static void main(String[] args) {

    }
    public int maxProduct(String[] words) {
        int wlength = words.length;
        int[] arr = new int[wlength];
        for(int i = 0; i < wlength; ++i){
            int length = words[i].length();
            for(int j = 0; j < length; ++j){
                arr[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }
        int ans = 0;
        for(int i = 0; i < wlength; ++i){
            for(int j = i + 1; j < wlength; ++j){
                if((arr[i] & arr[j]) == 0){
                    int k = words[i].length() * words[j].length();
                    ans = ans < k ? k : ans;
                }
            }
        }
        return ans;
    }
}
