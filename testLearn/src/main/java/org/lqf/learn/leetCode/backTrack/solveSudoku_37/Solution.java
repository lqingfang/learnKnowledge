package org.lqf.learn.leetCode.backTrack.solveSudoku_37;

import java.util.Arrays;
/**
 * 递归方法
 */
public class Solution {
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
    public static void solveSudoku(char[][] board) {
        if(null == board || board.length == 0) {
            return;
        }
        solveSudo(board);
    }

    private static boolean solveSudo(char[][] board) {
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                if(board[i][j] == '.') {
                    for(char c='1';c<='9';c++) {
                        if(valid(board,i,j,c)) {
                            board[i][j] = c;
                            if(solveSudo(board)) {
                                return true;
                            }else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean valid(char[][] board, int row, int col, char c) {
        for(int i=0;i<9;i++) {
            if(board[i][col] == c) {
                return false;
            }
            if(board[row][i] == c) {
                return false;
            }
            if(board[3*(row/3)+i/3][3*(col/3)+i%3] == c) {
                return false;
            }
        }

        return true;
    }
}
