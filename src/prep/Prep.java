package prep;

import java.util.HashMap;
import java.util.Map;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    System.out.println(isStrobogrammatic("0"));//true
    System.out.println(isStrobogrammatic("1"));//true
    System.out.println(isStrobogrammatic("69"));//true
    System.out.println(isStrobogrammatic("88"));//true
    System.out.println(isStrobogrammatic("962"));//false
  }

  public boolean isStrobogrammatic(String num) {
    Map<Integer, Integer> map = new HashMap<>();

    map.put(0, 0);
    map.put(1, 1);
    map.put(6, 9);
    map.put(9, 6);
    map.put(8, 8);

    int i = 0;
    int j = num.length() - 1;

    while (i <= j) {
      int startNum = Character.getNumericValue(num.charAt(i));
      int endNum = Character.getNumericValue(num.charAt(j));

      if (startNum != map.getOrDefault(endNum, -1)) {
        return false;
      }

      i++;
      j--;
    }

    return true;
  }

}
