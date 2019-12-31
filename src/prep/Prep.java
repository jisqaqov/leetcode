package prep;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    int[] tc1a = {3, 9, 3, 4, 7, 2, 12, 6};
    System.out.println(maxArea(tc1a));
  }

  public int maxArea(int[] height) {
    int max = 0;

    int i = 0, j = height.length - 1;

    while (i < j) {
      int a = Math.min(height[i], height[j]) * (j - i);

      max = Math.max(a, max);

      if (height[i] < height[j]) {
        i++;
      } else if (height[i] > height[j]) {
        j--;
      } else {
        i++;
        j--;
      }
    }

    return max;
  }

}