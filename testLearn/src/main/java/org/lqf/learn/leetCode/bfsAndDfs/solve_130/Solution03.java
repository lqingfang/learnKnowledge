package org.lqf.learn.leetCode.bfsAndDfs.solve_130;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * bfs  超时了
 */
public class Solution03 {
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
        if(null == board || board.length == 0) {
            return;
        }
        row = board.length;
        col = board[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++) {
                boolean isEdge = i==0 || j==0 || i==row-1 || j== col-1;
                if(isEdge && board[i][j] == 'O') {
                    bfs(board,i,j);
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

    private static void bfs(char[][] board, int i, int j) {
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(i,j));

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> curPair = queue.poll();
            int m = curPair.getKey();
            int n = curPair.getValue();
            board[m][n] = '#';
            if(m-1>0 && board[m-1][n]== 'O') {
                queue.add(new Pair<>(m-1,n));
            }
            if(m+1<row && board[m+1][n]== 'O') {
                queue.add(new Pair<>(m+1,n));
            }
            if(n-1>0 && board[m][n-1]== 'O') {
                queue.add(new Pair<>(m,n-1));
            }
            if(n+1<col && board[m][n+1]== 'O') {
                queue.add(new Pair<>(m,n+1));
            }
        }
    }
}
