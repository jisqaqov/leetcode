package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 278. First Bad Version
 * algorithm: Binary Search
 * time complexity: O(logn)
 * space complexity: O(1)
 * Runtime: 10 ms, faster than 99.77% of Java online submissions for First Bad Version.
 * Memory Usage: 33.1 MB, less than 100.00% of Java online submissions for First Bad Version.
 */
public class FirstBadVersion278 {

  public int firstBadVersion(int n) {
    int l = 1, r = n;
    int version = -1;

    while (l <= r) {
      int mid = l + (r - l) / 2;

      boolean isBad = isBadVersion(mid);
      if (isBad) {
        r = mid - 1;
        version = mid;
      } else {
        l = mid + 1;
      }
    }

    return version;
  }

  private boolean isBadVersion(int n) {
    return true;
  }

}
