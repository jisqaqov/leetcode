package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author Jandos Iskakov
 * problem: 380. Insert Delete GetRandom O(1)
 * algorithm: Hash Table
 * time complexity: O(1)
 * space complexity: O(N)
 * Runtime: 53 ms, faster than 81.50% of Java online submissions for Insert Delete GetRandom O(1).
 * Memory Usage: 44.9 MB, less than 84.00% of Java online submissions for Insert Delete GetRandom O(1).
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

    Map<Integer, Integer> valueMap;
    List<Integer> indexes;
    private Random random = new Random();

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
      valueMap = new HashMap<>();
      indexes = new ArrayList<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified
     * element.
     */
    public boolean insert(int val) {
      if (valueMap.containsKey(val)) {
        return false;
      }

      valueMap.put(val, indexes.size());
      indexes.add(val);

      return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
      if (!valueMap.containsKey(val)) {
        return false;
      }

      int valIndex = valueMap.get(val);
      if (valIndex < indexes.size() - 1) {
        int valueLast = indexes.get(indexes.size() - 1);

        indexes.set(valIndex, valueLast);
        valueMap.put(valueLast, valIndex);
      }

      valueMap.remove(val);
      indexes.remove(indexes.size() - 1);

      return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
      return indexes.get(random.nextInt(indexes.size()));
    }
  }


}
