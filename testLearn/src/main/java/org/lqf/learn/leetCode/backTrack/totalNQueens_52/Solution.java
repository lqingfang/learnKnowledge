package org.lqf.learn.leetCode.backTrack.totalNQueens_52;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(totalNQueens(1));
    }
    static int[] rows;
    static int[] cols;
    static int[][] boards;
    static int N;
    static int res;
    static List<String> list;
    static StringBuffer sb;
    public static int totalNQueens(int n) {
        rows = new int[n];
        cols = new int[n];
        boards = new int[n][n];
        N = n;
        list = new ArrayList<>();
        sb = new StringBuffer();
        for(int i=0;i<N;i++) {
            sb.append(".");
        }
        dfs(0,0);
        return res;
    }


    private static void dfs(int rows,int col) {
        if(rows == N) {
            res++;
            return;
        }
        for(int j=col;j<N;j++) {
            if(canPlaceQueens(rows,j)) {
                placeQueens(rows,j);
                dfs(rows+1,col);
                removeQueens(rows,j);
            }
        }
    }

    private static void removeQueens(int row, int col) {
        list.remove(list.size()-1);
        rows[row]--;
        cols[col]--;
        boards[row][col]--;
    }

    private static void placeQueens(int row, int col) {
        list.add(new StringBuilder(sb).replace(col,col+1,"Q").toString());
        rows[row]++;
        cols[col]++;
        boards[row][col]++;
    }

    private static boolean canPlaceQueens(int row, int col) {
        if(rows[row]>0 || cols[col]>0) {
            return false;
        }
        //撇 下半部分
        int i = row;
        int j = col;
        while (i<N && j>=0) {
            if(boards[i][j] >0) {
                return false;
            }
            i++;
            j--;
        }

        //撇 上半部分
        i = row;
        j = col;
        while (i>=0 && j<N) {
            if(boards[i][j] >0) {
                return false;
            }
            i--;
            j++;
        }

        //捺 下半部分
        i = row;
        j = col;
        while (i<N && j<N) {
            if(boards[i][j] >0) {
                return false;
            }
            i++;
            j++;
        }
        //捺 上半部分
        i = row;
        j = col;
        while (i>=0 && j>=0) {
            if(boards[i][j] >0) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }
}
