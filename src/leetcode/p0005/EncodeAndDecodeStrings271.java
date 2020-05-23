package leetcode.p0005;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jandos Iskakov
 * problem: 271. Encode and Decode Strings
 * algorithm: String
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 4 ms, faster than 91.29%
 * Memory Usage: 40.1 MB, less than 88.24%
 */
public class EncodeAndDecodeStrings271 {

  // Encodes a list of strings to a single string.
  public String encode(List<String> strs) {
    StringBuilder sb = new StringBuilder();
    for (String str : strs) {
      sb.append(str.length()).append(":").append(str);
    }

    return sb.toString();
  }

  // Decodes a single string to a list of strings.
  public List<String> decode(String s) {
    List<String> strs = new ArrayList<>();

    for (int i = 0; i < s.length(); ) {
      int endIndex = s.indexOf(':', i);
      int len = Integer.parseInt(s.substring(i, endIndex));

      int strIndex = endIndex + 1;
      strs.add(s.substring(strIndex, strIndex + len));

      i = strIndex + len;
    }

    return strs;
  }

}