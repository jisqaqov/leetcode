package prep;

import java.util.ArrayList;
import java.util.List;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    TreeNode root = new TreeNode(3);
    TreeNode node5 = new TreeNode(5);
    TreeNode node6 = new TreeNode(6);
    TreeNode node2 = new TreeNode(2);
    TreeNode node4 = new TreeNode(4);
    TreeNode node7 = new TreeNode(7);
    TreeNode node1 = new TreeNode(1);
    TreeNode node0 = new TreeNode(0);
    TreeNode node8 = new TreeNode(8);

    root.left = node5;
    root.right = node1;
    node5.left = node6;
    node5.right = node2;
    node2.left = node7;
    node2.right = node4;
    node1.left = node0;
    node1.right = node8;

    System.out.println(distanceK(root, node5, 2));
  }

  public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    

    return null;
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