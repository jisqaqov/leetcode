package prep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
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
    private List<Integer> valueList;
    private Map<Integer, Integer> valueMap;
    private Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
      random = new Random();
      valueMap = new HashMap<>();
      valueList = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
      if (valueMap.containsKey(val)) {
        return false;
      }

      valueList.add(val);
      valueMap.put(val, valueList.size() - 1);

      return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
      if (!valueMap.containsKey(val)) {
        return false;
      }

      int index = valueMap.get(val);

      if (index < valueList.size() - 1) {
        int lastVal = valueList.get(valueList.size() - 1);

        valueMap.put(lastVal, index);
        valueList.set(index, lastVal);
      }

      valueMap.remove(val);
      valueList.remove(valueList.size() - 1);

      return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
      return valueList.get(random.nextInt(valueList.size()));
    }
  }




}