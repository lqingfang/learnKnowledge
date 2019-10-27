package org.lqf.learn.leetCode.binarySearch.peakIndexInMountainArray_852;

public class Solution {
    public static void main(String[] args) {
        int[] A = {0,1,2,3,4,2,1,0};
        System.out.println(peakIndexInMountainArray(A));
    }

    private static int peakIndexInMountainArray(int[] A) {
        if(A == null || A.length < 3) {
            return 0;
        }
        int left = 0;
        int right = A.length-1;
        int mid = 0;
        while (left <= right) {
            mid = (left+right) >>>1;
            if(A[mid] > A[mid+1] && A[mid] > A[mid-1]) {
                return mid;
            }else if(A[mid] < A[mid-1]){
                right = mid;
            } else {
                left = mid;
            }
        }
        return mid;
    }
}
