package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 167. Two Sum II - Input array is sorted
 * algorithm: Two Pointers
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 1 ms, faster than 55.02% of Java online submissions
 * Memory Usage: 42.6 MB, less than 5.22% of Java online submissions
 */
public class TwoSumIIInputArrayIsSorted167 {

  public int[] twoSum(int[] numbers, int target) {
    int i = 0;
    int j = numbers.length - 1;

    int[] output = {-1, -1};

    while (i < j) {
      if (numbers[i] + numbers[j] == target) {
        output[0] = i + 1;
        output[1] = j + 1;
        break;
      } else if (numbers[i] + numbers[j] > target) {
        j--;
      } else {
        i++;
      }
    }

    return output;
  }

}
