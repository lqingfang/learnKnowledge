package org.lqf.learn.leetCode.strString.countBinarySubstrings_696;

public class Solution {
    /**
     * 尝试计算 groups[i] 和 groups[i+1] 之间的有效二进制字符串数。
     * 如果 groups[i] = 2, groups[i+1] = 3，那么它表示 “00111” 或 “11000”。
     * 显然，我们可以在此字符串中生成 min(groups[i], groups[i+1]) 有效的二进制字符串。
     * @param s
     * @return
     */
    public int countBinarySubstrings(String s) {
        int[] groups = new int[s.length()];
        int t = 0;
        groups[0]=1;
        for(int i=1;i<s.length();i++) {
            if(s.charAt(i-1) == s.charAt(i)) {
                groups[t]++;
            }else {
                groups[++t]=1;
            }
        }
        int res = 0;
        for(int i=1;i<=t;i++) {
            res += Math.min(groups[i-1],groups[i]);
        }
        return res;
    }
}
