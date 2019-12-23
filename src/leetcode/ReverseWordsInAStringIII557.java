package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 557. Reverse Words in a String III
 * algorithm: Graph, Topological Sort
 * time complexity: O(N)
 * space complexity: O(1)
 * Runtime: 3 ms, faster than 95.96% of Java online submissions
 * Memory Usage: 37.9 MB, less than 100.00% of Java online submissions
 */
public class ReverseWordsInAStringIII557 {

  public static void main(String[] args) {
    ReverseWordsInAStringIII557 problem = new ReverseWordsInAStringIII557();
    problem.test();
  }

  private void test() {
    System.out
      .println(reverseWords("Let's take LeetCode contest").equals("s'teL ekat edoCteeL tsetnoc"));
  }

  public String reverseWords(String s) {
    char[] t = s.toCharArray();

    for (int i = 0; i < t.length; i++) {
      int start = i;
      while (i < t.length && t[i] != ' ') {
        i++;
      }

      reverse(t, start, i - 1);
    }

    return new String(t);
  }

  private void reverse(char[] s, int l, int r) {
    while (l < r) {
      swap(s, l, r);

      l++;
      r--;
    }
  }

  private void swap(char[] s, int i, int j) {
    char temp = s[j];
    s[j] = s[i];
    s[i] = temp;
  }

}