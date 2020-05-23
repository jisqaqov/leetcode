package leetcode.p0018;

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
 * problem: 865. Smallest Subtree with all the Deepest Nodes
 * algorithm: Tree, BFS, DFS
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 37.3 MB, less than 80.00% of Java online submissions
 */
public class SmallestSubtreeWithAllTheDeepestNodes865 {

  public static void main(String[] args) {
    SmallestSubtreeWithAllTheDeepestNodes865 problem =
      new SmallestSubtreeWithAllTheDeepestNodes865();

    problem.test1();
    problem.test2();
    problem.test3();
    problem.test4();
  }

  private void test1() {
    TreeNode root = new TreeNode(3);
    TreeNode node5 = new TreeNode(5);
    TreeNode node1 = new TreeNode(1);
    TreeNode node6 = new TreeNode(6);
    TreeNode node2 = new TreeNode(2);
    TreeNode node7 = new TreeNode(7);
    TreeNode node4 = new TreeNode(4);
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

    System.out.println(subtreeWithAllDeepest(root));//2
  }

  private void test2() {
    TreeNode root = new TreeNode(0);
    TreeNode node1 = new TreeNode(1);
    TreeNode node3 = new TreeNode(3);
    TreeNode node2 = new TreeNode(2);

    root.left = node1;
    root.right = node3;
    node1.right = node2;

    System.out.println(subtreeWithAllDeepest(root));//2
  }

  private void test3() {
    TreeNode root = new TreeNode(0);
    TreeNode node3 = new TreeNode(3);
    TreeNode node1 = new TreeNode(1);
    TreeNode node4 = new TreeNode(4);
    TreeNode node2 = new TreeNode(2);
    TreeNode node6 = new TreeNode(6);
    TreeNode node5 = new TreeNode(5);

    root.left = node3;
    root.right = node1;
    node3.left = node4;
    node1.left = node2;
    node4.right = node6;
    node2.right = node5;

    System.out.println(subtreeWithAllDeepest(root));//0
  }

  private void test4() {
    System.out.println(subtreeWithAllDeepest(null));//null
  }

  public TreeNode subtreeWithAllDeepest(TreeNode root) {
    return (TreeNode) helper(root)[1];
  }

  private Object[] helper(TreeNode root) {
    if (root == null) {
      return new Object[] {0, null};
    }

    Object[] left = helper(root.left);
    Object[] right = helper(root.right);

    int lh = (int) left[0] + 1;
    int lr = (int) right[0] + 1;

    if (lh == lr) {
      return new Object[] {lh, root};
    } else if (lh > lr) {
      return new Object[] {lh, left[1]};
    }

    return new Object[] {lr, right[1]};
  }

  private static class V2 {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
      return helper(root,  maxDepth(root));
    }

    private TreeNode helper(TreeNode root, int depth) {
      if (depth == 1 || root == null) {
        return root;
      }

      TreeNode left = helper(root.left, depth - 1);
      TreeNode right = helper(root.right, depth - 1);

      if (left != null && right != null) {
        return root;
      } else if (left != null) {
        return left;
      }

      return right;
    }

    private int maxDepth(TreeNode root) {
      if (root == null) {
        return 0;
      }

      int lh = maxDepth(root.left);
      int lr = maxDepth(root.right);

      return Math.max(lh, lr) + 1;
    }
  }

  private static class V3 {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
      if (root == null) {
        return null;
      }

      Map<TreeNode, TreeNode> parents = new HashMap<>();
      parents.put(root, null);

      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);

      List<TreeNode> leafs = new ArrayList<>();

      while (!queue.isEmpty()) {
        leafs.clear();
        leafs.addAll(queue);

        for (int sz = queue.size(); sz > 0; sz--) {
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
      }

      queue.addAll(leafs);
      Set<Integer> used = new HashSet<>();

      while (queue.size() > 1) {
        for (int sz = queue.size(); sz > 0; sz--) {
          TreeNode node = queue.poll();
          TreeNode parent = parents.get(node);

          if (used.contains(parent.val)) {
            continue;
          }

          used.add(parent.val);
          queue.add(parent);
        }
      }

      return queue.poll();
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

    @Override
    public String toString() {
      return "TreeNode{" +
        "val=" + val +
        ", left=" + left +
        ", right=" + right +
        '}';
    }
  }

}