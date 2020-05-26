package leetcode.p0017;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jandos Iskakov
 * problem: 722. Remove Comments
 * algorithm: String
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 0 ms, faster than 100.00%
 * Memory Usage: 37.6 MB, less than 7.69%
 */
public class RemoveComments722 {

  public List<String> removeComments(String[] source) {
    List<String> list = new ArrayList<>();

    StringBuilder sb = new StringBuilder();

    boolean inComment = false;

    for (String s : source) {
      for (int i = 0; i < s.length(); i++) {
        if (!inComment && i < s.length() - 1 && s.charAt(i) == '/' && s.charAt(i + 1) == '/') {
          break;
        } else if (!inComment && i < s.length() - 1 && s.charAt(i) == '/' && s.charAt(i + 1) == '*') {
          inComment = true;
          i++;
        } else if (inComment && i < s.length() - 1 && s.charAt(i) == '*' && s.charAt(i + 1) == '/') {
          inComment = false;
          i++;
        } else if (!inComment) {
          sb.append(s.charAt(i));
        }
      }

      if (sb.length() > 0 && !inComment) {
        list.add(sb.toString());
        sb.setLength(0);
      }
    }

    return list;
  }

}