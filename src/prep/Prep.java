package prep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    System.out.println(letterCombinations("23"));
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