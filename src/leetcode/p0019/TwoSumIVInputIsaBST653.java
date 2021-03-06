package leetcode.p0019;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Jandos Iskakov
 * problem: 653. Two Sum IV - Input is a BST
 * algorithm: Tree
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 2 ms, faster than 94.47% of Java online submissions
 * Memory Usage: 42.1 MB, less than 69.64% of Java online submissions
 */
public class TwoSumIVInputIsaBST653 {

  public static void main(String[] args) {
    TwoSumIVInputIsaBST653 problem = new TwoSumIVInputIsaBST653();
    problem.test();
  }

  private void test() {
    TreeNode root = new TreeNode(5);
    TreeNode node3 = new TreeNode(3);
    TreeNode node6 = new TreeNode(6);
    TreeNode node2 = new TreeNode(2);
    TreeNode node4 = new TreeNode(4);
    TreeNode node7 = new TreeNode(7);

    root.left = node3;
    root.right = node6;
    node3.left = node2;
    node3.right = node4;
    node6.right = node7;

    System.out.println(new SetVersion().findTarget(root, 10));
  }

  public boolean findTarget(TreeNode root, int k) {
    List<Integer> list = new ArrayList<>();
    inorder(root, list);

    int i = 0;
    int j = list.size() - 1;

    while (i < j) {
      if (list.get(i) + list.get(j) > k) {
        j--;
      } else if (list.get(i) + list.get(j) < k) {
        i++;
      } else {
        return true;
      }
    }

    return false;
  }

  private void inorder(TreeNode root, List<Integer> list) {
    if (root != null) {
      inorder(root.left, list);
      inorder(root.right, list);

      list.add(root.val);
    }
  }

  private static class SetVersion {

    public boolean findTarget(TreeNode root, int k) {
      return findTarget(root, k, new HashSet<>());
    }

    private boolean findTarget(TreeNode root, int k, Set<Integer> set) {
      if (root == null) {
        return false;
      }

      if (set.contains(k - root.val)) {
        return true;
      }

      set.add(root.val);

      return findTarget(root.left, k, set) || findTarget(root.right, k, set);
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