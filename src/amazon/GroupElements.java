package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/discuss/interview-experience/568587/Amazon-or-SDE2-or-Bay-Area-or-March-2020-Reject
 *
 * Given an Input with a unique number & list of elements corresponding to each number.
 * Find & output groups of numbers such that each number in a given group has one element in common. -
 * Input: [ {n: 8, e:['z, 'x', 'y']}, {n: 5, e:['y', 'u']}, {n: 3, e:['m']},
 * {n: 6, e:['u', 'd']}, {n: 9, e:['m', 'n']}, {n: 7, e:['a']} ]
 * Output: [ [8, 5, 6], [3, 9], [7] ]
 */
public class GroupElements {

  public static void main(String[] args) {
    GroupElements problem = new GroupElements();
    problem.test();
  }

  private void test() {
    Item item8 = new Item(8, Arrays.asList('z', 'x', 'y'));
    Item item5 = new Item(5, Arrays.asList('y', 'u'));
    Item item3 = new Item(3, Arrays.asList('m'));
    Item item6 = new Item(6, Arrays.asList('u', 'd'));
    Item item9 = new Item(9, Arrays.asList('m', 'n'));
    Item item7 = new Item(7, Arrays.asList('a'));

    System.out.println(groupElements(Arrays.asList(item8, item5, item3, item6, item9, item7)));
  }

  private List<List<Integer>> groupElements(List<Item> items) {
    Map<Integer, Integer> numberToId = new HashMap<>();
    Map<Character, List<Integer>> elementToId = new HashMap<>();

    for (int idx = 0; idx < items.size(); idx++) {
      numberToId.put(items.get(idx).number, idx);

      for (char element : items.get(idx).elements) {
        elementToId.putIfAbsent(element, new ArrayList<>());
        elementToId.get(element).add(idx);
      }
    }

    DisjointSet ds = new DisjointSet(items.size());

    for (char element : elementToId.keySet()) {
      List<Integer> ids = elementToId.get(element);
      for (int i = 0; i < ids.size() - 1; i++) {
        ds.union(ids.get(i), ids.get(i + 1));
      }
    }

    Map<Integer, List<Integer>> idToNumber = new HashMap<>();
    for (Item item : items) {
      int id = ds.root(numberToId.get(item.number));

      idToNumber.putIfAbsent(id, new ArrayList<>());
      idToNumber.get(id).add(item.number);
    }

    return new ArrayList<>(idToNumber.values());
  }

  private class DisjointSet {

    int[] ds;

    DisjointSet(int n) {
      ds = new int[n];
      for (int i = 0; i < n; i++) {
        ds[i] = i;
      }
    }

    void union(int x, int y) {
      int rootX = root(x);
      int rootY = root(y);

      ds[rootX] = rootY;
    }

    int root(int x) {
      while (x != ds[x]) {
        ds[x] = ds[ds[x]];
        x = ds[x];
      }

      return ds[x];
    }
  }

  private class Item {

    int number;
    List<Character> elements;

    Item(int number, List<Character> elements) {
      this.number = number;
      this.elements = elements;
    }
  }

}