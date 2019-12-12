package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: 17. Letter Combinations of a Phone Number
 * algorithm: Backtracking
 * time complexity: O(3^n * 4^m)
 * space complexity: O(3^n * 4^m)
 * where N is the number of digits in the input that maps to 3 letters (e.g. 2, 3, 4, 5, 6, 8)
 * and M is the number of digits in the input that maps to 4 letters (e.g. 7, 9),
 * and N+M is the total number digits in the input.
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Letter Combinations of a Phone Number.
 * Memory Usage: 35.9 MB, less than 98.63% of Java online submissions for Letter Combinations of a Phone Number.
 */
public class LetterCombinationsPhoneNumber17 {

  public static void main(String[] args) {
    LetterCombinationsPhoneNumber17 solution = new LetterCombinationsPhoneNumber17();
    solution.test();
  }

  public void test() {
    System.out.println(letterCombinations("23"));
    System.out.println(letterCombinations("332"));
  }

  public List<String> letterCombinations(String digits) {
    if (digits.isEmpty()) {
      return new ArrayList<>();
    }

    Map<Integer, String> map = new HashMap<>();
    map.put(2, "abc");
    map.put(3, "def");
    map.put(4, "ghi");
    map.put(5, "jkl");
    map.put(6, "mno");
    map.put(7, "pqrs");
    map.put(8, "tuv");
    map.put(9, "wxyz");

    List<String> list = new ArrayList<>();
    char[] letters = new char[digits.length()];

    helper(digits, 0, map, list, letters);

    return list;
  }

  private void helper(String digits, int index, Map<Integer, String> map, List<String> list,
    char[] letters) {
    if (index == digits.length()) {
      list.add(String.valueOf(letters));
      return;
    }

    int digit = Character.getNumericValue(digits.charAt(index));
    String t = map.get(digit);

    for (int i = 0; i < t.length(); i++) {
      letters[index] = t.charAt(i);
      helper(digits, index + 1, map, list, letters);
    }
  }

}
