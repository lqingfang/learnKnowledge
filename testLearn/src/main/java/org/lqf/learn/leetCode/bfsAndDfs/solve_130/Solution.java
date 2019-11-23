package org.lqf.learn.leetCode.bfsAndDfs.solve_130;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'O','X','X','O','X'},
                {'X','O','O','X','O'},
                {'X','O','X','O','X'},
                {'O','X','O','O','O'},
                {'X','X','O','X','O'}
        };
        solve(board);
        for(int i=0;i<board.length;i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    public static void solve(char[][] board) {
        if(null == board || board.length == 0){
            return;
        }
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                boolean isEdge = i==0 || i==board.length-1 || j==0 ||j==board[0].length-1;
                if(isEdge && board[i][j] == 'O') {
                    dfs(board,i,j);
                }
            }
        }
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }else if(board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public static void dfs(char[][] board, int i, int j) {
        if(i<0 || i>=board.length || j<0 ||j>=board[0].length ||board[i][j] == 'X'||board[i][j]=='#') {
            return;
        }
        board[i][j] = '#';
        dfs(board,i-1,j);
        dfs(board,i+1,j);
        dfs(board,i,j-1);
        dfs(board,i,j+1);
    }
}
