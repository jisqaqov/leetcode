package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import utils.TestUtils;

/**
 * @author Jandos Iskakov
 * problem: 399. Evaluate Division
 * algorithm: Graph
 * time complexity: O((V+E)*Q), v-vertex, e-edges, q-queries
 * space complexity: O(V+E)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 38.5 MB, less than 7.84% of Java online submissions
 */
public class EvaluateDivision399 {

  public static void main(String[] args) {
    EvaluateDivision399 problem = new EvaluateDivision399();
    problem.test();
  }

  private void test() {
    // [6.0, 0.5, -1.0, 1.0, -1.0 ]

    TestUtils.printArray(
      calcEquation(
        Arrays.asList(
          Arrays.asList("a", "b"), Arrays.asList("b", "c")),
        new double[]{2, 3},
        Arrays.asList(
          Arrays.asList("a", "c"),
          Arrays.asList("b", "a"),
          Arrays.asList("a", "e"),
          Arrays.asList("a", "a"),
          Arrays.asList("x", "x")
        )));

    // [360.0,0.00833,20.0,1.0,-1.0,-1.0]
    TestUtils.printArray(calcEquation(
      Arrays.asList(
        Arrays.asList("x1", "x2"),
        Arrays.asList("x2", "x3"),
        Arrays.asList("x3", "x4"),
        Arrays.asList("x4", "x5")),
      new double[]{3.0, 4.0, 5.0, 6.0},
      Arrays.asList(
        Arrays.asList("x1", "x5"),
        Arrays.asList("x5", "x2"),
        Arrays.asList("x2", "x4"),
        Arrays.asList("x2", "x2"),
        Arrays.asList("x2", "x9"),
        Arrays.asList("x9", "x9")
      )));
  }

  public double[] calcEquation(List<List<String>> equations, double[] values,
    List<List<String>> queries) {
    Map<String, Map<String, Double>> graph = new HashMap<>();

    for (int i = 0; i < equations.size(); i++) {
      List<String> eq = equations.get(i);

      graph.putIfAbsent(eq.get(0), new HashMap<>());
      graph.get(eq.get(0)).put(eq.get(1), values[i]);

      graph.putIfAbsent(eq.get(1), new HashMap<>());
      graph.get(eq.get(1)).put(eq.get(0), 1 / values[i]);
    }

    double[] output = new double[queries.size()];
    Set<String> used = new HashSet<>();

    for (int i = 0; i < queries.size(); i++) {
      List<String> query = queries.get(i);
      output[i] = eval(query.get(0), query.get(1), graph, used);
    }

    return output;
  }

  private double eval(String a, String b, Map<String, Map<String, Double>> graph,
    Set<String> used) {
    if (!graph.containsKey(a) || !graph.containsKey(b)) {
      return -1;
    }

    if (a.equals(b)) {
      return 1;
    }

    used.add(a);

    double eval = -1;

    for (Map.Entry<String, Double> adj : graph.get(a).entrySet()) {
      if (!used.contains(adj.getKey())) {
        double val = eval(adj.getKey(), b, graph, used);
        if (val != -1) {
          eval = adj.getValue() * val;
          break;
        }
      }
    }

    used.remove(a);

    return eval;
  }

  private static class BfsVersion {

    public double[] calcEquation(List<List<String>> equations, double[] values,
      List<List<String>> queries) {
      Map<String, Map<String, Double>> graph = new HashMap<>();

      for (int i = 0; i < equations.size(); i++) {
        List<String> eq = equations.get(i);

        graph.putIfAbsent(eq.get(0), new HashMap<>());
        graph.get(eq.get(0)).put(eq.get(1), values[i]);

        graph.putIfAbsent(eq.get(1), new HashMap<>());
        graph.get(eq.get(1)).put(eq.get(0), 1 / values[i]);
      }

      double[] output = new double[queries.size()];

      for (int i = 0; i < queries.size(); i++) {
        List<String> query = queries.get(i);
        output[i] = eval(query.get(0), query.get(1), graph);
      }

      return output;
    }

    private double eval(String a, String b, Map<String, Map<String, Double>> graph) {
      if (!graph.containsKey(a) || !graph.containsKey(b)) {
        return -1;
      }

      if (a.equals(b)) {
        return 1;
      }

      Set<String> used = new HashSet<>();
      used.add(a);

      Queue<String> queue = new LinkedList<>();
      queue.add(a);

      Queue<Double> values = new LinkedList<>();
      values.add(1.0);

      while (!queue.isEmpty()) {
        String node = queue.poll();
        double value = values.poll();

        if (node.equals(b)) {
          return value;
        }

        for (Map.Entry<String, Double> adj : graph.get(node).entrySet()) {
          if (!used.contains(adj.getKey())) {
            queue.add(adj.getKey());
            values.add(value * adj.getValue());
          }
        }
      }

      return -1;
    }

  }

}