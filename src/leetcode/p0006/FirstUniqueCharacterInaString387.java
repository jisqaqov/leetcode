package leetcode.p0006;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 387. First Unique Character in a String
 * algorithm: Hash Table, Array
 * time complexity: O(N)
 * space complexity: O(N)
 */
public class FirstUniqueCharacterInaString387 {

    public static void main(String[] args) {
        FirstUniqueCharacterInaString387 problem = new FirstUniqueCharacterInaString387();
        problem.test();
    }

    private void test() {
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
    }

    public int firstUniqChar(String s) {
        Map<Character, Integer> counter = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            counter.put(s.charAt(i), counter.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (counter.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

}
