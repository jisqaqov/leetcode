package leetcode.p0001;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Jandos Iskakov
 * problem: 616. Add Bold Tag in String
 * algorithm: String, Array
 * time complexity:
 * space complexity:
 * Runtime: 17 ms, faster than 32.95% of Java online submissions
 * Memory Usage: 38.8 MB, less than 61.54% of Java online submissions
 */
public class AddBoldTagInString616 {

  public static void main(String[] args) {
    AddBoldTagInString616 problem = new AddBoldTagInString616();
    problem.test();
  }

  private void test() {
    //<b>abc</b>xyz<b>123</b>
    System.out.println(addBoldTag("abcxyz123", new String[]{"abc", "123"}));
    //"<b>aaabbc</b>c"
    System.out.println(addBoldTag("aaabbcc", new String[]{"aaa", "aab", "bc"}));
    // "<b>a</b>b<b>c</b>d<b>e</b>f"
    System.out.println(addBoldTag("abcdef", new String[] {"a","c","e","g"}));
  }

  public String addBoldTag(String s, String[] dict) {
    List<int[]> indexes = new ArrayList<>();
    for (String t : dict) {
      indexes.addAll(findIndexes(s, t));
    }

    List<int[]> merged = merge(indexes);

    StringBuilder output = new StringBuilder();

    int idx = 0;

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);

      String prefix = "";
      String suffix = "";

      if (idx < merged.size()) {
        if (i == merged.get(idx)[0]) {
          prefix = "<b>";
        }

        if (i == merged.get(idx)[1]) {
          suffix = "</b>";
          idx++;
        }
      }

      if (!prefix.isEmpty()) {
        output.append(prefix);
      }

      output.append(ch);

      if (!suffix.isEmpty()) {
        output.append(suffix);
      }
    }

    return output.toString();
  }

  private List<int[]> merge(List<int[]> indexes) {
    if (indexes.isEmpty()) {
      return new ArrayList<>();
    }

    indexes.sort(Comparator.comparingInt(t -> t[0]));

    List<int[]> output = new ArrayList<>();
    output.add(indexes.get(0));

    for (int i = 1; i < indexes.size(); i++) {
      int[] index = indexes.get(i);
      int[] index2 = output.get(output.size() - 1);

      if (index[0] - index2[1] <= 1) {
        index2[1] = Math.max(index[1], index2[1]);
      } else {
        output.add(new int[]{index[0], index[1]});
      }
    }

    return output;
  }

  private List<int[]> findIndexes(String s, String t) {
    List<Integer> list = new ArrayList<>();

    int index = 0;

    while (index != -1) {
      index = s.indexOf(t, index);
      if (index != -1) {
        list.add(index);
        index++;
      }
    }

    List<int[]> output = new ArrayList<>();
    for (int idx : list) {
      output.add(new int[]{idx, idx + t.length() - 1});
    }

    return output;
  }

}
