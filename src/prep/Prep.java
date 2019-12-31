package prep;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    System.out.println(singleNonDuplicate(new int[]{3}));//3
    System.out.println(singleNonDuplicate(new int[]{1, 2, 2}));//1
    System.out.println(singleNonDuplicate(new int[]{1, 1, 2, 3, 3}));//2
    System.out.println(singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));//2
    System.out.println(singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));//10
    System.out.println(singleNonDuplicate(new int[]{1, 1, 2}));//2
  }

  public int singleNonDuplicate(int[] nums) {
    int l = 0;
    int r = nums.length - 1;

    while (l < r) {
      int m = l + (r - l) / 2;

      if (m % 2 == 1) {
        m--;
      }

      if (nums[m] == nums[m + 1]) {
        l = m + 2;
      } else {
        r = m;
      }
    }

    return nums[l];
  }


}