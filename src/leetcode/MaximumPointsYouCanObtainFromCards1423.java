package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 1423. Maximum Points You Can Obtain from Cards
 * algorithm: Two Pointers, Sliding Window
 * time complexity: O(N)
 * space complexity: O(1)
 * Runtime: 1 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 49 MB, less than 100.00% of Java online submissions
 */
public class MaximumPointsYouCanObtainFromCards1423 {

  public int maxScore(int[] cardPoints, int k) {
    int n = cardPoints.length;

    int sumL = 0;
    for (int t = 0; t < k ; t++) {
      sumL += cardPoints[t];
    }

    int sumR = 0;
    for (int t = n - 1; t >= n - k; t--) {
      sumR += cardPoints[t];
    }

    int sum = 0;
    for (int i = 0, j = n - 1; k > 0; k--) {
      if (sumL >= sumR) {
        sum += cardPoints[i];

        sumL -= cardPoints[i];
        sumR -= cardPoints[j - k + 1];

        i++;
      } else {
        sum += cardPoints[j];

        sumR -= cardPoints[j];
        sumL -= cardPoints[i + k - 1];

        j--;
      }
    }

    return sum;
  }

}