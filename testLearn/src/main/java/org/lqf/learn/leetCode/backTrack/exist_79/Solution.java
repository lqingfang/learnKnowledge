package org.lqf.learn.leetCode.backTrack.exist_79;

public class Solution {
    public static void main(String[] args) {

    }
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j]== word.charAt(0) && findWord(board,i,j,0,word,visited)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean findWord(char[][] board, int i, int j, int index, String word,boolean[][] visited) {
        if(index == word.length()) {
            return true;
        }
        int i_len = board.length;
        int j_len = board[0].length;
        if(i<0 || j<0 || i>=i_len || j>= j_len) {
            return false;
        }
        if(board[i][j] != word.charAt(index) || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        if(findWord(board,i+1,j,index+1,word,visited) ||
           findWord(board,i,j+1,index+1,word,visited) ||
           findWord(board,i-1,j,index+1,word,visited) ||
           findWord(board,i,j-1,index+1,word,visited)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}
