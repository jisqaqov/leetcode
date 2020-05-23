package leetcode.p0018;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jandos Iskakov
 * problem: 934. Shortest Bridge
 * algorithm: BFS
 * time complexity: O(N*M)
 * space complexity: O(N*M)
 */
public class ShortestBridge934 {

    public static void main(String[] args) {
        ShortestBridge934 problem = new ShortestBridge934();
        problem.test();
    }

    public void test() {
        System.out.println(shortestBridge(new int[][]{
                {0,1},
                {1,0}
        }));

        System.out.println(shortestBridge(new int[][]{
                {0,1,0},
                {0,0,0},
                {0,0,1}
        }));

        System.out.println(shortestBridge(new int[][]{
                {1,1,1,1,1},
                {1,0,0,0,1},
                {1,0,1,0,1},
                {1,0,0,0,1},
                {1,1,1,1,1}
        }));

        System.out.println(shortestBridge(new int[][]{
                {0,0,1,0,1},
                {0,1,1,0,1},
                {0,1,0,0,1},
                {0,0,0,0,0},
                {0,1,1,0,0}
        }));
    }

    public int shortestBridge(int[][] a) {
        int n = a.length, m = a[0].length;

        boolean[][] visited = new boolean[n][m];

        Queue<int[]> island = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 1) {
                    island.add(new int[] {i, j});
                    break;
                }
            }

            if (!island.isEmpty()) {
                break;
            }
        }

        Queue<int[]> queue = new LinkedList<>();

        while (!island.isEmpty()) {
            int[] node = island.poll();

            int i = node[0], j = node[1];
            if (visited[i][j]) {
                continue;
            }

            visited[i][j] = true;
            queue.add(new int[] {i, j});

            if (i < n - 1 && a[i + 1][j] == 1) {
                island.add(new int[] {i + 1, j});
            }
            if (i > 0 && a[i - 1][j] == 1) {
                island.add(new int[] {i - 1, j});
            }
            if (j < m - 1 && a[i][j + 1] == 1) {
                island.add(new int[] {i, j + 1});
            }
            if (j > 0 && a[i][j - 1] == 1) {
                island.add(new int[] {i, j - 1});
            }
        }

        int[][] dis = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }

        Iterator<int[]> it = queue.iterator();
        while (it.hasNext()) {
            int[] node = it.next();

            int i = node[0], j = node[1];

            if ((i > 0 && a[i - 1][j] == 0) || (i < n - 1 && a[i + 1][j] == 0) ||
                (j > 0 && a[i][j - 1] == 0) || (j < m - 1 && a[i][j + 1] == 0)) {
                dis[i][j] = 0;
            } else {
                it.remove();
            }
        }

        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            int i = node[0], j = node[1];

            if (i < n - 1 && a[i + 1][j] == 1 && !visited[i + 1][j]) {
                return dis[i][j];
            }
            if (i > 0 && a[i - 1][j] == 1 && !visited[i - 1][j]) {
                return dis[i][j];
            }
            if (j < m - 1 && a[i][j + 1] == 1 && !visited[i][j + 1]) {
                return dis[i][j];
            }
            if (j > 0 && a[i][j - 1] == 1 && !visited[i][j - 1]) {
                return dis[i][j];
            }

            if (i < n - 1 && a[i + 1][j] == 0 && !visited[i + 1][j]) {
                queue.add(new int[] {i + 1, j});
                visited[i + 1][j] = true;
                dis[i + 1][j] = Math.min(dis[i + 1][j], dis[i][j] + 1);
            }
            if (i > 0 && a[i - 1][j] == 0 && !visited[i - 1][j]) {
                queue.add(new int[] {i - 1, j});
                visited[i - 1][j] = true;
                dis[i - 1][j] = Math.min(dis[i - 1][j], dis[i][j] + 1);
            }
            if (j < m - 1 && a[i][j + 1] == 0 && !visited[i][j + 1]) {
                queue.add(new int[] {i, j + 1});
                visited[i][j + 1] = true;
                dis[i][j + 1] = Math.min(dis[i][j + 1], dis[i][j] + 1);
            }
            if (j > 0 && a[i][j - 1] == 0 && !visited[i][j - 1]) {
                queue.add(new int[] {i, j - 1});
                visited[i][j - 1] = true;
                dis[i][j - 1] = Math.min(dis[i][j - 1], dis[i][j] + 1);
            }
        }

        return 0;
    }

}
