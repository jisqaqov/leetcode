package leetcode.p0013;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author Jandos Iskakov
 * problem: 1197. Minimum Knight Moves
 * algorithm: BFS
 * time complexity: O(V+E)
 * space complexity: O(V+E)
 * Runtime: 895 ms, faster than 5.02% of Java online submissions for Minimum Knight Moves.
 * Memory Usage: 65.5 MB, less than 100.00% of Java online submissions for Minimum Knight Moves.
 */
public class MinimumKnightMoves1197 {
  private static final int[][] DIRECTIONS = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};

  public static void main(String[] args) {
    MinimumKnightMoves1197 problem = new MinimumKnightMoves1197();
    System.out.println(problem.minKnightMoves(2, 1));
    System.out.println(problem.minKnightMoves(5, 5));
    System.out.println(problem.minKnightMoves(2, 112));
    System.out.println(problem.minKnightMoves(270, -21));
  }

  public int minKnightMoves(int x, int y) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[] {0, 0, 0});

    Map<Integer, Set<Integer>> visited = new HashMap<>();

    while (!queue.isEmpty()) {
      int[] node = queue.poll();

      if (node[0] == x && node[1] == y) {
        return node[2];
      }

      if (visited.containsKey(node[0]) && visited.get(node[0]).contains(node[1])) {
        continue;
      }

      visited.putIfAbsent(node[0], new HashSet<>());
      visited.get(node[0]).add(node[1]);

      for (int[] dir : DIRECTIONS) {
        int tx = node[0] + dir[0];
        int ty = node[1] + dir[1];

        if (visited.containsKey(tx) && visited.get(tx).contains(ty)) {
          continue;
        }

        queue.add(new int[] {tx, ty, node[2] + 1});
      }
    }

    return -1;
  }

}
