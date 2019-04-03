package leetcode;

import java.util.*;

/**
 * @author Jandos Iskakov
 * problem: 37. Sudoku Solver
 * algorithm: Backtracking
 * space complexity: O(n)
 */
public class SudokuSolver {

    public static void main(String[] args) {
        SudokuSolver solution = new SudokuSolver();
        solution.test();
    }

    public void test() {
        char[][] tc1b = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                         {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                         {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                         {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                         {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                         {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                         {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                         {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                         {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        solveSudoku(tc1b);

        for (char[] chars : tc1b) {
            for (char aChar : chars) System.out.print(aChar + " ");

            System.out.println();
        }
    }

    public void solveSudoku(char[][] board) {
        Set<Integer>[] rows = new HashSet[board.length];
        Set<Integer>[]  cols = new HashSet[board.length];
        Set<Integer>[]  cells = new HashSet[board.length];

        int emptyCells = 0;

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            cells[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int box = getBoxIndex(i, j);

                if (board[i][j] == '.') {
                    emptyCells++;
                } else {
                    int value = Character.digit(board[i][j], 10);

                    rows[i].add(value);
                    cols[j].add(value);
                    cells[box].add(value);
                }
            }
        }

        solveSudoku(board, emptyCells, rows, cols, cells);
    }

    private int getBoxIndex(int i, int j) {
        return Math.floorDiv(i, 3) * 3 + Math.floorDiv(j, 3) % 3;
    }

    private boolean solveSudoku(char[][] board,
                                int emptyCells,
                                Set<Integer>[] rows,
                                Set<Integer>[] cols,
                                Set<Integer>[] cells) {
        if (emptyCells == 0) {
            return true;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    continue;
                }

                int box = getBoxIndex(i, j);

                for (int number = 1; number <= 9; number++) {
                    if (rows[i].contains(number) ||
                        cols[j].contains(number) ||
                        cells[box].contains(number)) {
                        continue;
                    }

                    rows[i].add(number);
                    cols[j].add(number);
                    cells[box].add(number);

                    board[i][j] = Character.forDigit(number, 10);
                    emptyCells--;

                    boolean valid = solveSudoku(board, emptyCells, rows, cols, cells);

                    if (!valid) {
                        emptyCells++;
                        board[i][j] = '.';

                        rows[i].remove(number);
                        cols[j].remove(number);
                        cells[box].remove(number);
                    } else {
                        return true;
                    }
                }

                if (board[i][j] == '.') {
                    return false;
                }
            }
        }

        return false;
    }



}
