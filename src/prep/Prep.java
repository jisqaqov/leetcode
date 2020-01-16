package prep;

import java.util.ArrayList;
import java.util.List;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();

    problem.test();
  }

  private void test() {
    System.out.println(addOperators("123", 6));//"1+2+3", "1*2*3"
    System.out.println(addOperators("232", 8));//"2*3+2", "2+3*2"
    System.out.println(addOperators("105", 5));//"1*0+5","10-5"
    System.out.println(addOperators("00", 0));//"0+0", "0-0", "0*0"
    System.out.println(addOperators("3456237490", 9191));//
  }

  public List<String> addOperators(String num, int target) {
    List<String> list = new ArrayList<>();

    add(num, "", 0, target, 0, 0, list);

    return list;
  }

  private void add(String num, String str, int index, int target, long prod, long mult,
    List<String> list) {
    if (index == num.length()) {
      if (target == prod) {
        list.add(str);
      }

      return;
    }

    for (int i = index; i < num.length(); i++) {
      if (i > index && num.charAt(index) == '0') {
        break;
      }

      long val = Long.parseLong(num.substring(index, i + 1));

      if (index == 0) {
        add(num, str + val, i + 1, target, val, val, list);
      } else {
        add(num, str + "+" + val, i + 1, target, prod + val, val, list);
        add(num, str + "-" + val, i + 1, target, prod - val, -val, list);
        add(num, str + "*" + val, i + 1, target, prod - mult + mult * val, mult * val, list);
      }
    }
  }


}