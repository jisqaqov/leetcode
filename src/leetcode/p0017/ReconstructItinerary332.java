package leetcode.p0017;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Jandos Iskakov
 * problem: 332. Reconstruct Itinerary
 * algorithm: DFS, Graph
 * time complexity:
 * space complexity:
 * Runtime: 12 ms, faster than 8.62% of Java online submissions
 * Memory Usage: 43.9 MB, less than 64.18% of Java online submissions
 */
public class ReconstructItinerary332 {

  public static void main(String[] args) {
    ReconstructItinerary332 problem = new ReconstructItinerary332();
    problem.test();
  }

  private void test() {
    List<List<String>> tc1a = Arrays.asList(
      Arrays.asList("MUC", "LHR"),
      Arrays.asList("JFK", "MUC"),
      Arrays.asList("SFO", "SJC"),
      Arrays.asList("LHR", "SFO")
    );

    System.out.println(findItinerary(tc1a));//["JFK", "MUC", "LHR", "SFO", "SJC"]

    List<List<String>> tc2a = Arrays.asList(
      Arrays.asList("JFK", "SFO"),
      Arrays.asList("JFK", "ATL"),
      Arrays.asList("SFO", "ATL"),
      Arrays.asList("ATL", "JFK"),
      Arrays.asList("ATL", "SFO")
    );

    System.out.println(findItinerary(tc2a));//["JFK","ATL","JFK","SFO","ATL","SFO"]

    List<List<String>> tc3a = Arrays.asList(
      Arrays.asList("JFK", "KUL"),
      Arrays.asList("JFK", "NRT"),
      Arrays.asList("NRT", "JFK")
    );

    System.out.println(findItinerary(tc3a));//["JFK","NRT","JFK","KUL"]
  }

  public List<String> findItinerary(List<List<String>> tickets) {
    Map<String, List<String>> adjList = new HashMap<>();

    for (List<String> ticket : tickets) {
      String src = ticket.get(0);
      String dst = ticket.get(1);

      adjList.putIfAbsent(src, new ArrayList<>());
      adjList.get(src).add(dst);
    }

    Map<String, Set<Integer>> index = new HashMap<>();
    for (String node : adjList.keySet()) {
      index.put(node, new HashSet<>());

      Collections.sort(adjList.get(node));
    }

    LinkedList<String> output = new LinkedList<>();

    dfs("JFK", adjList, index, output, tickets.size());

    output.add(0, "JFK");

    return output;
  }

  private boolean dfs(String node, Map<String, List<String>> adjList,
    Map<String, Set<Integer>> index,
    LinkedList<String> output, int n) {

    if (!adjList.containsKey(node)) {
      return output.size() == n;
    }

    List<String> list = adjList.get(node);

    for (int i = 0; i < list.size(); i++) {
      String adj = adjList.get(node).get(i);

      if (index.get(node).contains(i)) {
        continue;
      }

      output.add(adj);
      index.get(node).add(i);

      boolean valid = dfs(adj, adjList, index, output, n);
      if (valid) {
        return true;
      }

      output.removeLast();
      index.get(node).remove(i);
    }

    return output.size() == n;
  }

}
