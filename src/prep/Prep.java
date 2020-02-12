package prep;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    System.out.println(minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
    System.out.println(minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));//30
    System.out.println(minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));//23
  }

  public int minEatingSpeed(int[] piles, int h) {
    int low = 1;

    int high = piles[0];
    for (int pile : piles) {
      if (pile > high) {
        high = pile;
      }
    }

    int k = -1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      int ph = calc(piles, mid);
      if (ph > h) {
        low = mid + 1;
      } else if (ph < h) {
        high = mid - 1;
        k = mid;
      } else {
        return mid;
      }
    }

    return k;
  }

  private int calc(int[] piles, int k) {
    int h = 0;

    for (int pile : piles) {
      h += Math.ceil(pile * 1.0 / k);
    }

    return h;
  }


}