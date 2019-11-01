package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author Jandos Iskakov
 * problem: 380. Insert Delete GetRandom O(1)
 * algorithm: Hash Table
 * time complexity: O(1)
 * space complexity: O(N)
 * Runtime: 56 ms, faster than 29.27% of Java online submissions for Insert Delete GetRandom O(1).
 * Memory Usage: 44.2 MB, less than 94.00% of Java online submissions for Insert Delete GetRandom O(1).
 */
public class InsertDeleteGetRandom380 {

  public static void main(String[] args) {
    InsertDeleteGetRandom380 problem = new InsertDeleteGetRandom380();
    problem.test();
  }

  private void test() {
    RandomizedSet randomSet = new RandomizedSet();
    System.out.println(randomSet.insert(1));
    System.out.println(randomSet.insert(2));
    System.out.println(randomSet.insert(3));
    System.out.println(randomSet.insert(4));
    System.out.println(randomSet.insert(5));
    System.out.println(randomSet.insert(6));
    System.out.println(randomSet.getRandom());
    System.out.println(randomSet.remove(2));
    System.out.println(randomSet.getRandom());
    System.out.println(randomSet.getRandom());
    System.out.println(randomSet.remove(1));
    System.out.println(randomSet.remove(3));
    System.out.println(randomSet.remove(5));
    System.out.println(randomSet.getRandom());
  }

  class RandomizedSet {
    private Random random = new Random();
    private static final double THRESHOLD = 0.7;

    int index = -1;
    Map<Integer, Integer> valueMap;
    Map<Integer, Integer> indexMap;

    /** Initialize your data structure here. */
    public RandomizedSet() {
      valueMap = new HashMap<>();
      indexMap = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
      if (valueMap.containsKey(val)) {
        return false;
      }

      index++;

      valueMap.put(val, index);
      indexMap.put(index, val);

      return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
      if (!valueMap.containsKey(val)) {
        return false;
      }

      int valIndex = valueMap.get(val);

      valueMap.remove(val);
      indexMap.remove(valIndex);

      reIndex();

      return true;
    }

    private void reIndex() {
      if (valueMap.size() == 0) {
        indexMap.clear();
        index = -1;

        return;
      }

      int mod = (index - valueMap.size() - 1) / valueMap.size();
      if (mod < THRESHOLD) {
        return;
      }

      indexMap.clear();

      index = -1;
      for (int val : valueMap.keySet()) {
        index++;
        valueMap.put(val, index);
        indexMap.put(index, val);
      }
    }

    /** Get a random element from the set. */
    public int getRandom() {
      if (valueMap.size() == 0) {
        return 0;
      }

      int randomIndex = -1;
      do {
        randomIndex = random.nextInt(index + 1);
      } while (!indexMap.containsKey(randomIndex));

      return indexMap.get(randomIndex);
    }
  }


}
