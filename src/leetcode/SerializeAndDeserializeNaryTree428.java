package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * @author Jandos Iskakov
 * problem: 428. Serialize and Deserialize N-ary Tree
 * algorithm: BFS, Tree
 * time complexity: O(N)
 * space complexity: O(N)
 * Produces level by level in format: 1:3/3:2;2:0;4:0/5:0;6:0
 * Runtime: 12 ms, faster than 39.49% of Java online submissions for Serialize and Deserialize N-ary Tree.
 * Memory Usage: 54.3 MB, less than 5.55% of Java online submissions for Serialize and Deserialize N-ary Tree.
 */
public class SerializeAndDeserializeNaryTree428 {

  public static void main(String[] args) {
    SerializeAndDeserializeNaryTree428 problem = new SerializeAndDeserializeNaryTree428();
    problem.test();
  }

  private void test() {
    Node root = new Node(1, new ArrayList<>());
    Node node2 = new Node(2, new ArrayList<>());
    Node node3 = new Node(3, new ArrayList<>());
    Node node4 = new Node(4, new ArrayList<>());
    Node node5 = new Node(5, new ArrayList<>());
    Node node6 = new Node(6, new ArrayList<>());

    root.children.addAll(Arrays.asList(node3, node2, node4));
    node3.children.addAll(Arrays.asList(node5, node6));

    String data = serialize(root);
    System.out.println(data);
    System.out.println(deserialize(data));
  }

  // Encodes a tree to a single string.
  public String serialize(Node root) {
    if (root == null) {
      return null;
    }

    int levels = 0;
    StringBuilder sb = new StringBuilder();

    Queue<Node> queue = new ArrayDeque<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int size = queue.size();

      if (levels > 0) {
        sb.append("/");
      }

      for (int i = 0; i < size; i++) {
        Node node = queue.poll();

        if (i > 0) {
          sb.append(";");
        }

        sb.append(node.val)
          .append(":")
          .append(node.children != null? node.children.size(): 0);

        queue.addAll(node.children);
      }

      levels++;
    }

    return sb.toString();
  }

  // Decodes your encoded data to tree.
  public Node deserialize(String data) {
    if (data == null) {
      return null;
    }

    String[] levels = data.split("/");

    Queue<Object[]> queue = new ArrayDeque<>();

    String rootExp = levels[0];

    Node root = new Node();
    root.val = Integer.parseInt(rootExp.substring(0, rootExp.indexOf(":")));
    root.children = new ArrayList<>();

    int size = Integer.parseInt(rootExp.substring(rootExp.indexOf(":") + 1));

    if (size > 0) {
      queue.add(new Object[]{root, size});
    }

    for (int i = 1; i < levels.length; i++) {
      String s = levels[i];

      String[] nodes = s.split(";");

      int len = queue.size();

      int k = 0;

      for (int t = 0; t < len; t++) {
        Object[] parent = queue.poll();
        Node parentNode = (Node) parent[0];
        int childrenSize = (int) parent[1];

        for (int j = 0; j < childrenSize; j++, k++) {
          String exp = nodes[k];

          int value = Integer.parseInt(exp.substring(0, exp.indexOf(":")));
          int children = Integer.parseInt(exp.substring(exp.indexOf(":") + 1));

          Node childNode = new Node();
          childNode.val = value;
          childNode.children = new ArrayList<>();

          parentNode.children.add(childNode);

          if (children > 0) {
            queue.add(new Object[] {childNode, children});
          }
        }
      }

    }

    return root;
  }

  private static class Node {

    int val;
    List<Node> children;

    public Node() {
    }

    public Node(int val, List<Node> children) {
      this.val = val;
      this.children = children;
    }

    @Override
    public String toString() {
      return "Node{" +
        "val=" + val +
        ", children=" + children +
        '}';
    }
  }

}
