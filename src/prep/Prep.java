package prep;

import java.util.HashMap;
import java.util.Map;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    System.out.println(bstToGst(null));
  }

  public TreeNode bstToGst(TreeNode root) {
    Map<Integer, Integer> map = new HashMap<>();

    sumTree(root, map);

    return helper(root, map, 0);
  }

  private TreeNode helper(TreeNode root, Map<Integer, Integer> map, int p) {
    if (root == null) {
      return null;
    }

    int sum = root.val + p;

    if (root.right != null) {
      sum += map.get(root.right.val);
    }

    TreeNode clone = new TreeNode(sum);

    TreeNode left = helper(root.left, map, sum);
    TreeNode right = helper(root.right, map, p);

    clone.left = left;
    clone.right = right;

    return clone;
  }

  private int sumTree(TreeNode root, Map<Integer, Integer> map) {
    if (root == null) {
      return 0;
    }

    int ls = sumTree(root.left, map);
    int rs = sumTree(root.right, map);

    int sum = root.val + ls + rs;

    map.put(root.val, sum);

    return sum;
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