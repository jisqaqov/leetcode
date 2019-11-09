package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * @author Jandos Iskakov
 * problem: 987. Vertical Order Traversal of a Binary Tree
 * algorithm: Tree, Hash Table, Sort
 * time complexity:
 * space complexity:
 * Runtime: 7 ms, faster than 23.44% of Java online submissions for Vertical Order Traversal of a Binary Tree.
 * Memory Usage: 36.6 MB, less than 100.00% of Java online submissions for Vertical Order Traversal of a Binary Tree.
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
      sol.add(levels.get(level).stream().map(vals -> vals[0]).collect(Collectors.toList()));
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
