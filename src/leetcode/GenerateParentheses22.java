package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jandos Iskakov
 * problem: 22. Generate Parentheses
 * algorithm: Backtracking
 * time complexity: O()
 * space complexity: O(n)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Generate Parentheses
 * Memory Usage: 37.8 MB, less than 79.07% of Java online submissions for Generate Parentheses
 */
public class GenerateParentheses22 {

    public static void main(String[] args) {
        GenerateParentheses22 solution = new GenerateParentheses22();
        solution.test();
    }

    public void test() {
        System.out.println(generateParenthesis(3));
        System.out.println(generateParenthesis(2));
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        char[] t = new char[2 * n];

        generateParenthesis(n, t, 0, 0, 0, list);

        return list;
    }

    private void generateParenthesis(int n, char[] t, int i, int s, int e, List<String> list) {
        if (s == e && s == n) {
            list.add(new String(t));
            return;
        }

        if (s < n) {
            t[i] = '(';
            generateParenthesis(n, t, i + 1, s + 1, e, list);
        }

        if (e < s) {
            t[i] = ')';
            generateParenthesis(n, t, i + 1, s, e + 1, list);
        }
    }

}
