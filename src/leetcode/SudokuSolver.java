package leetcode;

import java.util.*;

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
        Map<Integer, Set<Integer>> rows = new HashMap<>();
        Map<Integer, Set<Integer>> cols = new HashMap<>();
        Map<Integer, Set<Integer>> cells = new HashMap<>();
        List<Integer> boxes = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            rows.put(i, new HashSet<>());
            boxes.add(i);

            for (int j = 0; j < 9; j++) {
                if (!cols.containsKey(j))
                    cols.put(j, new HashSet<>());

                int box = Math.floorDiv(i, 3) * 3 + Math.floorDiv(j, 3) % 3;
                if (!cells.containsKey(box))
                    cells.put(box, new HashSet<>());

                if (board[i][j] != '.') {
                    int val = Integer.parseInt(String.valueOf(board[i][j]));
                    rows.get(i).add(val);
                    cols.get(j).add(val);
                    cells.get(box).add(val);
                }
            }
        }

        boxes.sort((o1, o2) -> cells.get(o2).size() - cells.get(o1).size());

        solveSudoku(board, 0, rows, cols, cells, boxes);
    }

    public boolean solveSudoku(char[][] board, int boxIndex,
                               Map<Integer, Set<Integer>> rows,
                               Map<Integer, Set<Integer>> cols,
                               Map<Integer, Set<Integer>> cells,
                               List<Integer> boxes) {
        int box = boxes.get(boxIndex);
        int row = Math.floorDiv(box, 3) * 3;
        int col = (box % 3) * 3;

        int n = row + 3, m = col + 3;
        for (int i = row; i < n; i++) {
            for (int j = col; j < m; j++) {
                if (board[i][j] != '.')
                    continue;

                for (int a = 1; a <= 9; a++) {
                    if (cells.get(box).contains(a) || rows.get(i).contains(a) || cols.get(j).contains(a))
                        continue;

                    rows.get(i).add(a);
                    cols.get(j).add(a);
                    cells.get(box).add(a);
                    board[i][j] = Character.forDigit(a, 10);

                    boolean valid = false;
                    if (cells.get(box).size() == 9) {
                        if (boxIndex == 8) {
                            return true;
                        } else {
                            valid = solveSudoku(board, boxIndex + 1, rows, cols, cells, boxes);
                            System.out.println("box: " + boxIndex + " completed " + valid);
                        }
                    } else {
                        valid = solveSudoku(board, boxIndex, rows, cols, cells, boxes);
                    }

                    if (!valid) {
                        board[i][j] = '.';
                        rows.get(i).remove(a);
                        cols.get(j).remove(a);
                        cells.get(box).remove(a);
                    } else {
                        return true;
                    }
                }
            }
        }

        return false;
    }



}
