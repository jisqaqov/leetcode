package leetcode.p0006;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jandos Iskakov
 * problem: 951. Flip Equivalent Binary Trees
 * algorithm: Tree
 * time complexity: O(N)
 * space complexity: O(H)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 37.4 MB, less than 5.55% of Java online submissions
 */
public class FlipEquivalentBinaryTrees951 {

  public static void main(String[] args) {
    FlipEquivalentBinaryTrees951 problem = new FlipEquivalentBinaryTrees951();
    problem.test();
  }

  private void test() {
    TreeNode t1root = new TreeNode(1);
    TreeNode t1node2 = new TreeNode(2);
    TreeNode t1node3 = new TreeNode(3);
    TreeNode t1node4 = new TreeNode(4);
    TreeNode t1node5 = new TreeNode(5);
    TreeNode t1node7 = new TreeNode(7);
    TreeNode t1node8 = new TreeNode(8);
    TreeNode t1node6 = new TreeNode(6);

    t1root.left = t1node2;
    t1root.right = t1node3;
    t1node2.left = t1node4;
    t1node2.right = t1node5;
    t1node5.left = t1node7;
    t1node5.right = t1node8;
    t1node3.left = t1node6;

    TreeNode t2root = new TreeNode(1);
    TreeNode t2node2 = new TreeNode(2);
    TreeNode t2node3 = new TreeNode(3);
    TreeNode t2node4 = new TreeNode(4);
    TreeNode t2node5 = new TreeNode(5);
    TreeNode t2node7 = new TreeNode(7);
    TreeNode t2node8 = new TreeNode(8);
    TreeNode t2node6 = new TreeNode(6);

    t2root.left = t2node3;
    t2root.right = t2node2;
    t2node2.left = t2node4;
    t2node2.right = t2node5;
    t2node5.right = t2node7;
    t2node5.left = t2node8;
    t2node3.right = t2node6;

    System.out.println(flipEquiv(t1root, t2root));
  }

  public boolean flipEquiv(TreeNode root1, TreeNode root2) {
    if (root1 == null || root2 == null) {
      return root1 == root2;
    }

    if (root1.val != root2.val) {
      return false;
    }

    return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) ||
      flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
  }

  private static class BfsVersion {

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
      Queue<TreeNode> queue1 = new LinkedList<>();
      Queue<TreeNode> queue2 = new LinkedList<>();

      queue1.add(root1);
      queue2.add(root2);

      while (!queue1.isEmpty() && !queue2.isEmpty()) {
        TreeNode node1 = queue1.poll();
        TreeNode node2 = queue2.poll();

        if (node1 == null || node2 == null) {
          if (!equalNodes(node1, node2)) {
            return false;
          }

          continue;
        }

        if (node1.val != node2.val) {
          return false;
        }

        if (equalNodes(node1.left, node2.left)) {
          queue1.addAll(Arrays.asList(node1.left, node1.right));
        } else {
          queue1.addAll(Arrays.asList(node1.right, node1.left));
        }

        queue2.addAll(Arrays.asList(node2.left, node2.right));
      }

      return queue1.isEmpty() && queue2.isEmpty();
    }

    private boolean equalNodes(TreeNode node1, TreeNode node2) {
      return node1 != null && node2 != null && node1.val == node2.val || node1 == null && node2 == null;
    }

  }



  /**
   * Definition for a binary tree node.
   */
  public static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

}