package com.trivedi.learning.ds;

public class SurroundedRegion {
    public static void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    fillRegion(board, i, j);
                }
            }
        }
    }

    private static boolean fillRegion(char[][] board, int i , int j) {
        if (i < 0 || i >= board.length) return false;
        if (j < 0 || j >= board[i].length) return false;
        if (i == 0 && board[i][j] == 'O') return false;
        if (i == board.length - 1 && board[i][j] == 'O') return false;
        if (j == 0 && board[i][j] == 'O') return false;
        if (j == board[i].length - 1 && board[i][j] == 'O') return false;

        if (board[i][j] == 'X') return true;

        board[i][j] = 'X';
        boolean result = fillRegion(board, i - 1, j)
                && fillRegion(board, i + 1, j)
                && fillRegion(board, i, j -1)
                && fillRegion(board, i, j + 1);
        if (!result)
            board[i][j] = 'O';
        return result;
    }

    public static void main(String[] args) {
        solve(new char[][] {
                {'O','X','X','O','X'},
                {'X','O','O','X','O'},
                {'X','O','X','O','X'},
                {'O','X','O','O','O'},
                {'X','X','O','X','O'}
        });
    }
}
