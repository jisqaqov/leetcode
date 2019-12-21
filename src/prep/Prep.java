package prep;

import java.util.HashMap;
import java.util.Map;
import utils.TestUtils;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    TestUtils.printArray(findPairWithGivenSum(new int[]{1, 10, 25, 35, 60}, 90));//[2, 3]
    TestUtils.printArray(findPairWithGivenSum(new int[]{20, 50, 40, 25, 30, 10}, 90));//[1, 5]
  }

  public int[] findPairWithGivenSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();

    int[] index = {-1, -1};

    target = target - 30;

    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(target - nums[i])) {
        index[0] = map.get(target - nums[i]);
        index[1] = i;
      }

      map.put(nums[i], i);
    }

    return index;
  }

}