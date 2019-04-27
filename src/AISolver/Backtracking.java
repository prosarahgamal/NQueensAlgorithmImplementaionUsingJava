package AISolver;

import javax.swing.*;

public class Backtracking {
    int n;
    int board[][];

    public Backtracking(int n){
        this.n = n;

        solveNQ();
    }

    boolean isSafe(int board[][], int row, int col) {
        int i, j;

		/* Check this row on left side */
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

		/* Check upper diagonal on left side */
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

		/* Check lower diagonal on left side */
        for (i = row, j = col; j >= 0 && i < n; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    boolean solveNQUtil(int board[][], int col) {
        if (col >= n)
            return true;
        for (int i = 0; i < n; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;

                if (solveNQUtil(board, col + 1) == true)
                    return true;

                board[i][col] = 0; // BACKTRACK
            }
        }

        return false;
    }

    boolean solveNQ() {
        board = new int[n][n];

        zeroArr(board);

        if (solveNQUtil(board, 0) == false) {
            JOptionPane.showMessageDialog(null, "no solution found!");
            return false;
        }
        return true;
    }

    public void zeroArr(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = 0;
            }
        }
    }

    public int[][] getBoard() {
        return board;
    }
}
