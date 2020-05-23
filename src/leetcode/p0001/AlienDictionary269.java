package leetcode.p0001;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Jandos Iskakov
 * problem: Alien Dictionary 269
 * algorithm: Graph, Topological Sort
 * time complexity: O(V + E + |words|)
 * space complexity: O(V + E + |words|)
 * Runtime: 3 ms, faster than 88.19% of Java online submissions for Alien Dictionary.
 * Memory Usage: 35.9 MB, less than 97.30% of Java online submissions for Alien Dictionary.
 */
public class AlienDictionary269 {

  public static void main(String[] args) {
    AlienDictionary269 problem = new AlienDictionary269();
    problem.test();
  }

  private void test() {
    String[] tc1dict = {"wrt", "wrf", "er", "ett", "rftt"};
    System.out.println(alienOrder(tc1dict));

    String[] tc2dict = {"z", "x", "z"};
    System.out.println(alienOrder(tc2dict));

    String[] tc3dict = {"z", "z"};
    System.out.println(alienOrder(tc3dict));
  }

  public String alienOrder(String[] words) {
    Map<Character, Set<Character>> adjList = new HashMap<>();

    for (int i = 0; i < words.length; i++) {
      for (int j = 0; j < words[i].length(); j++) {
        adjList.putIfAbsent(words[i].charAt(j), new HashSet<>());
      }
    }

    for (int i = 0; i < words.length - 1; i++) {
      int len = Math.min(words[i].length(), words[i + 1].length());

      for (int t = 0; t < len; t++) {
        char ch1 = words[i].charAt(t);
        char ch2 = words[i + 1].charAt(t);

        if (ch1 != ch2) {
          adjList.get(ch1).add(ch2);

          break;
        }
      }
    }

    if (isCyclic(adjList)) {
      return "";
    }

    Set<Character> visited = new HashSet<>();
    Deque<Character> deque = new ArrayDeque<>();

    for (Character ch : adjList.keySet()) {
      if (visited.contains(ch)) {
        continue;
      }

      tsort(ch, visited, adjList, deque);
    }

    StringBuilder sb = new StringBuilder();

    for (Character ch : deque) {
      sb.append(ch);
    }

    return sb.toString();
  }

  private void tsort(Character ch, Set<Character> visited,
    Map<Character, Set<Character>> adjList,
    Deque<Character> deque) {
    visited.add(ch);

    for (Character adj : adjList.get(ch)) {
      if (visited.contains(adj)) {
        continue;
      }

      tsort(adj, visited, adjList, deque);
    }

    deque.addFirst(ch);
  }

  private boolean isCyclic(Map<Character, Set<Character>> adjList) {
    Set<Character> visited = new HashSet<>();
    Set<Character> explored = new HashSet<>();

    for (Character node : adjList.keySet()) {
      if (!visited.contains(node) && isCyclic(node, adjList, visited, explored)) {
        return true;
      }
    }

    return false;
  }

  private boolean isCyclic(char s, Map<Character, Set<Character>> adjList,
    Set<Character> visited, Set<Character> explored) {
    visited.add(s);

    for (Character adj : adjList.get(s)) {
      if (!explored.contains(adj) && visited.contains(adj)) {
        return true;
      }

      if (!visited.contains(adj) && isCyclic(adj, adjList, visited, explored)) {
        return true;
      }
    }

    explored.add(s);

    return false;
  }

}
