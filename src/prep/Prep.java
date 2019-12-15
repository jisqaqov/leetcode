package prep;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    //TODO:
    double k = 1;
    int val = 3;
    double target = 3.12;
    if (Math.abs(val - target) < Math.abs(k - target)) {
      k = val;
    }
  }

  public int closestValue(TreeNode root, double target) {
    double k = root.val;
    TreeNode node = root;

    while (node != null) {
      if (Math.abs(node.val - target) < Math.abs(k - target)) {
        k = root.val;
      }

      if (root.val > target) {
        node = node.left;
      } else {
        node = node.right;
      }
    }

    return (int) k;
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