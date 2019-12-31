package prep;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    System.out.println(singleNonDuplicate(new int[]{3}));//3
    System.out.println(singleNonDuplicate(new int[]{1, 2, 2}));//1
    System.out.println(singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));//2
    System.out.println(singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));//10
    System.out.println(singleNonDuplicate(new int[]{1, 1, 2}));//2
  }

  public int singleNonDuplicate(int[] nums) {
    int l = 0;
    int r = nums.length - 1;

    if (nums.length == 1) {
      return nums[0];
    }

    while (l + 2 < r) {
      int m = l + (r - l) / 2;

      if (nums[m] == nums[m - 1]) {
        m--;
      }

      int len = r - m + 1;
      if (len % 2 > 0) {
        l = m;
      } else {
        r = m - 1;
      }
    }

    if (nums[l] != nums[l + 1]) {
      return nums[l];
    }

    return nums[r];
  }


}