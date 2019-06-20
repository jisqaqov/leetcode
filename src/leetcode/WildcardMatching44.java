package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 44. Wildcard Matching
 * algorithm: DP, Greedy, Backtracking
 * time complexity:
 * space complexity:
 * notes: TLE, need to optimize
 */
public class WildcardMatching44 {

    public static void main(String[] args) {
        WildcardMatching44 solution = new WildcardMatching44();
        solution.test();
    }

    public void test() {
        System.out.println(isMatch("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb",
                "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"));
        System.out.println(isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaabb", "a*******b"));
        System.out.println(isMatch("aabcdedefghijkl", "aabc*"));
        System.out.println(isMatch("ho", "ho**"));
        System.out.println(isMatch("a", "a*"));
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "*"));
        System.out.println(isMatch("cb", "?a"));
        System.out.println(isMatch("cb", "?b"));
        System.out.println(isMatch("adceb", "*a*b"));
        System.out.println(isMatch("acdcb", "a*c?b"));
    }

    public boolean isMatch(String s, String p) {
        Map<String, Boolean> memo = new HashMap<>();

        return isMatch(s, p, 0, 0, memo);
    }

    public boolean isMatch(String s, String p, int i, int j, Map<String, Boolean> memo) {
        String index = i + ":" + j;

        if (p.equals("*")) {
            memo.put(index, true);
            return true;
        }

        if (memo.containsKey(index)) {
            return memo.get(index);
        }

        while (i < s.length() && j < p.length()) {
            if (p.charAt(j) == '*') {
                while (j < p.length() && p.charAt(j) == '*') {
                    j++;
                }

                j--;

                if (j == p.length() - 1) {
                    memo.put(i + ":" + j, true);
                    return true;
                }

                for (int k = i; k < s.length(); k++) {
                    if (isMatch(s, p, k, j + 1, memo)) {
                        return true;
                    }
                }
            } else if (p.charAt(j) != '?' && s.charAt(i) != p.charAt(j)) {
                memo.put(i + ":" + j, false);
                return false;
            }

            ++i;
            ++j;
        }

        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }

        boolean isMatch = i == s.length() && j == p.length();
        memo.put(i + ":" + j, isMatch);

        return isMatch;
    }

}
