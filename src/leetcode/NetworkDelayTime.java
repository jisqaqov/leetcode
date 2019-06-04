package leetcode;

import java.util.Arrays;

/**
 * @author Jandos Iskakov
 * problem: 743. Network Delay Time
 * algorithm: Graph, Bellman-Ford
 * time complexity: O(V*E)
 * space complexity: O(V+E)
 */
public class NetworkDelayTime {

    public static void main(String[] args) {
        NetworkDelayTime solution = new NetworkDelayTime();

        int[][] tc1times = {{2,1,3}, {1,2,1}};

        System.out.println(solution.networkDelayTime(tc1times, 2, 2));
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dis = new int[n];

        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[k - 1] = 0;

        for (int i = 1; i <= n - 1; i++) {
            for (int[] time : times) {
                int u = time[0] - 1;
                int v = time[1] - 1;
                int w = time[2];

                if (dis[v] > dis[u] + w && dis[u] != Integer.MAX_VALUE) {
                    dis[v] = dis[u] + w;
                }
            }
        }

        int delay = Arrays.stream(dis)
                .max()
                .getAsInt();

        return  delay == Integer.MAX_VALUE? -1: delay;
    }

}
