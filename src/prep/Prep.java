package prep;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    TreeNode node3 = new TreeNode(3);
    TreeNode node5 = new TreeNode(5);
    TreeNode node6 = new TreeNode(6);
    TreeNode node2 = new TreeNode(2);
    TreeNode node4 = new TreeNode(4);
    TreeNode node7 = new TreeNode(7);
    TreeNode node1 = new TreeNode(1);
    TreeNode node0 = new TreeNode(0);
    TreeNode node8 = new TreeNode(8);

    /*node3.left = node5;
    node3.right = node1;
    node5.left = node6;
    node5.right = node2;
    node2.left = node7;
    node2.right = node4;
    node1.left = node0;
    node1.right = node8;*/

    node0.left = node2;
    node0.right = node1;
    node1.left = node3;

    System.out.println(distanceK(node0, node3, 3));
  }

  public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    List<Integer> output = new ArrayList<>();

    collect(target, 0, output, k);

    Map<TreeNode, TreeNode> map = fillParents(root, target);

    int dis = 1;

    TreeNode node = target;

    while (dis <= k && map.get(node) != null) {
      TreeNode parent = map.get(node);

      if (dis < k) {
        if (parent.right == node) {
          collect(parent.left, dis + 1, output, k);
        } else {
          collect(parent.right, dis + 1, output, k);
        }
      } else {
        output.add(parent.val);
      }

      dis++;
      node = parent;
    }

    return output;
  }

  private Map<TreeNode, TreeNode> fillParents(TreeNode root, TreeNode target) {
    Map<TreeNode, TreeNode> map = new HashMap<>();
    map.put(root, null);

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();

      if (node == target) {
        break;
      }

      if (node.left != null) {
        map.put(node.left, node);
        queue.add(node.left);
      }

      if (node.right != null) {
        map.put(node.right, node);
        queue.add(node.right);
      }
    }

    return map;
  }

  private void collect(TreeNode root, int dis, List<Integer> output, int k) {
    if (root == null || dis > k) {
      return;
    }

    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);

    while (!queue.isEmpty() && dis <= k) {
      for (int sz = queue.size(); sz > 0; sz--) {
        TreeNode node = queue.poll();

        if (dis == k) {
          output.add(node.val);
        } else {
          if (node.left != null) {
            queue.add(node.left);
          }

          if (node.right != null) {
            queue.add(node.right);
          }
        }
      }

      dis++;
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