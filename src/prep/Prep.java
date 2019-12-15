package prep;

import utils.TestUtils;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    TestUtils.printArray(searchRange(new int[0], 8));
    TestUtils.printArray(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 5));
  }

  public int[] searchRange(int[] nums, int target) {
    int[] idx = {-1, -1};

    if (nums.length == 0) {
      return idx;
    }

    int l = 0;
    int r = nums.length - 1;

    while (l < r) {
      int mid = l + (r - l) / 2;
      if (nums[mid] < target ) {
        l = mid + 1;
      } else {
        r = mid;
      }
    }

    idx[0] = l;

    r = nums.length - 1;

    while (l < r) {
      int mid = l + (r - l) / 2;
      if (nums[mid + 1] <= target) {
        l = mid + 1;
      } else {
        r = mid;
      }
    }

    idx[1] = r;

    if (nums[idx[0]] != target) {
      idx[0] = -1;
      idx[1] = -1;
    }

    return idx;
  }

  private static class V3 {
    public int[] searchRange(int[] nums, int target) {
      return new int[]{firstIndex(nums, target), lastIndex(nums, target)};
    }

    private int firstIndex(int[] nums, int target) {
      int l = 0;
      int r = nums.length - 1;

      int index = -1;

      while (l <= r) {
        int mid = l + (r - l) / 2;

        if (nums[mid] >= target) {
          if (nums[mid] == target) {
            index = mid;
          }

          r = mid - 1;
        } else {
          l = mid + 1;
        }
      }

      return index;
    }

    private int lastIndex(int[] nums, int target) {
      int l = 0;
      int r = nums.length - 1;

      int index = -1;

      while (l <= r) {
        int mid = l + (r - l) / 2;

        if (nums[mid] <= target) {
          if (nums[mid] == target) {
            index = mid;
          }

          l = mid + 1;
        } else {
          r = mid - 1;
        }
      }

      return index;
    }
  }

  private static class V2 {

    public int[] searchRange(int[] nums, int target) {
      if (nums.length == 0) {
        return new int[]{-1, -1};
      }

      return new int[]{firstIndex(nums, target), lastIndex(nums, target)};
    }

    private int firstIndex(int[] nums, int target) {
      int l = 0;
      int r = nums.length - 1;

      while (l + 1 < r) {
        int mid = l + (r - l) / 2;

        if (nums[mid] >= target) {
          r = mid;
        } else {
          l = mid;
        }
      }

      if (nums[l] != target && nums[r] != target) {
        return -1;
      }

      return nums[l] == target ? l : r;
    }

    private int lastIndex(int[] nums, int target) {
      int l = 0;
      int r = nums.length - 1;

      while (l + 1 < r) {
        int mid = l + (r - l) / 2;

        if (nums[mid] <= target) {
          l = mid;
        } else {
          r = mid;
        }
      }

      if (nums[l] != target && nums[r] != target) {
        return -1;
      }

      return nums[r] == target ? r : l;
    }
  }

}