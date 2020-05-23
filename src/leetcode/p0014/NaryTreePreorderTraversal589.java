package leetcode.p0014;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * @author Jandos Iskakov
 * problem: 589. N-ary Tree Preorder Traversal
 * algorithm: Tree, DFS, Stack
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 2 ms, faster than 60.38% of Java online submissions
 * Memory Usage: 39.9 MB, less than 100.00% of Java online submissions
 */
public class NaryTreePreorderTraversal589 {

  public List<Integer> preorder(Node root) {
    if (root == null) {
      return Collections.emptyList();
    }

    Deque<Node> stack = new ArrayDeque<>();

    List<Integer> output = new ArrayList<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      Node node = stack.pop();

      output.add(node.val);

      for (int i = node.children.size() - 1; i >= 0; i--) {
        stack.push(node.children.get(i));
      }
    }

    return output;
  }

  private static class V2 {

    public List<Integer> preorder(Node root) {
      List<Integer> output = new ArrayList<>();

      helper(root, output);

      return output;
    }

    private void helper(Node root, List<Integer> output) {
      if (root == null) {
        return;
      }

      output.add(root.val);

      for (Node child : root.children) {
        helper(child, output);
      }
    }


  }

  /**
   * Definition for a Node.
   */
  class Node {

    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  }

}