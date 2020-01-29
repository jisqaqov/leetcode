package prep;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {

  }

  public int[][] multiply(int[][] a, int[][] b) {
    Map<Integer, Set<Integer>> mapOfA = new HashMap<>();

    for (int i = 0; i < a.length; i++) {
      mapOfA.put(i, new HashSet<>());
      for (int j = 0; j < a[i].length; j++) {
        if (a[i][j] != 0) {
          mapOfA.get(i).add(j);
        }
      }
    }

    Map<Integer, Set<Integer>> mapOfB = new HashMap<>();
    for (int j = 0; j < b[0].length; j++) {
      mapOfB.put(j, new HashSet<>());
      for (int i = 0; i < b.length; i++) {
        if (b[i][j] != 0) {
          mapOfB.get(j).add(i);
        }
      }
    }

    int[][] c = new int[a.length][b[0].length];

    for (int i = 0; i < c.length; i++) {
      for (int j = 0; j < c[0].length; j++) {
        int p = 0;

        mapOfA.get(i);
        mapOfB.get(j);

        for (int col : mapOfA.get(i)) {
          p += a[i][col] * b[col][j];
        }

        c[i][j] = p;
      }
    }

    return c;
  }

}