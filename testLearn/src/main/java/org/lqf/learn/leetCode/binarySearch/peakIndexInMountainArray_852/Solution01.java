package org.lqf.learn.leetCode.binarySearch.peakIndexInMountainArray_852;

public class Solution01 {
    public static void main(String[] args) {
        int[] A = {24,69,100,99,79,78,67,36,26,19};
        System.out.println(peakIndexInMountainArray(A));
    }
    public static int peakIndexInMountainArray(int[] A) {
        int len = A.length;
        if(len < 3) {
            return -1;
        }
        int left = 0;
        int right = len-1;
        int mid = 0;
        while (left <= right) {
            mid = (left+right)>>1;
            if(A[mid] > A[mid+1] && A[mid-1] < A[mid]) {
                return mid;
            }else if(A[mid] < A[mid-1]) {
                right = mid;
            }else {
                left = mid;
            }

        }
        return mid;
    }
}
