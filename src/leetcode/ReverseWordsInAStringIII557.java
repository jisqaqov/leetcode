package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 557. Reverse Words in a String III
 * algorithm: Graph, Topological Sort
 * time complexity: O(N)
 * space complexity: O(1)
 * Runtime: 3 ms, faster than 95.96% of Java online submissions
 * Memory Usage: 38.1 MB, less than 100.00% of Java online submissions
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

    int start = 0;

    for (int i = 0; i <= t.length; i++) {
      if (i == t.length || t[i] == ' ') {
        int l = start;
        int r = i - 1;

        while (l < r) {
          char temp = t[r];
          t[r] = t[l];
          t[l] = temp;

          l++;
          r--;
        }

        start = i + 1;
      }
    }

    return new String(t);
  }


}