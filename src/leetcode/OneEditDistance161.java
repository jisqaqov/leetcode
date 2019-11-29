package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 161. One Edit Distance
 * algorithm: String
 * time complexity: O(|S| + |T|)
 * space complexity: O(1)
 * Runtime: 1 ms, faster than 99.45% of Java online submissions for One Edit Distance.
 * Memory Usage: 38 MB, less than 85.29% of Java online submissions for One Edit Distance.
 */
public class OneEditDistance161 {

  public static void main(String[] args) {
    OneEditDistance161 problem = new OneEditDistance161();
    problem.test();
  }

  private void test() {
    System.out.println(isOneEditDistance("ab", "acb"));
    System.out.println(isOneEditDistance("cab", "ad"));
    System.out.println(isOneEditDistance("1203", "1213"));
    System.out.println(isOneEditDistance("a", "ba"));
  }

  public boolean isOneEditDistance(String s, String t) {
    int i = 0;
    int j = 0;

    while (i < s.length() && j < t.length()) {
      if (s.charAt(i) != t.charAt(j)) {
        break;
      }

      i++;
      j++;
    }

    if (i == s.length() && j == t.length()) {
      return false;
    }

    return isEquals(s, i + 1, t, j + 1) ||
      isEquals(s, i + 1, t, j) ||
      isEquals(s, i, t, j + 1);
  }

  private boolean isEquals(String s, int i, String t, int j) {
    int len1 = s.length() - i;
    int len2 = t.length() - j;

    if (len1 != len2) {
      return false;
    }

    while (i < s.length() && j < t.length()) {
      if (s.charAt(i) != t.charAt(j)) {
        return false;
      }

      i++;
      j++;
    }

    return true;
  }

}
