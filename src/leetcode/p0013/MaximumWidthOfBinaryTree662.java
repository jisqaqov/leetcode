package leetcode.p0013;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Jandos Iskakov
 * problem: 662. Maximum Width of Binary Tree
 * algorithm: Tree
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 1 ms, faster than 89.86% of Java online submissions
 * Memory Usage: 39.7 MB, less than 11.11% of Java online submissions
 */
public class MaximumWidthOfBinaryTree662 {

  public int widthOfBinaryTree(TreeNode root) {
    if (root == null) {
      return 0;
    }

    Queue<Item> queue = new LinkedList<>();
    queue.add(new Item(root, 1));

    int max = 0;

    while (!queue.isEmpty()) {
      int size = queue.size();

      // reset to 1 to avoid integer overflow
      if (size == 1) {
        queue.peek().index = 1;
      }

      int firstIndex = -1, lastIndex = -1;

      for (int i = 0; i < size; i++) {
        Item item = queue.poll();
        TreeNode node = item.node;

        if (i == 0) {
          firstIndex = item.index;
        }

        if (i == size - 1) {
          lastIndex = item.index;
        }

        if (node.left != null) {
          queue.add(new Item(node.left, item.index * 2));
        }

        if (node.right != null) {
          queue.add(new Item(node.right, item.index * 2 + 1));
        }
      }

      max = Math.max(lastIndex - firstIndex + 1, max);
    }

    return max;
  }

  private static class V2 {

    public int widthOfBinaryTree(TreeNode root) {
      Queue<TreeNode> queue = new LinkedList<>();

      if (root != null) {
        queue.add(root);
      }

      int max = queue.size();

      while (!queue.isEmpty()) {
        List<TreeNode> list = new ArrayList<>();

        for (int sz = queue.size(); sz > 0; sz--) {
          TreeNode node = queue.poll();

          if (node != null) {
            list.add(node.left);
            list.add(node.right);
          } else {
            list.add(null);
            list.add(null);
          }
        }

        int firstIndex = -1;
        int lastIndex = -1;

        for (int i = 0; i < list.size(); i++) {
          if (list.get(i) != null) {
            if (firstIndex == -1) {
              firstIndex = i;
            }

            lastIndex = i;
          }
        }

        if (firstIndex == -1) {
          break;
        }

        max = Math.max(max, lastIndex - firstIndex + 1);

        for (int i = firstIndex; i <= lastIndex; i++) {
          queue.add(list.get(i));
        }
      }

      return max;
    }

  }

  private class Item {

    TreeNode node;
    int index;

    Item(TreeNode node, int index) {
      this.node = node;
      this.index = index;
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