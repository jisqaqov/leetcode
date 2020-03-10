package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Jandos Iskakov
 * problem: 1152. Analyze User Website Visit Pattern
 * algorithm: Hash Table, Sort
 * time complexity:
 * space complexity:
 * Runtime: 17 ms, faster than 92.86% of Java online submissions
 * Memory Usage: 41.6 MB, less than 50.00% of Java online submissions
 */
public class AnalyzeUserWebsiteVisitPattern1152 {

  public static void main(String[] args) {
    AnalyzeUserWebsiteVisitPattern1152 problem = new AnalyzeUserWebsiteVisitPattern1152();
    problem.test();
  }

  private void test() {
    System.out.println(mostVisitedPattern(
      new String[]{"joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary", "mary"},
      new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
      new String[]{"home", "about", "career", "home", "cart", "maps", "home", "home", "about",
        "career"}));
  }

  public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
    Map<String, List<Visit>> map = new HashMap<>();
    for (int i = 0; i < username.length; i++) {
      map.putIfAbsent(username[i], new ArrayList<>());
      map.get(username[i]).add(new Visit(website[i], timestamp[i]));
    }

    Map<List<String>, Integer> freq = new HashMap<>();

    for (Map.Entry<String, List<Visit>> entry : map.entrySet()) {
      entry.getValue().sort(Comparator.comparingInt(v -> v.timestamp));

      List<List<String>> seqList = get3Seq(entry.getValue());

      for (List<String> seq : seqList) {
        freq.put(seq, freq.getOrDefault(seq, 0) + 1);
      }
    }

    int max = -1;
    for (Integer num : freq.values()) {
      max = Math.max(num, max);
    }

    List<String> output = null;

    for (Map.Entry<List<String>, Integer> entry : freq.entrySet()) {
      if (entry.getValue() < max) {
        continue;
      }

      if (output == null) {
        output = entry.getKey();
      } else if (compare(output, entry.getKey()) > 0) {
        output = entry.getKey();
      }
    }

    return output;
  }

  private int compare(List<String> seq1, List<String> seq2) {
    for (int i = 0; i < seq1.size(); i++) {
      if (seq1.get(i).compareTo(seq2.get(i)) != 0) {
        return seq1.get(i).compareTo(seq2.get(i));
      }
    }

    return 0;
  }

  private List<List<String>> get3Seq(List<Visit> visits) {
    Set<List<String>> seq = new HashSet<>();

    for (int i = 0; i < visits.size(); i++) {
      for (int j = i + 1; j < visits.size(); j++) {
        for (int k = j + 1; k < visits.size(); k++) {
          seq.add(Arrays.asList(visits.get(i).webstite,
            visits.get(j).webstite, visits.get(k).webstite));
        }
      }
    }

    return new ArrayList<>(seq);
  }

  private static class Visit {

    private String webstite;
    private int timestamp;

    Visit(String webstite, int timestamp) {
      this.webstite = webstite;
      this.timestamp = timestamp;
    }
  }

}
