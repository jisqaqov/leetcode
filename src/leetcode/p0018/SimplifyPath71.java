package leetcode.p0018;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Jandos Iskakov
 * problem: 71. Simplify Path
 * algorithm: String, Stack
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 4 ms, faster than 90.78% of Java online submissions for Simplify Path.
 * Memory Usage: 36.4 MB, less than 100.00% of Java online submissions for Simplify Path.
 */
public class SimplifyPath71 {

  public static void main(String[] args) {
    SimplifyPath71 problem = new SimplifyPath71();
    problem.test();
  }

  private void test() {
    System.out.println(simplifyPath("/home/"));
    System.out.println(simplifyPath("/../"));
    System.out.println(simplifyPath("/home//foo/"));
    System.out.println(simplifyPath("/a/./b/../../c/"));
    System.out.println(simplifyPath("/a/../../b/../c//.//"));
    System.out.println(simplifyPath("/a//b////c/d//././/.."));
  }

  public String simplifyPath(String path) {
    String[] dirs = path.split("/");

    Deque<String> stack = new ArrayDeque<>();

    for (String part : dirs) {
      if (part.isEmpty() || part.equals(".")) {
        continue;
      }

      if (part.equals("..")) {
        if (!stack.isEmpty()) {
          stack.pop();
        }
      } else {
        stack.push(part);
      }
    }

    String shortPath = "";

    while (!stack.isEmpty()) {
      String dir = stack.pop();
      if (shortPath.isEmpty()) {
        shortPath = dir;
      } else {
        shortPath = dir + "/" + shortPath;
      }
    }

    return "/" + shortPath;
  }

}
