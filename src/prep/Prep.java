package prep;

import java.util.ArrayDeque;
import java.util.Deque;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    //TODO:
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(1);
    root.right = new TreeNode(3);

    System.out.println(isValidBST(root));

  }

  public boolean isValidBST(TreeNode root) {
    Deque<TreeNode> stack = new ArrayDeque<>();

    TreeNode node = root;
    TreeNode prev = null;

    while (node != null || !stack.isEmpty()) {
      while (node != null) {
        stack.addLast(node);
        node = node.left;
      }

      node = stack.pollLast();

      if (prev != null && node.val < prev.val) {
        return false;
      }

      prev = node;

      node = node.right;
    }

    return true;
  }

  private class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
      this.val = val;
    }
  }

}