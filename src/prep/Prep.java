package prep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    System.out.println(permuteUnique(new int[]{1, 1, 2}));
  }

  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> output = new ArrayList<>();
    List<Integer> values = new ArrayList<>();

    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    helper(map, output, values, 0, nums.length);

    return output;
  }

  public void helper(Map<Integer, Integer> map, List<List<Integer>> output,
    List<Integer> values, int index, int n) {
    if (index == n) {
      output.add(new ArrayList<>(values));
      return;
    }

    for (int number : map.keySet()) {
      if (map.get(number) == 0) {
        continue;
      }

      values.add(number);
      map.put(number, map.get(number) - 1);

      helper(map, output, values, index + 1, n);

      map.put(number, map.get(number) + 1);
      values.remove(values.size() - 1);
    }

  }

}