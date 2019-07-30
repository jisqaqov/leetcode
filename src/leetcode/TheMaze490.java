package leetcode;

import java.util.*;

/**
 * @author Jandos Iskakov
 * problem: 490. The Maze
 * algorithm: DFS
 * time complexity: O(V+E)
 * space complexity: O(V+E)
 */
public class TheMaze490 {

    public static void main(String[] args) {
        TheMaze490 solution = new TheMaze490();
        solution.test();
    }

    public void test() {
        int[][] tc1maze = {{0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}};

        int[] tc1start = {0, 4};
        int[] tc1dest = {4, 4};

        System.out.println(hasPath(tc1maze, tc1start, tc1dest));

        int[][] tc2maze = {{0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}};

        int[] tc2start = {0, 4};
        int[] tc2dest = {3, 2};

        System.out.println(hasPath(tc2maze, tc2start, tc2dest));

        int[][] tc3maze = {{0,0,0,0,1,0,0},
                {0,0,1,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,1},
                {0,1,0,0,0,0,0},
                {0,0,0,1,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,1,0,0,0,1},
                {0,0,0,0,1,0,0}};

        int[] tc3start = {0, 0};
        int[] tc3dest = {8, 6};

        System.out.println(hasPath(tc3maze, tc3start, tc3dest));
    }

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Set<Node> visited = new HashSet<>();

        Node startNode = new Node();
        startNode.x = start[0];
        startNode.y = start[1];

        visited.add(startNode);

        for (Node adjNode : getAdjNodes(startNode)) {
            if (hasPath(adjNode, maze, destination, visited)) {
                return true;
            }
        }

        return false;
    }

    private boolean hasPath(Node currNode, int[][] maze, int[] dest, Set<Node> visited) {
        int n = maze.length, m = maze[0].length;

        if (!isInMaze(currNode.x, currNode.y, n, m)) {
            return false;
        }

        if (visited.contains(currNode)) {
            return false;
        }

        if (maze[currNode.x][currNode.y] == 1) {
            return false;
        }

        visited.add(currNode);

        Node nextNode = getNextNode(currNode);

        boolean isWall = !isInMaze(nextNode.x, nextNode.y, n, m) ||
                maze[nextNode.x][nextNode.y] == 1;

        if (isWall) {
            if (currNode.x == dest[0] && currNode.y == dest[1]) {
                return true;
            }

            for (Node adjNode : getAdjNodes(currNode)) {
                if (!isInMaze(adjNode.x, adjNode.y, n, m)) {
                    continue;
                }

                if (hasPath(adjNode, maze, dest, visited)) {
                    return true;
                }
            }
        } else if (isInMaze(nextNode.x, nextNode.y, n, m)) {
            return hasPath(nextNode, maze, dest, visited);
        }

        return false;
    }

    private List<Node> getAdjNodes(Node node) {
        List<Node> adjList = new ArrayList<>();

        Node leftNode = new Node();
        leftNode.x = node.x - 1;
        leftNode.y = node.y;
        leftNode.stepX = -1;
        adjList.add(leftNode);

        Node rightNode = new Node();
        rightNode.x = node.x + 1;
        rightNode.y = node.y;
        rightNode.stepX = 1;
        adjList.add(rightNode);

        Node upNode = new Node();
        upNode.x = node.x;
        upNode.y = node.y - 1;
        upNode.stepY = -1;
        adjList.add(upNode);

        Node downNode = new Node();
        downNode.x = node.x;
        downNode.y = node.y + 1;
        downNode.stepY = 1;
        adjList.add(downNode);

        return adjList;
    }

    private Node getNextNode(Node node) {
        Node adjNode = new Node();
        adjNode.x = node.x + node.stepX;
        adjNode.y = node.y + node.stepY;
        adjNode.stepX = node.stepX;
        adjNode.stepY = node.stepY;
        return adjNode;
    }

    private boolean isInMaze(int x, int y, int n, int m) {
        return x < n && x >= 0 && y >= 0 && y < m;
    }

    private static class Node {
        int x, y;
        int stepX = 0, stepY = 0;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x &&
                    y == node.y &&
                    stepX == node.stepX &&
                    stepY == node.stepY;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, stepX, stepY);
        }
    }


}
