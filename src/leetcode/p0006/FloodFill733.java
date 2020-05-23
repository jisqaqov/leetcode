package leetcode.p0006;

/**
 * @author Jandos Iskakov
 * problem: 733. Flood Fill
 * algorithm: DFS, Flood fill Technique
 * time complexity: O(n*m)
 * space complexity: O(n*m)
 */
public class FloodFill733 {

    public static void main(String[] args) {
        FloodFill733 solution = new FloodFill733();
        solution.test();
    }

    public void test() {
        int[][] tc1image = {{1,1,1},{1,1,0},{1,0,1}};

        printArray(tc1image);
        int[][] tc1output = floodFill(tc1image, 1, 1, 2);
        printArray(tc1output);

        int[][] tc2image = {{0,0,0},{0,1,1}};
        printArray(tc1image);
        int[][] tc2output = floodFill(tc2image, 1, 1, 1);
        printArray(tc2output);
    }

    private void printArray(int[][] array) {
        int n = array.length, m = array[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(array[i][j] + " ");
            }

            System.out.println();
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image.length == 0) {
            return image;
        }

        int n = image.length, m = image[0].length;

        int oldColor = image[sr][sc];

        boolean[][] visited = new boolean[n][m];

        floodFill(image, sr, sc, oldColor, newColor, visited);

        return image;
    }

    private void floodFill(int[][] image, int sr, int sc, int oldColor, int newColor, boolean[][] visited) {
        int n = image.length, m = image[0].length;

        if (sr < 0 || sc < 0 || sr >= n || sc >= m) {
            return;
        }

        if (image[sr][sc] != oldColor || visited[sr][sc]) {
            return;
        }

        image[sr][sc] = newColor;
        visited[sr][sc] = true;

        floodFill(image, sr + 1, sc, oldColor, newColor, visited);
        floodFill(image, sr - 1, sc, oldColor, newColor, visited);
        floodFill(image, sr, sc + 1, oldColor, newColor, visited);
        floodFill(image, sr, sc - 1, oldColor, newColor, visited);
    }

}
