package leetcode.p0018;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Jandos Iskakov
 * problem: 737. Sentence Similarity II
 * algorithm: DFS, Graph
 * time complexity: O(nplog(p))
 * space complexity: O(p)
 * Runtime: 30 ms, faster than 65.64%
 * Memory Usage: 39.4 MB, less than 99.71%
 */
public class SentenceSimilarityII737 {

  public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
    if (words1.length != words2.length) {
      return false;
    }

    Dsu dsu = new Dsu();
    for (List<String> pair : pairs) {
      dsu.union(pair.get(0), pair.get(1));
    }

    for (int i = 0; i < words1.length; i++) {
      String parent1 = dsu.find(words1[i]);
      String parent2 = dsu.find(words2[i]);

      if (!parent1.equals(parent2)) {
        return false;
      }
    }

    return true;
  }

  private class Dsu {
    Map<String, String> map = new HashMap<>();

    private String find(String x) {
      if (!map.containsKey(x)) {
        map.put(x, x);
      } else if (!x.equals(map.get(x))) {
        map.put(x, find(map.get(x)));
      }

      return map.get(x);
    }

    private void union(String x, String y) {
      map.put(find(x), find(y));
    }

  }

  private static class DfsVersion {

    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
      if (words1.length != words2.length) {
        return false;
      }

      Map<String, List<String>> graph = buildGraph(pairs);

      for (int i = 0; i < words1.length; i++) {
        Set<String> visited = new HashSet<>();
        if (!dfs(words1[i], words2[i], graph, visited)) {
          return false;
        }
      }

      return true;
    }

    private boolean dfs(String source, String target, Map<String, List<String>> graph, Set<String> visited) {
      if (source.equals(target)) {
        return true;
      }

      visited.add(source);

      if (graph.containsKey(source)) {
        for (String adj : graph.get(source)) {
          if (!visited.contains(adj) && dfs(adj, target, graph, visited)) {
            return true;
          }
        }
      }

      return false;
    }

    private Map<String, List<String>> buildGraph(List<List<String>> pairs) {
      Map<String, List<String>> graph = new HashMap<>();

      for (List<String> pair : pairs) {
        graph.putIfAbsent(pair.get(0), new ArrayList<>());
        graph.get(pair.get(0)).add(pair.get(1));

        graph.putIfAbsent(pair.get(1), new ArrayList<>());
        graph.get(pair.get(1)).add(pair.get(0));
      }

      return graph;
    }

  }

}