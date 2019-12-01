package prep;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    System.out.println(findPeakElement(new int[]{1, 2, 3, 1}));
    System.out.println(findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
  }

  public int findPeakElement(int[] nums) {
    int l = 0;
    int r = nums.length - 1;

    while (l <= r) {
      int mid = l + (r - l) / 2;

      if (mid > 0 && nums[mid - 1] > nums[mid]) {
        r = mid - 1;
      } else if (mid < nums.length - 1 && nums[mid + 1] > nums[mid]) {
        l = mid + 1;
      } else {
        return mid;
      }
    }

    return -1;
  }

}
