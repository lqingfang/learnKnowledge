package org.lqf.learn.leetCode.bfsAndDfs.solve_130;

import java.util.Arrays;

/**
 * dfs
 */
public class Solution02 {
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

    static int row;
    static int col;
    public static void solve(char[][] board) {
        if(null== board || board.length == 0) {
            return;
        }
        row = board.length;
        col = board[0].length;

        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {

                boolean isEdge = i==0 || i==row-1 || j==0 ||j==col-1;
                if(isEdge && board[i][j] == 'O' ) {
                    dfs(board,i,j);
                }
            }
        }
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(board[i][j] == '#') {
                    board[i][j] = 'O';
                }else if(board[i][j]=='O') {
                    board[i][j]= 'X';
                }
            }
        }
    }
    private static void dfs(char[][] board, int i, int j) {
        if(i<0 || j<0 || i>=row || j>=col) {
            return;
        }
        board[i][j] = '#';
        if(i-1>0 && board[i-1][j]== 'O') {
            dfs(board,i-1,j);
        }
        if(i+1<row && board[i+1][j]== 'O') {
            dfs(board,i+1,j);
        }
        if(j-1>0 && board[i][j-1]== 'O') {
            dfs(board,i,j-1);
        }
        if(j+1<col && board[i][j+1]== 'O') {
            dfs(board,i,j+1);
        }
    }
}
