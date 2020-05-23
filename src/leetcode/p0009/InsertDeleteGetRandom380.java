package leetcode.p0009;

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
 * Runtime: 11 ms, faster than 90.25% of Java online submissions
 * Memory Usage: 46 MB, less than 68.00% of Java online submissions
 */
public class InsertDeleteGetRandom380 {

  public static void main(String[] args) {
    InsertDeleteGetRandom380 problem = new InsertDeleteGetRandom380();
    problem.test();
  }

  private void test() {
    RandomizedSet randomizedSet = new RandomizedSet();
    System.out.println(randomizedSet.insert(1));
    System.out.println(randomizedSet.remove(2));
    System.out.println(randomizedSet.insert(2));
    System.out.println(randomizedSet.getRandom());
    System.out.println(randomizedSet.remove(1));
    System.out.println(randomizedSet.insert(2));
    System.out.println(randomizedSet.getRandom());
  }

  class RandomizedSet {
    private List<Integer> list;
    private Map<Integer, Integer> map;
    private Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
      random = new Random();
      map = new HashMap<>();
      list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
      if (map.containsKey(val)) {
        return false;
      }

      list.add(val);
      map.put(val, list.size() - 1);

      return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
      if (!map.containsKey(val)) {
        return false;
      }

      int index = map.get(val);

      int lastVal = list.get(list.size() - 1);

      map.put(lastVal, index);
      list.set(index, lastVal);

      map.remove(val);
      list.remove(list.size() - 1);

      return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
      return list.get(random.nextInt(list.size()));
    }
  }


}
