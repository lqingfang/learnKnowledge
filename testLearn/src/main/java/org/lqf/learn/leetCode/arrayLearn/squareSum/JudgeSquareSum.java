package org.lqf.learn.leetCode.arrayLearn.squareSum;
/*
给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。

示例1:

输入: 5
输出: True
解释: 1 * 1 + 2 * 2 = 5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sum-of-square-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class JudgeSquareSum {
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(6));
    }
    public static boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int)Math.sqrt(c);
        while (left <= right){
            int sum = left*left + right*right;
            if(sum == c){
                return true;
            }
            if(sum < c) {
                left++;
            }else {
                right--;
            }
        }
        return false;
    }
}
