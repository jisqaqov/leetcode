package leetcode;

import java.util.*;

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

            Iterator<Character> it = chars.keySet().iterator();
            while (it.hasNext()) {
                char ch = it.next();

                if (!counter.containsKey(ch)) {
                    it.remove();
                } else {
                    chars.put(ch, Math.min(chars.get(ch), counter.get(ch)));
                }
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
            char ch = s.charAt(i);
            counter.put(ch, counter.getOrDefault(ch, 0) + 1);
        }

        return counter;
    }

}
