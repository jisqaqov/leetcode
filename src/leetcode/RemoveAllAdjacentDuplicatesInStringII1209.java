package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Jandos Iskakov
 * problem: 1209. Remove All Adjacent Duplicates in String II
 * algorithm: Stack
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 18 ms, faster than 27.36%
 * Memory Usage: 40.3 MB, less than 100.00%
 */
public class RemoveAllAdjacentDuplicatesInStringII1209 {

  public String removeDuplicates(String s, int k) {
    Deque<Node> stack = new ArrayDeque<>();

    for (int i = 0; i < s.length(); i++) {
      if (stack.isEmpty() || stack.peek().ch != s.charAt(i)) {
        stack.push(new Node(s.charAt(i), 1));
      } else if (stack.peek().ch == s.charAt(i)) {
        stack.peek().count++;
      }

      if (stack.peek().count == k) {
        stack.poll();
      }
    }

    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      Node node = stack.poll();
      for (int i = 0; i < node.count; i++) {
        sb.append(node.ch);
      }
    }

    return sb.reverse().toString();
  }

  private class Node {
    char ch;
    int count;

    Node(char ch, int count) {
      this.ch = ch;
      this.count = count;
    }
  }

  private class V2 {

    public String removeDuplicates(String s, int k) {
      Deque<Integer> counts = new ArrayDeque<>();
      Deque<Character> letters = new ArrayDeque<>();

      for (int i = 0; i < s.length(); i++) {
        if (letters.isEmpty() || letters.peek() != s.charAt(i)) {
          counts.push(1);
        } else if (letters.peek() == s.charAt(i)) {
          counts.push(counts.poll() + 1);
        }

        letters.push(s.charAt(i));

        if (counts.peek() == k) {
          counts.poll();
          while (!letters.isEmpty() && letters.peek() == s.charAt(i)) {
            letters.poll();
          }
        }
      }

      StringBuilder sb = new StringBuilder();
      while (!letters.isEmpty()) {
        sb.append(letters.poll());
      }

      return sb.reverse().toString();
    }

  }


}