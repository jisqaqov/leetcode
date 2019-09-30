package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class TrappingRainWater42 {

  public static void main(String[] args) {
    TrappingRainWater42 problem = new TrappingRainWater42();
    problem.test();
  }

  private void test() {
    int[] tc1a = {0,1,0,2,1,0,1,3,2,1,2,1};//6
    int[] tc2a = {2,0,2};//2
    int[] tc3a = {5,4,1,2};//
    int[] tc4a = {5,5,1,7,1,1,5,2,7,6};//23
    int[] tc5a = {9,6,8,8,5,6,3};//3
    int[] tc6a = {8,2,8,9,0,1,7,7,9};//27

    verify(tc1a, 6);
    verify(tc2a, 2);
    verify(tc3a, 1);
    verify(tc4a, 23);
    verify(tc5a, 3);
    verify(tc6a, 27);
  }

  private void verify(int[] a, int solution) {
    int ans = trap(a);
    System.out.println(ans + " " + (solution == ans));
  }

  public int trap(int[] height) {
    Deque<Integer> stack = new ArrayDeque<>();

    int water = 0;
    int cells = 0;

    for (int i = 1; i < height.length; i++) {
      if (height[i] < height[i - 1]) {
        stack.push(i - 1);
      } else if (height[i] > height[i - 1] && !stack.isEmpty()) {
        cells = 0;

        Iterator<Integer> it = stack.iterator();

        int start = -1;

        while (it.hasNext()) {
          int h = it.next();
          if (height[h] <= height[i]) {
            start = h;
          } else {
            break;
          }
        }

        if (start == -1) {
          start = stack.peek();
        }

        int h = Math.min(height[start], height[i]);
        for (int t = i - 1; t >= start + 1; t--) {
          cells += h - height[t];
        }

        if (height[i] >= height[start]) {
          while (!stack.isEmpty()) {
            if (stack.peek() == start) {
              stack.pop();
              break;
            }

            stack.pop();
          }
        }

        if (stack.isEmpty()) {
          water += cells;
          cells = 0;
        }
      }
    }

    water += cells;

    return water;
  }

}
