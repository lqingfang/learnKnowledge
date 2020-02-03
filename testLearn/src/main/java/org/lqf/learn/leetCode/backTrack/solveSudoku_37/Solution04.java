package org.lqf.learn.leetCode.backTrack.solveSudoku_37;

import java.util.Arrays;

public class Solution04 {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        solveSudoku(board);
        System.out.println(Arrays.deepToString(board));
    }

    static int n = 3;
    static int N = n*n;
    //行
    static int row;
    //列
    static int col;
    static boolean flag;
    static int[][] rows = new int[N][N+1];
    static int[][] cols = new int[N][N+1];
    static int[][] idxs = new int[N][N+1];
    public static void solveSudoku(char[][] board) {
        row = board.length;
        col = board[0].length;
        //把存在的数字进行统计
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(board[i][j] != '.') {
                    placeNumber(board,board[i][j]-'0',i,j);
                }
            }
        }
        dfs(board,0,0);
    }

    private static void dfs(char[][] board,int row,int col) {
        if(board[row][col] == '.') {
            for(int i=1;i<=9;i++) {
                int idx = (row/n)*n + col/n;
                if(rows[row][i] + cols[col][i] + idxs[idx][i] ==0) {
                    placeNumber(board,i,row,col);
                    //这块值得注意，是为了通过一个boolean值来判定结束与否
                    //还是进行接下来的dfs
                    placeNextNumber(board,row,col);
                    if(!flag) {
                        placeRemove(board,i,row,col);
                    }
                }
            }
        }else {
            placeNextNumber(board,row,col);
        }
    }

    private static void placeNextNumber(char[][] board,int row, int col) {
        if((row == N-1) && (col == N-1)) {
            flag = true;
        }else{
            if(col == N-1) {
                dfs(board,row+1,0);
            }else {
                dfs(board,row,col+1);
            }
        }
    }

    private static void placeRemove(char[][] board,int d, int i, int j) {
        rows[i][d]--;
        cols[j][d]--;
        int idx = i/n *n + j/n;
        idxs[idx][d]--;
        board[i][j] = '.';
    }

    private static void placeNumber(char[][] board,int d, int i, int j) {
        rows[i][d]++;
        cols[j][d]++;
        int idx = i/n *n + j/n;
        idxs[idx][d]++;
        board[i][j] = (char) (d+'0');
    }
}
