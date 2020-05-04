package org.lqf.learn.leetCode.binarySearch.nextGreatestLetter_744;

public class Solution {
    public static void main(String[] args) {
        char[] letters = {'m','z','c','f','j'};
        char target = 'n';
        System.out.println(nextGreatestLetter(letters,target));
    }
    public static char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length-1;
        if(letters.length <1) {
            return ' ';
        }
        if(letters[letters.length-1] <= target) {
            return letters[0];
        }
        while(left <= right) {
            int mid = (left+right) >>1;
            if(letters[mid] > target) {
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return letters[left];
    }
}
