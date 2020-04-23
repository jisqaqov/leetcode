package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jandos Iskakov
 * problem: 886. Possible Bipartition
 * algorithm: Graph, DFS
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 24 ms, faster than 54.55% of Java online submissions
 * Memory Usage: 49.1 MB, less than 100.00% of Java online submissions
 */
public class PossibleBipartition886 {

  public boolean possibleBipartition(int n, int[][] dislikes) {
    Set<Integer>[] graph = new HashSet[n + 1];
    for (int i = 1; i <= n; i++) {
      graph[i] = new HashSet<>();
    }

    for (int[] dislike : dislikes) {
      graph[dislike[0]].add(dislike[1]);
      graph[dislike[1]].add(dislike[0]);
    }

    int[] groups = new int[n + 1];

    for (int p = 1; p <= n; p++) {
      if (groups[p] == 0) {
        groups[p] = 1;

        if (!checkPossibility(groups, p, graph)) {
          return false;
        }
      }
    }

    return true;
  }

  private boolean checkPossibility(int[] groups, int person, Set<Integer>[] dislikes) {
    for (int p : dislikes[person]) {
      if (groups[person] == groups[p]) {
        return false;
      }

      if (groups[p] == 0) {
        groups[p] = -groups[person];

        if (!checkPossibility(groups, p, dislikes)) {
          return false;
        }
      }
    }

    return true;
  }

}