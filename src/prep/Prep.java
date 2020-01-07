package prep;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
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