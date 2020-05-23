package leetcode.p0001;

import java.util.ArrayList;
import java.util.Collections;
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

    Map<String, Integer> freq = new HashMap<>();

    for (String user : map.keySet()) {
      map.get(user).sort(Comparator.comparingInt(v -> v.timestamp));

      Set<String> sequences = getSubSequence(map.get(user));
      for (String sequence : sequences) {
        freq.put(sequence, freq.getOrDefault(sequence, 0) + 1);
      }
    }

    int maxCount = -1;
    for (Integer num : freq.values()) {
      maxCount = Math.max(num, maxCount);
    }

    String maxSequence = null;

    for (String sequence : freq.keySet()) {
      if (freq.get(sequence) < maxCount) {
        continue;
      }

      if (maxSequence == null) {
        maxSequence = sequence;
      } else if (sequence.compareTo(maxSequence) < 0) {
        maxSequence = sequence;
      }
    }

    List<String> output = new ArrayList<>();
    Collections.addAll(output, maxSequence.split(":"));

    return output;
  }

  private Set<String> getSubSequence(List<Visit> visits) {
    Set<String> sequences = new HashSet<>();

    for (int i = 0; i < visits.size(); i++) {
      for (int j = i + 1; j < visits.size(); j++) {
        for (int k = j + 1; k < visits.size(); k++) {
          sequences.add(visits.get(i).webstite + ":" + visits.get(j).webstite +
            ":" + visits.get(k).webstite);
        }
      }
    }

    return sequences;
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
