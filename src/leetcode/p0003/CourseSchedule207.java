package leetcode.p0003;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jandos Iskakov
 * problem: 207. Course Schedule
 * algorithm: DFS, Graph, Topological Sort
 * time complexity: O(V+E)
 * space complexity: O(V+E)
 * Runtime: 2 ms, faster than 99.66% of Java online submissions
 * Memory Usage: 52 MB, less than 27.69% of Java online submissions
 */
public class CourseSchedule207 {

  public static void main(String[] args) {
    CourseSchedule207 solution = new CourseSchedule207();
    solution.test();
  }

  private void test() {
    System.out.println(canFinish(2, new int[][]{{1, 0}}));
    System.out.println(canFinish(2, new int[][]{{1, 0}, {0, 1}}));
  }

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    List<Integer>[] adjList = new ArrayList[numCourses];

    for (int i = 0; i < numCourses; i++) {
      adjList[i] = new ArrayList<>();
    }

    for (int[] pre : prerequisites) {
      adjList[pre[1]].add(pre[0]);
    }

    boolean[] visited = new boolean[numCourses];
    boolean[] explored = new boolean[numCourses];

    for (int i = 0; i < numCourses; i++) {
      if (!visited[i] && isCyclic(i, adjList, visited, explored)) {
        return false;
      }
    }

    return true;
  }

  private boolean isCyclic(int course, List<Integer>[] adjList, boolean[] visited,
    boolean[] explored) {
    visited[course] = true;

    for (int adj : adjList[course]) {
      if ((visited[adj] && !explored[adj]) || (!visited[adj] && isCyclic(adj, adjList, visited,
        explored))) {
        return true;
      }
    }

    explored[course] = true;

    return false;
  }

}
