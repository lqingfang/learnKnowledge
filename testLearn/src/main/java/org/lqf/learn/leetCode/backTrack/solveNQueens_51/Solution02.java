package org.lqf.learn.leetCode.backTrack.solveNQueens_51;

import java.util.ArrayList;
import java.util.List;

/**
 * 仿照数独，写的，可就是不对啊
 */
public class Solution02 {
    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
    static int[] rows;
    static int[] cols;
    static int[][] boards;
    static int N;
    static List<List<String>> res;
    static List<String> list;
    static boolean flag;
    public static List<List<String>> solveNQueens(int n) {
        rows = new int[n];
        cols = new int[n];
        boards = new int[n][n];
        N = n;
        res = new ArrayList<>();
        list = new ArrayList<>();
        dfs(0,0);
        return res;
    }

    private static void dfs(int rows,int col) {
        if(rows == N) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=rows;i<N;i++) {
            for(int j=col;j<N;j++) {
                if(canPlaceQueens(i,j)) {
                    placeQueens(i,j);
                    dfs(rows+1,col);
                        removeQueens(i,j);
                    }
            }
        }
    }

    private static void removeLastQueens() {
        String s = list.get(list.size()-1);
        int col = 0;
        for(int k=0;k<s.length();k++) {
            if(s.charAt(k)=='Q'){
                col = k;
                break;
            }
        }
        int row = list.size()-1;
        removeQueens(row,col);
        dfs(row,col+1);
    }

    private static void removeQueens(int row, int col) {
        list.remove(list.size()-1);
        rows[row]--;
        cols[col]--;
        boards[row][col]--;
    }

    private static void placeNextQueens(int row,int col) {
        if(row == N){
            flag = true;
            return;
        }
        dfs(row,col);
    }

    private static void placeQueens(int row, int col) {
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<N;i++) {
            if(i<col || i>col) {
                sb.append(".");
            }else {
                sb.append("Q");
            }
        }
        list.add(sb.toString());
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
