package leetcode.p0018;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author Jandos Iskakov
 * problem: 1146. Snapshot Array
 * algorithm: Array
 * time complexity:
 *    SnapshotArray(n) - O(N)
 *    set(index, val) - log(snaps)
 *    get(index, val) - log(snaps)
 *    snap() - O(1)
 * space complexity: O(N * snaps)
 * Runtime: 54 ms, faster than 81.77% of Java online submissions
 * Memory Usage: 95.3 MB, less than 100.00% of Java online submissions
 */
public class SnapshotArray1146 {

  public static void main(String[] args) {
    SnapshotArray1146 problem = new SnapshotArray1146();
    problem.test();
  }

  private void test() {
    SnapshotArray snapshotArray = new SnapshotArray(3);
    snapshotArray.set(0, 5);
    System.out.println(snapshotArray.snap());//0
    snapshotArray.set(0, 6);
    System.out.println(snapshotArray.snap());//1
    System.out.println(snapshotArray.get(0, 0));
    System.out.println(snapshotArray.get(0, 1));
  }

  class SnapshotArray {

    private int snapIdx;
    private List<TreeMap<Integer, Integer>> list;

    public SnapshotArray(int length) {
      snapIdx = 0;

      list = new ArrayList<>(length);
      for (int i = 0; i < length; i++) {
        list.add(new TreeMap<>());
        list.get(i).put(0, 0);
      }
    }

    public void set(int index, int val) {
      list.get(index).put(snapIdx, val);
    }

    public int snap() {
      return snapIdx++;
    }

    public int get(int index, int snap_id) {
      return list.get(index).floorEntry(snap_id).getValue();
    }

  }

}
