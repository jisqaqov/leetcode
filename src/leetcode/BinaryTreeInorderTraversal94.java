package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Jandos Iskakov
 * problem: 94. Binary Tree Inorder Traversal
 * algorithm: Tree, Stack, Hash Table
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 1 ms, faster than 56.06% of Java online submissions for Binary Tree Inorder Traversal.
 * Memory Usage: 35.1 MB, less than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
 */
public class BinaryTreeInorderTraversal94 {

  public static void main(String[] args) {
    BinaryTreeInorderTraversal94 problem = new BinaryTreeInorderTraversal94();
    problem.test();
  }

  private void test() {
    TreeNode root = new TreeNode(4);
    TreeNode node2 = new TreeNode(2);
    TreeNode node5 = new TreeNode(5);
    TreeNode node1 = new TreeNode(1);
    TreeNode node3 = new TreeNode(3);

    root.left = node2;
    root.right = node5;
    node2.left = node1;
    node2.right = node3;

    System.out.println(inorderTraversal(root));
  }

  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> vals = new ArrayList<>();

    Set<TreeNode> set = new HashSet<>();

    Deque<TreeNode> deque = new ArrayDeque<>();
    if (root != null) {
      deque.push(root);
    }

    while (!deque.isEmpty()) {
      TreeNode node = deque.peek();

      if (node.left == null || set.contains(node.left)) {
        deque.pop();
        if (node.right != null) {
          deque.push(node.right);
        }

        set.add(node);
        vals.add(node.val);
      } else if (!set.contains(node.left)) {
        deque.push(node.left);
      }
    }

    return vals;
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
