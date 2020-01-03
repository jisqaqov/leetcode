package prep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    System.out.println(encrypt("geks".toCharArray()));
    System.out.println(encrypt("kiow".toCharArray()));
    System.out.println(encrypt("wuai".toCharArray()));
    System.out.println(encrypt("zxdl".toCharArray()));
    System.out.println(encrypt("ayem".toCharArray()));
  }

  private String encrypt(char[] s) {
    int inc = 'z' - s[0];

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < s.length; i++) {
      int index = s[i] - 'a';
      int letter = (index + inc) % 26;
      sb.append((char) ('a' + letter));
    }

    return sb.toString();
  }

}