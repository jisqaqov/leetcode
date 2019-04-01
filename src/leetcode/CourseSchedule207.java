package leetcode;

import java.util.*;

/**
 * @author Jandos Iskakov
 * problem: 207. Course Schedule
 * algorithm: DFS, Graph, Topological Sort
 * time complexity: O(V+E)
 * space complexity: O(V+E)
 */
public class CourseSchedule207 {

    public static void main(String[] args) {
        CourseSchedule207 solution = new CourseSchedule207();
        solution.test();
    }

    public void test() {
        int[][] tc1a = {{1,0},{0,1}};
        int[][] tc2a = {{1,0}};
        int[][] tc3a = {{0,1}, {0, 2}, {1, 2}};
        System.out.println(!canFinish(2, tc1a));
        System.out.println(canFinish(2, tc2a));
        System.out.println(canFinish(3, tc3a));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new List[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            if (adj[prerequisites[i][1]] == null) {
                adj[prerequisites[i][1]] = new LinkedList<>();
            }

            adj[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        Set<Integer> explored = new HashSet<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            if (!visited.contains(i) && !canFinish(i, adj, visited, explored)) {
                return false;
            }
        }

        return true;
    }

    private boolean canFinish(int course, List<Integer>[] prerequisites, Set<Integer> visited, Set<Integer> explored) {
        visited.add(course);

        if (prerequisites[course] == null) {
            explored.add(course);

            return true;
        }

        for (int prerequisit : prerequisites[course]) {
            if (!explored.contains(prerequisit) && visited.contains(prerequisit)) {
                return false;
            } else if (!visited.contains(prerequisit)) {
                boolean canFinish = canFinish(prerequisit, prerequisites, visited, explored);
                if (!canFinish) {
                    return false;
                }
            }
        }

        explored.add(course);

        return true;
    }

}
