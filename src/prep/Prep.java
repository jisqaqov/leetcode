package prep;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    //TODO:
    System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
  }

  public int findKthLargest(int[] nums, int k) {
    int l = 0;
    int r = nums.length - 1;

    int pos = nums.length - k;

    while (true) {
      int pivotIndex = partition(l, r, nums);
      if (pivotIndex == pos) {
        return nums[pivotIndex];
      }

      if (pivotIndex < pos) {
        l = pivotIndex + 1;
      } else {
        r = pivotIndex - 1;
      }
    }
  }

  private int partition(int l, int r, int[] nums) {
    int p = l;

    for (int i = l; i < r; i++) {
      if (nums[i] < nums[r]) {
        swap(i, p, nums);
        p++;
      }
    }

    swap(p, r, nums);

    return p;
  }

  private void swap(int i, int j, int[] nums) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }


}