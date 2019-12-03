package prep;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    System.out.println(minAddToMakeValid("())"));//1
    System.out.println(minAddToMakeValid("((("));//3
    System.out.println(minAddToMakeValid("()"));//0
    System.out.println(minAddToMakeValid("()))(("));//4
  }

  public int minAddToMakeValid(String s) {
    int opened = 0;
    int count = 0;

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        opened++;
      } else if (s.charAt(i) == ')') {
        if (opened == 0) {
          count++;
        } else {
          opened--;
        }
      }
    }

    return opened + count;
  }


}