package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 567. Permutation in String
 * algorithm: Sliding Window Technique
 */
public class PermutationInString {

    public static void main(String[] args) {
        LeetcodeProblem solution = new LeetcodeProblem();
        solution.test();
    }

    public void test() {
        System.out.println(checkInclusion("ab", "eidbaooo"));
        System.out.println(checkInclusion("ab", "eidboaoo"));
        System.out.println(checkInclusion("adc", "dcda"));
    }

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> index = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        Map<Character, Integer> counter = new HashMap<>(map);

        int start = 0;
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);

            if (!map.containsKey(ch)) {
                if (!index.isEmpty()) {
                    counter = new HashMap<>(map);
                    index.clear();
                }

                start = i + 1;
            } else {
                if (!index.containsKey(ch))
                    index.put(ch, i);

                if (counter.get(ch) == 0) {
                    int end = index.get(ch);
                    for (int t = start; t < end; t++) {
                        counter.put(s2.charAt(t), counter.get(s2.charAt(t)) + 1);
                        index.remove(s2.charAt(t));
                    }

                    start = end + 1;

                    index.remove(ch);

                    for (int t = start; t <= i; t++) {
                        if (!index.containsKey(s2.charAt(t))) {
                            index.put(s2.charAt(t), t);
                        }
                    }
                } else {
                    counter.put(ch, counter.get(ch) - 1);
                }

                boolean valid = true;
                for (char c : counter.keySet()) {
                    if (counter.get(c) != 0) {
                        valid = false;
                        break;
                    }
                }

                if (valid)
                    return true;
            }
        }

        return false;
    }


}