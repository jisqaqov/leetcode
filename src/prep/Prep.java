package prep;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    //System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    System.out.println(findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 3));
  }

  public int findKthLargest(int[] nums, int k) {
    int l = 0;
    int r = nums.length - 1;

    int pos = k - 1;

    while (true) {
      int index = partition(nums, l, r);

      if (index == pos) {
        return nums[index];
      } else if (pos < index) {
        r = index - 1;
      } else {
        l = index + 1;
      }
    }
  }

  private int partition(int[] nums, int l, int r) {
    int pivot = nums[l];
    int i = l + 1;
    int j = r;

    while (true) {
      while (i < r && nums[i] > pivot) {
        i++;
      }

      while (j > l && nums[j] <= pivot) {
        j--;
      }

      if (i >= j) {
        break;
      }

      swap(nums, i, j);

      i++;
      j--;
    }

    swap(nums, l, j);

    return j;
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

}