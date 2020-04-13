package leetcode;

import java.util.Arrays;

/**
 * @author Jandos Iskakov
 * problem: 881. Boats to Save People
 * algorithm: Greedy, Sort, Two Pointers
 * time complexity: O(nlog(n))
 * space complexity: O(1)
 * Runtime: 14 ms, faster than 86.65% of Java online submissions
 * Memory Usage: 48.9 MB, less than 100.00% of Java online submissions
 */
public class BoatsToSavePeople881 {

  public static void main(String[] args) {
    BoatsToSavePeople881 problem = new BoatsToSavePeople881();
    problem.test();
  }

  private void test() {
    System.out.println(numRescueBoats(new int[]{3, 2, 2, 1}, 3));//3
  }

  public int numRescueBoats(int[] people, int limit) {
    Arrays.sort(people);

    int count = 0;

    for (int i = 0, j = people.length - 1; i < j; ) {
      int k = people[i] + people[j];

      if (k <= limit) {
        count++;
        i++;
      }

      j--;
    }

    return count + (people.length - count * 2);
  }

}