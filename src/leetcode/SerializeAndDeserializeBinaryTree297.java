package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


/**
 * @author Jandos Iskakov
 * problem: 297. Serialize and Deserialize Binary Tree
 * algorithm: BFS, Binary Tree
 * time complexity: O(N)
 * space complexity: O(N)
 * Produces level by level in format: 1:2;3:null;null;4;5:null;null;null;null
 * Runtime: 13 ms, faster than 54.24% of Java online submissions for Serialize and Deserialize Binary Tree.
 * Memory Usage: 40.3 MB, less than 31.43% of Java online submissions for Serialize and Deserialize Binary Tree.
 */
public class SerializeAndDeserializeBinaryTree297 {

  public static void main(String[] args) {
    SerializeAndDeserializeBinaryTree297 problem = new SerializeAndDeserializeBinaryTree297();
    problem.test();
  }

  private void test() {
    TreeNode root = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(5);

    root.left = node2;
    root.right = node3;
    node3.left = node4;
    node3.right = node5;

    String data = serialize(root);
    System.out.println(data);
    System.out.println(deserialize(data));
  }

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if (root == null) {
      return "null";
    }

    return root.val + ";" + serialize(root.left) + ";"
      + serialize(root.right);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(";")));
    return deserialize(queue);
  }

  private TreeNode deserialize(Queue<String> queue) {
    String valueString = queue.poll();
    if (valueString.equals("null")) {
      return null;
    }

    int value = Integer.parseInt(valueString);
    TreeNode node = new TreeNode(value);
    node.left = deserialize(queue);
    node.right = deserialize(queue);
    return node;
  }

  private class V2 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
      if (root == null) {
        return null;
      }

      StringBuilder sb = new StringBuilder();

      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);

      while (!queue.isEmpty()) {
        if (sb.length() > 0) {
          sb.append(":");
        }

        int size = queue.size();

        for (int i = 0; i < size; i++) {
          TreeNode node = queue.poll();

          if (i > 0) {
            sb.append(";");
          }

          sb.append(node != null? node.val: "null");

          if (node != null) {
            queue.add(node.left);
            queue.add(node.right);
          }
        }
      }

      return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
      if (data == null) {
        return null;
      }

      String[] levels = data.split(":");

      TreeNode root = new TreeNode(Integer.parseInt(levels[0]));

      Queue<TreeNode> queue = new ArrayDeque<>();
      queue.add(root);

      for (int i = 1; i < levels.length; i++) {
        String s = levels[i];

        String[] nodes = s.split(";");

        for (int j = 0; j < nodes.length; j += 2) {
          TreeNode node = queue.poll();
          String left = nodes[j];
          String right = nodes[j + 1];

          if (!left.equals("null")) {
            node.left = new TreeNode(Integer.parseInt(left));
            queue.add(node.left);
          }

          if (!right.equals("null")) {
            node.right = new TreeNode(Integer.parseInt(right));
            queue.add(node.right);
          }
        }
      }

      return root;
    }
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
