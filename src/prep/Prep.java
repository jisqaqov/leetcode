package prep;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();

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

    System.out.println(solution.longestConsecutive(root));
  }

  private void test2(Solution solution) {
    TreeNode root = new TreeNode(2);
    TreeNode node1 = new TreeNode(1);
    TreeNode node3 = new TreeNode(3);

    root.left = node1;
    root.right = node3;

    System.out.println(solution.longestConsecutive(root));
  }

  private void test3(Solution solution) {
    TreeNode root = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);

    root.left = node2;
    root.right = node3;
    node2.left = node4;

    System.out.println(solution.longestConsecutive(root));
  }

  private void test4(Solution solution) {
    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);

    node3.right = node4;
    node4.right = node1;
    node1.right = node2;

    System.out.println(solution.longestConsecutive(node3));
  }

  private static class Solution {

    private int max = 0;

    public int longestConsecutive(TreeNode root) {
      max = 0;
      helper(root);
      return max;
    }

    private int[] helper(TreeNode root) {
      int[] len = {0, 0};
      if (root == null) {
        return len;
      }

      len[0] = len[1] = 1;

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
        right[1]++;
        right[0] = 0;
      } else {
        right[0] = 1;
        right[1] = 1;
      }

      len[0] = Math.max(Math.max(left[0], right[0]), 1);
      len[1] = Math.max(Math.max(left[1], right[1]), 1);

      int len2 = 0;
      if (root.val - leftVal == 1 && root.val - rightVal == -1) {
        len2 = left[1] + right[0] - 1;
      } else if (root.val - leftVal == -1 && root.val - rightVal == 1) {
        len2 = left[0] + right[1] - 1;
      }

      max = Math.max(max, left[0]);
      max = Math.max(max, left[1]);
      max = Math.max(max, right[0]);
      max = Math.max(max, right[1]);
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