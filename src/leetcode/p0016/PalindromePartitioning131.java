package leetcode.p0016;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Jandos Iskakov
 * problem: 131. Palindrome Partitioning
 * algorithm: Backtracking, DP
 * time complexity: O()
 * space complexity: O()
 * Runtime: 55 ms, faster than 5.39%
 * Memory Usage: 41.5 MB, less than 8.83%
 */
public class PalindromePartitioning131 {

    public static void main(String[] args) {
        PalindromePartitioning131 solution = new PalindromePartitioning131();
        solution.test();
    }

    public void test() {
        System.out.println(partition("aab"));
        System.out.println(partition("aaaaaaa"));
    }

    public List<List<String>> partition(String s) {
        List<List<String>> solution = new ArrayList<>();
        String[] list = new String[s.length()];

        partition(s, 0, 0, list, solution);

        return solution;
    }

    private void partition(String s, int n, int t, String[] list, List<List<String>> solution) {
        if (t == s.length()) {
            solution.add(Arrays.stream(list, 0, n)
                    .collect(Collectors.toList()));
        }

        Set<Integer>[] counter = new HashSet[s.length()];

        StringBuilder sb = new StringBuilder();

        for (int i = t; i < s.length(); i++) {
            sb.append(s.charAt(i));

            Set<Integer> indexes = new HashSet<>();
            indexes.add(1);
            counter[i] = indexes;

            if (i > t) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    indexes.add(2);
                }

                for (int len : counter[i - 1]) {
                    int beginIndex = i - len - 1;
                    if (beginIndex < 0) {
                        continue;
                    }

                    if (s.charAt(beginIndex) == s.charAt(i)) {
                        indexes.add(len + 2);
                    }
                }
            }

            if (indexes.contains(i - t + 1)) {
                list[n] = sb.toString();
                partition(s, n + 1, i + 1, list, solution);
                list[n] = null;
            }
        }
    }

}
