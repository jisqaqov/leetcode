package prep;

import java.util.ArrayDeque;
import java.util.Deque;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
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

    StringBuilder shortPath = new StringBuilder("/");
    int size = stack.size();

    for (int i = 0; i < size; i++) {
      String dir = stack.pollLast();
      shortPath.append(dir);

      if (i < size - 1) {
        shortPath.append("/");
      }
    }

    return shortPath.toString();
  }


}
