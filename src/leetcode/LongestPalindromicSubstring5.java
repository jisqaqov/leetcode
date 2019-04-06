package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Jandos Iskakov
 * problem: 5. Longest Palindromic Substring
 * algorithm: Dynamic Programming
 * Runtime: 21 ms, faster than 57.15% of Java online submissions
 * Memory Usage: 49.3 MB, less than 5.47% of Java online submissions
 */
public class LongestPalindromicSubstring5 {

    public static void main(String[] args) {
        LongestPalindromicSubstring5 solution = new LongestPalindromicSubstring5();
        solution.test();
    }

    public void test() {
        System.out.println(longestPalindrome("abcd"));
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("aaabbbbsas"));
        System.out.println(longestPalindrome("bananas"));
        System.out.println(longestPalindrome("aaabaaaa"));
        System.out.println(longestPalindrome("ababababababa"));
        System.out.println(longestPalindrome("tattarrattat"));
        System.out.println(longestPalindrome("aaaaaaaaaaaaaaaaaa"));
    }

    @SuppressWarnings("unchecked")
    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return s;
        }

        List<int[]>[] memo = new ArrayList[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            List<int[]> ranges = new ArrayList<>();

            if (i == 0 || ch != s.charAt(i - 1)) {
                int[] range0 = {i, i, 1};
                ranges.add(range0);
            }

            List<int[]> lastRanges = i > 0? memo[i - 1]: Collections.emptyList();

            for (int[] range : lastRanges) {
                if (range[2] == 1 && ch == s.charAt(range[0])) {
                    int[] newRange = {range[0], i, 1};
                    ranges.add(newRange);
                } else if (range[2] == 0 && range[0] > 0 && s.charAt(range[0] - 1) == ch) {
                    int[] newRange = {range[0] - 1, i, 0};
                    ranges.add(newRange);
                } else if (range[2] == 1 && range[0] > 0 && s.charAt(range[0] - 1) == ch) {
                    int[] newRange = {range[0] - 1, i, 0};
                    ranges.add(newRange);
                }
            }

            memo[i] = ranges;
        }

        int k = 1;
        int[] max = {0, 0};

        for (List<int[]> palindromes : memo) {
            for (int[] range : palindromes) {
                if (range[1] - range[0] + 1 > k) {
                    k = range[1] - range[0] + 1;
                    max[0] = range[0];
                    max[1] = range[1];
                }
            }
        }

        return s.substring(max[0], max[1] + 1);
    }

}
