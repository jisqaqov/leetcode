package leetcode.p0011;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author Jandos Iskakov
 * problem: 854. K-Similar Strings
 * algorithm: BFS
 * time complexity:
 * space complexity:
 * Runtime: 46 ms, faster than 53.60% of Java online submissions.
 * Memory Usage: 50 MB, less than 33.33% of Java online submissions
 */
public class KSimilarStrings854 {

  public static void main(String[] args) {
    KSimilarStrings854 problem = new KSimilarStrings854();
    problem.test();
  }

  private void test() {
    System.out.println(kSimilarity("ab", "ba"));//1
    System.out.println(kSimilarity("abc", "bca"));//2
    System.out.println(kSimilarity("abac", "baca"));//2
    System.out.println(kSimilarity("aabc", "abca"));//2
    System.out.println(kSimilarity("abccaacceecdeea", "bcaacceeccdeaae"));
  }

  public int kSimilarity(String a, String b) {
    Set<String> set = new HashSet<>();

    int n = a.length();

    Queue<String> queue = new LinkedList<>();
    queue.add(a);

    set.add(a);

    for (int k = 0; !queue.isEmpty(); k++) {
      for (int sz = queue.size(); sz > 0; sz--) {
        String s = queue.poll();

        char[] chs = s.toCharArray();

        int idx = 0;
        while (idx < n && chs[idx] == b.charAt(idx)) {
          idx++;
        }

        if (idx == n) {
          return k;
        }

        for (int i = idx + 1; i < n; i++) {
          if (chs[i] != b.charAt(idx)) {
            continue;
          }

          swap(chs, idx, i);

          String temp = new String(chs);
          if (!set.contains(temp)) {
            queue.add(temp);
            set.add(temp);
          }

          swap(chs, idx, i);
        }
      }
    }

    return 0;
  }

  private void swap(char[] chs, int i, int j) {
    char temp = chs[i];
    chs[i] = chs[j];
    chs[j] = temp;
  }


}