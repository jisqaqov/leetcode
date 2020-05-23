package leetcode.p0001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author Jandos Iskakov
 * problem: 863. All Nodes Distance K in Binary Tree
 * algorithm: BFS, DFS, Hash Table
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 3 ms, faster than 62.38% of Java online submissions
 * Memory Usage: 36.2 MB, less than 100.00% of Java online submissions
 */
public class AllNodesDistanceKInBinaryTree863 {

  public static void main(String[] args) {
    AllNodesDistanceKInBinaryTree863 solution = new AllNodesDistanceKInBinaryTree863();
    solution.test1();// [7, 4, 1]
    solution.test2();// [2]
  }

  private void test1() {
    TreeNode root = new TreeNode(3);
    TreeNode node5 = new TreeNode(5);
    TreeNode node6 = new TreeNode(6);
    TreeNode node2 = new TreeNode(2);
    TreeNode node4 = new TreeNode(4);
    TreeNode node7 = new TreeNode(7);
    TreeNode node1 = new TreeNode(1);
    TreeNode node0 = new TreeNode(0);
    TreeNode node8 = new TreeNode(8);

    root.left = node5;
    root.right = node1;
    node5.left = node6;
    node5.right = node2;
    node2.left = node7;
    node2.right = node4;
    node1.left = node0;
    node1.right = node8;

    System.out.println(distanceK(root, node5, 2));
  }

  private void test2() {
    TreeNode node3 = new TreeNode(3);
    TreeNode node2 = new TreeNode(2);
    TreeNode node1 = new TreeNode(1);
    TreeNode node0 = new TreeNode(0);

    node0.left = node2;
    node0.right = node1;
    node1.left = node3;

    System.out.println(distanceK(node0, node3, 3));
  }

  public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    Map<TreeNode, TreeNode> parents = new HashMap<>();
    parents.put(root, null);

    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();

      if (node.left != null) {
        parents.put(node.left, node);
        queue.add(node.left);
      }

      if (node.right != null) {
        parents.put(node.right, node);
        queue.add(node.right);
      }
    }

    Set<TreeNode> visited = new HashSet<>();

    queue.add(target);
    visited.add(target);

    while (k > 0 && !queue.isEmpty()) {
      for (int sz = queue.size(); sz > 0; sz--) {
        TreeNode node = queue.poll();

        if (node.left != null && visited.add(node.left)) {
          queue.add(node.left);
        }

        if (node.right != null && visited.add(node.right)) {
          queue.add(node.right);
        }

        TreeNode parent = parents.get(node);
        if (parent != null && visited.add(parent)) {
          queue.add(parent);
        }
      }

      k--;
    }

    List<Integer> output = new ArrayList<>();

    while (!queue.isEmpty()) {
      output.add(queue.poll().val);
    }

    return output;
  }

  private static class V2 {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
      List<Integer> output = new ArrayList<>();

      postorder(root, target, k, output);

      return output;
    }

    private int postorder(TreeNode root, TreeNode target, int k, List<Integer> output) {
      int dis = -1;

      if (root == target) {
        dis = 0;
        collect(root, 0, output, k);
      } else if (root != null) {
        int dl = postorder(root.left, target, k, output);
        int dr = postorder(root.right, target, k, output);

        if (dl >= 0 || dr >= 0) {
          dis = Math.max(dl, dr) + 1;
        }

        if (dis == k) {
          output.add(root.val);
        } else if (dl >= 0) {
          collect(root.right, dis + 1, output, k);
        } else if (dr >= 0) {
          collect(root.left, dis + 1, output, k);
        }
      }

      return dis;
    }

    private void collect(TreeNode root, int dis, List<Integer> output, int k) {
      if (root == null || dis > k) {
        return;
      }

      if (dis == k) {
        output.add(root.val);
        return;
      }

      collect(root.left, dis + 1, output, k);
      collect(root.right, dis + 1, output, k);
    }
  }

  /**
   * Definition for a binary tree node.
   */
  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

}
