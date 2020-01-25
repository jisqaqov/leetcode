package prep;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    //TODO:
  }

  public int minAddToMakeValid(String s) {
    int open = 0;
    int close = 0;

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        open++;
      } else if (open > 0) {
        open--;
      } else {
        close++;
      }
    }

    return open + close;
  }

}