package leetcode.p0007;

public class GuessNumberHigherOrLower374 {

  public class Solution extends GuessGame {

    public int guessNumber(int n) {
      int l = 1;
      int r = n;

      while (l <= r) {
        int mid = l + (r - l) / 2;
        int g = guess(mid);

        if (g == 0) {
          return mid;
        } else if (g == -1) {
          l = mid + 1;
        } else {
          r = mid - 1;
        }
      }

      return -1;
    }
  }

  /* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */
  private class GuessGame {

    int guess(int num) {
      return 1;
    }

  }

}
