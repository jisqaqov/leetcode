package leetcode.p0015;

/**
 * @author Jandos Iskakov
 * problem: 161. One Edit Distance
 * algorithm: String
 * time complexity: O(|S| + |T|)
 * space complexity: O(|S| + |T|)
 * Runtime: 1 ms, faster than 99.45% of Java online submissions for One Edit Distance.
 * Memory Usage: 37.7 MB, less than 91.18% of Java online submissions for One Edit Distance.
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
    System.out.println(isOneEditDistance("", ""));

    System.out.println("v2");
    V2 v2 = new V2();
    System.out.println(v2.isOneEditDistance("ab", "acb"));
    System.out.println(v2.isOneEditDistance("cab", "ad"));
    System.out.println(v2.isOneEditDistance("1203", "1213"));
    System.out.println(v2.isOneEditDistance("a", "ba"));
    System.out.println(v2.isOneEditDistance("", ""));
  }

  public boolean isOneEditDistance(String s, String t) {
    if (Math.abs(s.length() - t.length()) > 1) {
      return false;
    }

    int size = Math.min(s.length(), t.length());
    for (int i = 0; i < size; i++) {
      if (s.charAt(i) != t.charAt(i)) {
        return s.substring(i + 1).equals(t.substring(i + 1)) ||
          s.substring(i + 1).equals(t.substring(i)) ||
          s.substring(i).equals(t.substring(i + 1));
      }
    }

    return s.length() != t.length();
  }

  private static class V2 {
    public boolean isOneEditDistance(String s, String t) {
      int i = 0;

      int minLen = Math.min(s.length(), t.length());
      while (i < minLen && s.charAt(i) == t.charAt(i)) {
        i++;
      }

      if (i == s.length() && i == t.length()) {
        return false;
      }

      return isEquals(s, i + 1, t, i + 1) ||
        isEquals(s, i + 1, t, i) ||
        isEquals(s, i, t, i + 1);
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

}
