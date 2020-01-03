package prep;

import java.util.Arrays;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    int[] tc1a = {2, 0, 2, 1, 1, 0};
    sortColors(tc1a);
    System.out.println(Arrays.toString(tc1a));

//    int[] tc2a = {2, 0, 1};
//    sortColors(tc2a);
//    System.out.println(Arrays.toString(tc2a));
//
//    int[] tc3a = {1, 2, 0};
//    sortColors(tc3a);
//    System.out.println(Arrays.toString(tc3a));
//
//    int[] tc4a = {0, 0, 0, 0, 2, 1, 0, 0, 0, 2, 2, 2, 2};
//    sortColors(tc4a);
//    System.out.println(Arrays.toString(tc4a));
  }

  public void sortColors(int[] nums) {
    int p1 = 0;
    int p2 = nums.length - 1;

    int i = 0;

    while (i <= p2) {
      if (nums[i] == 0) {
        swap(nums, p1, i);
        i++;
        p1++;
      } else if (nums[i] == 2) {
        swap(nums, p2, i);
        p2--;
      } else {
        i++;
      }
    }
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }


}