package leetcode.p0006;

import java.util.*;

/**
 * @author Jandos Iskakov
 * problem: 1002. Find Common Characters
 * algorithm: String, Hash Table
 * time complexity: O(E(|S|))
 * space complexity: O(Max(|S|))
 */
public class FindCommonCharacters1002 {

    public static void main(String[] args) {
        FindCommonCharacters1002 solution = new FindCommonCharacters1002();
        solution.test();
    }

    public void test() {
        String[] tc1a = new String[]{"bella","label","roller"};
        System.out.println(commonChars(tc1a));

        String[] tc2a = new String[]{"cool","lock","cook"};
        System.out.println(commonChars(tc2a));
    }

    public List<String> commonChars(String[] a) {
        Map<Character, Integer> chars = count(a[0]);

        for (int i = 1; i < a.length; i++) {
            Map<Character, Integer> counter = count(a[i]);

            for (char ch : chars.keySet()) {
                chars.put(ch, Math.min(chars.get(ch), counter.getOrDefault(ch, 0)));
            }
        }

        List<String> solution = new ArrayList<>();
        for (char ch : chars.keySet()) {
            for (int i = 0; i < chars.get(ch); i++) {
                solution.add(String.valueOf(ch));
            }
        }

        return solution;
    }

    private Map<Character, Integer> count(String s) {
        Map<Character, Integer> counter = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            counter.put(s.charAt(i), counter.getOrDefault(s.charAt(i), 0) + 1);
        }

        return counter;
    }

}
