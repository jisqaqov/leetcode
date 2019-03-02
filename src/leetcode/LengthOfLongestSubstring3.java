package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 3. Longest Substring Without Repeating Characters
 * algorithm: Sliding Window Technique
 */
public class LengthOfLongestSubstring3 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty())
            return 0;

        Map<Character, Integer> map = new HashMap<>();
        int start = 0, max = -1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (map.containsKey(ch)) {
                start = map.get(ch) + 1;

                map.keySet().removeIf(c -> map.get(c) < map.get(ch));

                map.put(ch, i);
            } else {
                map.put(ch, i);
            }

            int len = i - start + 1;
            max = Math.max(max, len);
        }

        return max;
    }
    
}
