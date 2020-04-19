package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Jandos Iskakov
 * problem: 345. Reverse Vowels of a String
 * algorithm: String
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 3 ms, faster than 80.16% of Java online submissions
 * Memory Usage: 39.7 MB, less than 75.86% of Java online submissions
 */
public class ReverseVowelsOfString345 {

  private static final Set<Character> VOWELS
    = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u',
    'A', 'E', 'I', 'O', 'U'));

  public static void main(String[] args) {
    ReverseVowelsOfString345 problem = new ReverseVowelsOfString345();
    problem.test();
  }

  private void test() {
    System.out.println(reverseVowels("hello"));
    System.out.println(reverseVowels("leetcode"));
  }

  public String reverseVowels(String s) {
    int i = 0;
    int j = s.length() - 1;

    char[] chars = s.toCharArray();

    while (i < j) {
      while (i < j && !VOWELS.contains(chars[i])) {
        i++;
      }

      while (i < j && !VOWELS.contains(chars[j])) {
        j--;
      }

      swap(chars, i, j);

      i++;
      j--;
    }

    return String.valueOf(chars);
  }

  private void swap(char[] chars, int i, int j) {
    char temp = chars[i];
    chars[i] = chars[j];
    chars[j] = temp;
  }

}