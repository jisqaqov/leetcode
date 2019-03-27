package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Jandos Iskakov
 * problem: 394. Decode String
 * algorithm: DFS
 * time complexity: O(n)
 * space complexity: O(n)
 */
public class DecodeString394 {

    public static void main(String[] args) {
        DecodeString394 solution = new DecodeString394();
        solution.test();
    }

    public void test() {
        System.out.println(decodeString("3[a]2[bc]").equals("aaabcbc"));
        System.out.println(decodeString("3[a2[c]]").equals("accaccacc"));
        System.out.println(decodeString("2[abc]3[cd]ef").equals("abcabccdcdcdef"));
        System.out.println(decodeString("3[a]2[b4[F]c]").equals("aaabFFFFcbFFFFc"));
        System.out.println(decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef").equals("zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef"));
    }

    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();

        Deque<Object> stack = new ArrayDeque<>();

        int number = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '[') {
                if (sb.length() > 0) {
                    stack.push(sb);
                    sb = new StringBuilder();
                }

                stack.push(number);
                number = 0;
            } else if (ch == ']') {
                StringBuilder t = sb;

                if (sb.length() > 0) {
                    if (stack.peek() instanceof StringBuilder) {
                        t = ((StringBuilder) stack.pop()).append(sb);
                    }

                    sb = new StringBuilder();
                } else {
                    t = (StringBuilder) stack.pop();
                }

                int times = (int) stack.pop();

                StringBuilder repeated = new StringBuilder();
                while (times-- > 0) {
                    repeated.append(t);
                }

                if (stack.isEmpty()) {
                    result.append(repeated);
                } else {
                    if (stack.peek() instanceof StringBuilder) {
                        repeated = ((StringBuilder) stack.pop()).append(repeated);
                    }

                    stack.push(repeated);
                }
            } else if (Character.isDigit(ch)) {
                if (sb.length() > 0) {
                    if (stack.peek() instanceof StringBuilder) {
                        sb = ((StringBuilder)stack.pop()).append(sb);
                    }

                    stack.push(sb);

                    sb = new StringBuilder();
                }

                number = number * 10 + Character.digit(ch, 10);
            } else {
                if (stack.isEmpty()) {
                    result.append(ch);
                } else {
                    sb.append(ch);
                }
            }
        }

        if (sb.length() > 0) {
            result.append(sb);
        }

        return result.toString();
    }

}
