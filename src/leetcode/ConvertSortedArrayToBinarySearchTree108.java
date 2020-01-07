package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 108. Convert Sorted Array to Binary Search Tree
 * algorithm: Divide and Conquer
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 36.9 MB, less than 100.00% of Java online submissions
 */
public class ConvertSortedArrayToBinarySearchTree108 {

  public static void main(String[] args) {
    ConvertSortedArrayToBinarySearchTree108 problem =
      new ConvertSortedArrayToBinarySearchTree108();
    problem.test();
  }

  private void test() {
    int[] tc1a = new int[]{-10, -3, 0, 5, 9};
    System.out.println(sortedArrayToBST(tc1a));
  }

  public TreeNode sortedArrayToBST(int[] nums) {
    return build(nums, 0, nums.length - 1);
  }

  private TreeNode build(int[] nums, int l, int r) {
    if (l > r) {
      return null;
    }

    int idx = l + (r - l) / 2;

    TreeNode root = new TreeNode(nums[idx]);
    root.left = build(nums, l, idx - 1);
    root.right = build(nums, idx + 1, r);

    return root;
  }

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