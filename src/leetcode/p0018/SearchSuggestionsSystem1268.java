package leetcode.p0018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jandos Iskakov
 * problem: 1268. Search Suggestions System
 * algorithm: Binary Search
 * time complexity: O(log(|p|) * (|s| + |p|))
 * space complexity: O(3 * |s|)
 * Runtime: 11 ms, faster than 91.73% of Java online submissions
 * Memory Usage: 50 MB, less than 100.00% of Java online submissions
 */
public class SearchSuggestionsSystem1268 {

  public static void main(String[] args) {
    SearchSuggestionsSystem1268 problem = new SearchSuggestionsSystem1268();
    problem.test();
  }

  private void test() {
    System.out.println(
      suggestedProducts(new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"},
        "mouse"));
    System.out.println(suggestedProducts(new String[]{"havana"}, "havana"));
    System.out.println(
      suggestedProducts(new String[]{"bags", "baggage", "banner", "box", "cloths"}, "bags"));
    System.out.println(
      suggestedProducts(new String[]{"havana"}, "tatiana"));
  }

  public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    Arrays.sort(products);

    List<List<String>> output = new ArrayList<>();

    for (int n = 1; n <= searchWord.length(); n++) {
      String t = searchWord.substring(0, n);

      int l = 0;
      int r = products.length - 1;

      while (l < r) {
        int mid = l + (r - l) / 2;

        int len = Math.min(n, products[mid].length());
        String sub = products[mid].substring(0, len);

        if (sub.compareTo(t) < 0) {
          l = mid + 1;
        } else {
          r = mid;
        }
      }

      List<String> list = new ArrayList<>();
      for (int k = l; k < l + 3 && k < products.length; k++) {
        int len = Math.min(n, products[k].length());
        String sub = products[k].substring(0, len);

        if (!sub.equals(t)) {
          list.add(products[k]);
        }
      }

      output.add(list);
    }

    return output;
  }

}