package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 567. Permutation in String
 * algorithm: Sliding Window Technique
 * time complexity: O(|s1|)
 * space complexity: O(|s2|)
 */
public class PermutationInString567 {

    public static void main(String[] args) {
        PermutationInString567 solution = new PermutationInString567();
        solution.test();
    }

    public void test() {
        System.out.println(checkInclusion("a", "ab"));
//        System.out.println(checkInclusion("ab", "eidbaooo"));
//        System.out.println(checkInclusion("ab", "eidboaoo"));
//        System.out.println(checkInclusion("adc", "dcda"));
    }

    public boolean checkInclusion(String s1, String s2) {
        return slidingWindow(s1, s2);
    }

    private boolean slidingWindow(String s1, String s2) {
        Map<Character, Integer> counter = new HashMap<>();
        Map<Character, Integer> invalids = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            counter.put(ch, counter.getOrDefault(ch, 0) + 1);
        }

        int valid = 0;

        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);

            if (i < s1.length()) {
                if (counter.containsKey(ch)) {
                    if (counter.get(ch) == 0)
                        valid--;

                    counter.put(ch, counter.get(ch) - 1);

                    if (counter.get(ch) == 0)
                        valid++;
                } else {
                    invalids.put(ch, invalids.getOrDefault(ch, 0) + 1);
                }
            } else {
                if (valid == counter.size() && invalids.isEmpty())
                    return true;

                char prefix = s2.charAt(i - s1.length());

                if (prefix == ch)
                    continue;

                if (counter.containsKey(prefix)) {
                    if (counter.get(prefix) == 0)
                        valid--;

                    counter.put(prefix, counter.get(prefix) + 1);

                    if (counter.get(prefix) == 0)
                        valid++;
                } else {
                    invalids.put(prefix, invalids.get(prefix) - 1);
                    if (invalids.get(prefix) == 0)
                        invalids.remove(prefix);
                }

                if (counter.containsKey(ch)) {
                    if (counter.get(ch) == 0)
                        valid--;

                    counter.put(ch, counter.get(ch) - 1);

                    if (counter.get(ch) == 0)
                        valid++;
                } else {
                    invalids.put(ch, invalids.getOrDefault(ch, 0) + 1);
                }
            }
        }

        return valid == counter.size() && invalids.isEmpty();
    }


}