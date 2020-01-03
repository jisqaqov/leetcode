package prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
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
//
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

    List<String> output = new ArrayList<>();

    dfs("JFK", adjList, index, output, tickets.size());

    output.add(0, "JFK");

    return output;
  }

  private boolean dfs(String node, Map<String, List<String>> adjList,
    Map<String, Set<Integer>> index,
    List<String> output, int n) {

    if (adjList.containsKey(node)) {
      List<String> list = adjList.get(node);

      for (int i = 0; i < list.size(); i++) {
        String adj = adjList.get(node).get(i);

        if (index.get(node).contains(i)) {
          continue;
        }

        output.add(adj);
        index.get(node).add(i);

        boolean valid = dfs(adj, adjList, index, output, n);
        if (!valid) {
          output.remove(output.size() - 1);
          index.get(node).remove(i);
        } else {
          return true;
        }
      }
    }

    return output.size() == n;
  }

}