package prep;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
  }

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> output = new ArrayList<>();

    Arrays.sort(candidates);

    Map<Integer, Integer> map = new LinkedHashMap<>();
    for (int candidate : candidates) {
      map.put(candidate, map.getOrDefault(candidate, 0) + 1);
    }

    int i = 0;
    int[] values = new int[map.keySet().size()];

    for (int number : map.keySet()) {
      values[i++] = number;
    }

    helper(map, values, 0, output, target, new ArrayDeque<>());

    return output;
  }

  private void helper(Map<Integer, Integer> map, int[] candidates, int index,
    List<List<Integer>> output, int target, Deque<Integer> values) {
    if (target == 0) {
      output.add(new ArrayList<>(values));
      return;
    }

    for (int i = index; i < candidates.length && candidates[i] <= target; i++) {
      if (map.get(candidates[i]) == 0) {
        continue;
      }

      values.addLast(candidates[i]);
      map.put(candidates[i], map.get(candidates[i]) - 1);

      helper(map, candidates, i, output, target - candidates[i], values);

      values.removeLast();
      map.put(candidates[i], map.get(candidates[i]) + 1);
    }
  }

}