package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author Jandos Iskakov
 * problem: 863. All Nodes Distance K in Binary Tree
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 1 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 36.9 MB, less than 100.00% of Java online submissions
 */
public class AllNodesDistanceKInBinaryTree863 {

  public static void main(String[] args) {
    AllNodesDistanceKInBinaryTree863 solution = new AllNodesDistanceKInBinaryTree863();
    solution.test1();// [7, 4, 1]
    solution.test2();// [2]
  }

  private void test1() {
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

  private void test2() {
    IterativeVersion problem = new IterativeVersion();

    TreeNode node3 = new TreeNode(3);
    TreeNode node2 = new TreeNode(2);
    TreeNode node1 = new TreeNode(1);
    TreeNode node0 = new TreeNode(0);

    node0.left = node2;
    node0.right = node1;
    node1.left = node3;

    System.out.println(problem.distanceK(node0, node3, 3));
  }

  public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    List<Integer> output = new ArrayList<>();

    traverse(root, target, k, output);

    return output;
  }

  private int traverse(TreeNode root, TreeNode target, int k, List<Integer> output) {
    if (root == null) {
      return -1;
    }

    int dis = -1;

    if (root == target) {
      dis = 0;
      collect(root, 0, output, k);
    } else {
      int dl = traverse(root.left, target, k, output);
      int dr = traverse(root.right, target, k, output);

      if (dl >= 0 || dr >= 0) {
        dis = Math.max(dl, dr) + 1;
      }

      if (dis == k) {
        output.add(root.val);
      } else if (dl >= 0) {
        collect(root.right, dis + 1, output, k);
      } else if (dr >= 0) {
        collect(root.left, dis + 1, output, k);
      }
    }

    return dis;
  }

  private void collect(TreeNode root, int dis, List<Integer> output, int k) {
    if (root == null || dis > k) {
      return;
    }

    if (dis == k) {
      output.add(root.val);
      return;
    }

    collect(root.left, dis + 1, output, k);
    collect(root.right, dis + 1, output, k);
  }

  private static class IterativeVersion {
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
