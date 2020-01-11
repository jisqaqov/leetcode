package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 549. Binary Tree Longest Consecutive Sequence II
 * algorithm: Tree
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 1 ms, faster than 97.82% of Java online submissions
 * Memory Usage: 39.5 MB, less than 33.33% of Java online submissions
 */
public class BinaryTreeLongestConsecutiveSequenceII549 {

  public static void main(String[] args) {
    BinaryTreeLongestConsecutiveSequenceII549 problem =
      new BinaryTreeLongestConsecutiveSequenceII549();

    Solution solution = new Solution();

    problem.test1(solution);
    problem.test2(solution);
    problem.test3(solution);
    problem.test4(solution);
  }

  private void test1(Solution solution) {
    TreeNode root = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);

    root.left = node2;
    root.right = node3;

    System.out.println(solution.longestConsecutive(root));//2
  }

  private void test2(Solution solution) {
    TreeNode root = new TreeNode(2);
    TreeNode node1 = new TreeNode(1);
    TreeNode node3 = new TreeNode(3);

    root.left = node1;
    root.right = node3;

    System.out.println(solution.longestConsecutive(root));//3
  }

  private void test3(Solution solution) {
    TreeNode root = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);

    root.left = node2;
    root.right = node3;
    node2.left = node4;

    System.out.println(solution.longestConsecutive(root));//2
  }

  private void test4(Solution solution) {
    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);

    node3.right = node4;
    node4.right = node1;
    node1.right = node2;

    System.out.println(solution.longestConsecutive(node3));//2
  }

  private static class Solution {

    private int max = 0;

    public int longestConsecutive(TreeNode root) {
      max = 0;
      helper(root);
      return max;
    }

    private int[] helper(TreeNode root) {
      if (root == null) {
        return new int[] {0, 0};
      }

      int[] left = helper(root.left);
      int[] right = helper(root.right);

      int leftVal = root.left != null ? root.left.val : 0;
      int rightVal = root.right != null ? root.right.val : 0;

      if (root.val - leftVal == -1) {
        left[0]++;
        left[1] = 0;
      } else if (root.val - leftVal == 1) {
        left[0] = 0;
        left[1]++;
      } else {
        left[0] = 1;
        left[1] = 1;
      }

      if (root.val - rightVal == -1) {
        right[0]++;
        right[1] = 0;
      } else if (root.val - rightVal == 1) {
        right[0] = 0;
        right[1]++;
      } else {
        right[0] = 1;
        right[1] = 1;
      }

      int[] len = new int[2];
      len[0] = Math.max(Math.max(left[0], right[0]), 1);
      len[1] = Math.max(Math.max(left[1], right[1]), 1);

      int len2 = 0;
      if (root.val - leftVal == 1 && root.val - rightVal == -1) {
        len2 = left[1] + right[0] - 1;
      } else if (root.val - rightVal == 1 && root.val - leftVal == -1) {
        len2 = left[0] + right[1] - 1;
      }

      max = Math.max(max, len[0]);
      max = Math.max(max, len[1]);
      max = Math.max(max, len2);

      return len;
    }

  }

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

}
