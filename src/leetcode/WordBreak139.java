package leetcode;

import java.util.*;

/**
 * @author Jandos Iskakov
 * problem: 139. Word Break
 * algorithm: DP
 */
public class WordBreak139 {

    public static void main(String[] args) {
        WordBreak139 solution = new WordBreak139();
        solution.test();
    }

    public void test() {
        String[] tc1a = {"leet", "code"};
        System.out.println(wordBreak("leetcode", new ArrayList<>(Arrays.asList(tc1a))));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);

        List<Integer> hash = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            boolean hasSegment = false;
            for (int t = hash.size() - 1; t >= 0; t--) {
                String word = s.substring(hash.get(t) + 1, i + 1);
                if (wordSet.contains(word)) {
                    hash.add(i);
                    hasSegment = true;

                    break;
                }
            }

            if (!hasSegment) {
                String word = s.substring(0, i + 1);
                if (wordSet.contains(word)) {
                    hash.add(i);
                }
            }
        }

        return hash.size() > 0 && hash.get(hash.size() - 1) == s.length() - 1;
    }

}
