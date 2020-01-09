package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author Jandos Iskakov
 * problem: 1146. Snapshot Array
 * algorithm: Array
 * time complexity: O(N)
 * space complexity: O(N)
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

  class SnapshotArrayV2 {

    private int snapIdx;
    private List<List<int[]>> list;

    public SnapshotArrayV2(int length) {
      snapIdx = 0;

      list = new ArrayList<>(length);
      for (int i = 0; i < length; i++) {
        list.add(new ArrayList<>());
        list.get(i).add(0, new int[] {0, 0});
      }
    }

    public void set(int index, int val) {
      List<int[]> snaps = list.get(index);

      int[] snap = snaps.get(snaps.size() - 1);
      if (snap[0] < snapIdx) {
        snaps.add(new int[] {snapIdx, val});
      } else {
        snap[1] = val;
      }
    }

    public int snap() {
      return snapIdx++;
    }

    public int get(int index, int snap_id) {
      List<int[]> vals = list.get(index);

      int val = 0;
      int l = 0, r = vals.size() - 1;

      while (l <= r) {
        int mid = l + (r - l) / 2;

        int[] snap = vals.get(mid);
        if (snap[0] <= snap_id) {
          val = snap[1];

          l = mid + 1;
        } else {
          r = mid - 1;
        }
      }

      return val;
    }

  }

}
