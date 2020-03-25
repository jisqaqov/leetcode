package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import utils.TestUtils;

/**
 * @author Jandos Iskakov
 * problem: 480. Sliding Window Median
 * algorithm: Binary Search Tree
 * time complexity: O(nlog(k))
 * space complexity: O(k)
 * Runtime: 25 ms, faster than 90.27% of Java online submissions
 * Memory Usage: 43.7 MB, less than 20.00% of Java online submissions
 */
public class SlidingWindowMedian480 {

  public static void main(String[] args) {
    SlidingWindowMedian480 problem = new SlidingWindowMedian480();
    problem.test();
  }

  private void test() {
    // [1,-1,-1,3,5,6]
    TestUtils.printArray(medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
  }

  public double[] medianSlidingWindow(int[] nums, int k) {
    TreeSet<Integer> low = new TreeSet<>(
      (i, j) -> nums[i] != nums[j] ? Integer.compare(nums[i], nums[j]) : i - j);
    TreeSet<Integer> high = new TreeSet<>(
      (i, j) -> nums[i] != nums[j] ? Integer.compare(nums[j], nums[i]) : i - j);

    double[] output = new double[nums.length - k + 1];
    for (int i = 0; i < k; i++) {
      addNumber(low, high, i);
    }

    output[0] = getMedian(low, high, nums);

    for (int i = k; i < nums.length; i++) {
      int removeIndex = i - k;
      if (!high.remove(removeIndex)) {
        low.remove(removeIndex);
      }

      addNumber(low, high, i);

      output[i - k + 1] = getMedian(low, high, nums);
    }

    return output;
  }

  private void addNumber(TreeSet<Integer> low, TreeSet<Integer> high, int index) {
    low.add(index);
    high.add(low.pollFirst());

    if (high.size() > low.size()) {
      low.add(high.pollFirst());
    }
  }

  private double getMedian(TreeSet<Integer> low, TreeSet<Integer> high, int[] nums) {
    if (low.size() == high.size()) {
      return (nums[low.first()] * 1.0 + nums[high.first()] * 1.0) / 2;
    }

    return nums[low.first()];
  }

  private static class V2 {

    public double[] medianSlidingWindow(int[] nums, int k) {
      List<Integer> window = new ArrayList<>();

      for (int i = 0; i < k; i++) {
        window.add(nums[i]);
      }

      window.sort(Integer::compare);

      double[] output = new double[nums.length - k + 1];
      output[0] = getMedian(window);

      for (int i = k; i < nums.length; i++) {
        removeNumber(window, nums[i - k]);
        addNumber(window, nums[i]);

        output[i - k + 1] = getMedian(window);
      }

      return output;
    }

    private void removeNumber(List<Integer> window, int num) {
      for (int i = 0; i < window.size(); i++) {
        if (window.get(i) == num) {
          window.remove(i);
          break;
        }
      }
    }

    private void addNumber(List<Integer> window, int num) {
      int i = 0;
      while (i < window.size() && window.get(i) < num) {
        i++;
      }

      window.add(i, num);
    }

    private double getMedian(List<Integer> window) {
      int n = window.size();
      if (n % 2 == 0) {
        return (window.get(n / 2 - 1) * 1.0 + window.get(n / 2) * 1.0) / 2.0;
      }

      return window.get(n / 2);
    }
  }

}