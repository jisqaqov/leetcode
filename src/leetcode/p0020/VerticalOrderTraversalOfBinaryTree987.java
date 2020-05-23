package leetcode.p0020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 987. Vertical Order Traversal of a Binary Tree
 * algorithm: Tree, Hash Table, Sort
 * time complexity: O(nlog(n))
 * space complexity: O(n)
 * Runtime: 3 ms, faster than 75.00% of Java online submissions for Vertical Order Traversal of a Binary Tree.
 * Memory Usage: 36.1 MB, less than 100.00% of Java online submissions for Vertical Order Traversal of a Binary Tree.
 */
public class VerticalOrderTraversalOfBinaryTree987 {

  public static void main(String[] args) {
    VerticalOrderTraversalOfBinaryTree987 problem = new VerticalOrderTraversalOfBinaryTree987();
    problem.test();
  }

  private void test() {
    TreeNode root = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(5);
    TreeNode node3 = new TreeNode(3);
    TreeNode node6 = new TreeNode(6);
    TreeNode node7 = new TreeNode(7);

    root.left = node2;
    root.right = node3;
    node2.left = node4;
    node2.right = node5;
    node3.left = node6;
    node3.right = node7;

    System.out.println(verticalTraversal(root));

    V2 v2 = new V2();
    System.out.println(v2.verticalTraversal(root));
  }

  public List<List<Integer>> verticalTraversal(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }

    Map<Integer, List<int[]>> levels = new HashMap<>();

    preorder(root, 0, 0, levels);

    int firstLevel = levels.size() + 1;
    for (int level : levels.keySet()) {
      firstLevel = Math.min(firstLevel, level);
    }

    List<List<Integer>> sol = new ArrayList<>();

    int level = firstLevel;
    for (int x = 0; x < levels.size(); x++, level++) {
      levels.get(level).sort((a1, a2) -> {
        if (a1[1] != a2[1]) {
          return a1[1] - a2[1];
        }

        return a1[0] - a2[0];
      });

      List<Integer> tempList = new ArrayList<>();
      for (int[] arr : levels.get(level)) {
        tempList.add(arr[0]);
      }

      sol.add(tempList);
    }

    return sol;
  }

  private void preorder(TreeNode root, int x, int y, Map<Integer, List<int[]>> levels) {
    if (root == null) {
      return;
    }

    levels.putIfAbsent(x, new ArrayList<>());
    levels.get(x).add(new int[]{root.val, y});

    preorder(root.left, x - 1, y + 1, levels);
    preorder(root.right, x + 1, y + 1, levels);
  }

  private static class V2 {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
      if (root == null) {
        return new ArrayList<>();
      }

      List<int[]> nodes = new ArrayList<>();

      preorder(root, 0, 0, nodes);

      nodes.sort((node1, node2) -> {
        if (node1[1] != node2[1]) {
          return node1[1] - node2[1];
        }

        if (node1[2] != node2[2]) {
          return node1[2] - node2[2];
        }

        return node1[0] - node2[0];
      });

      List<List<Integer>> sol = new ArrayList<>();
      sol.add(new ArrayList<>());
      sol.get(0).add(nodes.get(0)[0]);

      for (int i = 1; i < nodes.size(); i++) {
        if (nodes.get(i)[1] != nodes.get(i - 1)[1]) {
          sol.add(new ArrayList<>());
        }

        sol.get(sol.size() - 1).add(nodes.get(i)[0]);
      }

      return sol;
    }

    private void preorder(TreeNode root, int x, int y, List<int[]> nodes) {
      if (root == null) {
        return;
      }

      nodes.add(new int[] {root.val, x, y});

      preorder(root.left, x - 1, y + 1, nodes);
      preorder(root.right, x + 1, y + 1, nodes);
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
