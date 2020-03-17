package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author Jandos Iskakov
 * problem: 1214. Two Sum BSTs
 * algorithm: Tree
 * time complexity: O(N1 + N2)
 * space complexity: O(N1 + N2)
 * Runtime: 2 ms, faster than 85.18% of Java online submissions
 * Memory Usage: 42.5 MB, less than 100.00% of Java online submissions
 */
public class TwoSumBSTs1214 {

  public static void main(String[] args) {
    TwoSumBSTs1214 problem = new TwoSumBSTs1214();
    problem.test();
  }

  private void test() {
    TreeNode root1 = new TreeNode(2);
    root1.left = new TreeNode(1);
    root1.right = new TreeNode(4);

    TreeNode root2 = new TreeNode(1);
    root2.left = new TreeNode(0);
    root2.right = new TreeNode(3);

    System.out.println(twoSumBSTs(root1, root2, 5));//true
    System.out.println(twoSumBSTs(root1, root2, 8));//true
  }

  public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
    List<Integer> list1 = new ArrayList<>();
    inorder(root1, list1);

    List<Integer> list2 = new ArrayList<>();
    inorder(root2, list2);

    int i = 0, j = list2.size() - 1;

    while (i < list1.size() && j >= 0) {
      int sum = list1.get(i) + list2.get(j);
      if (sum == target) {
        return true;
      }

      if (sum > target) {
        j--;
      } else {
        i++;
      }
    }

    return false;
  }

  private void inorder(TreeNode root, List<Integer> list) {
    if (root != null) {
      inorder(root.left, list);
      list.add(root.val);
      inorder(root.right, list);
    }
  }

  private static class SetVersion {

    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
      Set<Integer> set = new HashSet<>();

      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root1);

      while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        set.add(node.val);

        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }

      queue.add(root2);
      while (queue.isEmpty()) {
        TreeNode node = queue.poll();
        if (set.contains(target - node.val)) {
          return true;
        }

        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }

      return false;
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