package prep;

import java.util.ArrayList;
import java.util.List;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    System.out.println(subsets(new int[] {1, 2, 3}));
  }

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> output = new ArrayList<>();
    subsets(nums, 0, new ArrayList<>(), output);
    return output;
  }

  private void subsets(int[] nums, int index, List<Integer> list, List<List<Integer>> output) {
    output.add(new ArrayList<>(list));

    for (int i = index; i < nums.length; i++) {
      list.add(nums[i]);

      subsets(nums, i + 1, list, output);

      list.remove(list.size() - 1);
    }
  }


}