package prep;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    SnapshotArray snapshotArray = new SnapshotArray(3);
    System.out.println(snapshotArray.snap());//0
    System.out.println(snapshotArray.get(0, 1));

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
      }
    }

    public void set(int index, int val) {
      list.get(index).put(snapIdx, val);
    }

    public int snap() {
      return snapIdx++;
    }

    public int get(int index, int snap_id) {
      TreeMap<Integer, Integer> snaps = list.get(index);
      if (snaps.floorEntry(snap_id) == null) {
        return 0;
      }

      return snaps.floorEntry(snap_id).getValue();
    }

  }

}