package leetcode;

import java.util.*;

/**
 * @author Jandos Iskakov
 * problem: 210. Course Schedule II
 * algorithm: DFS, Graph, Topological Sort
 * time complexity: O(V+E)
 * space complexity: O(V+E)
 */
public class CourseScheduleII210 {

    public static void main(String[] args) {
        CourseScheduleII210 solution = new CourseScheduleII210();
        solution.test();
    }

    public void test() {
        int[][] tc1a = {{1,0},{0,1}};
        int[][] tc2a = {{1,0}};
        int[][] tc3a = {{0,1}, {0, 2}, {1, 2}};
        printArray(findOrder(2, tc1a));
        printArray(findOrder(2, tc2a));
        printArray(findOrder(3, tc3a));
    }

    private void printArray(int[] array) {
        for (int number : array) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
                return new int[0];
            }
        }

        visited.clear();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < numCourses; i++) {
            if (visited.contains(i)) {
                continue;
            }

            tsort(i, adj, visited, stack);
        }

        int[] solution = new int[numCourses];
        while (!stack.isEmpty()) {
            solution[numCourses - stack.size()] = stack.pop();
        }

        return solution;
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

    private void tsort(int course, List<Integer>[] prerequisites, Set<Integer> visited, Deque<Integer> stack) {
        visited.add(course);

        if (prerequisites[course] == null) {
            stack.push(course);
            return;
        }

        for (int prerequisit : prerequisites[course]) {
            if (visited.contains(prerequisit)) {
                continue;
            }

            tsort(prerequisit, prerequisites, visited, stack);
        }

        stack.push(course);
    }

}
