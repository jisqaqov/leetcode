package prep;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    System.out
      .println(reverseWords("Let's take LeetCode contest").equals("s'teL ekat edoCteeL tsetnoc"));
  }

  public String reverseWords(String s) {
    char[] t = s.toCharArray();

    int start = 0;

    for (int i = 0; i <= t.length; i++) {
      if (i == t.length || t[i] == ' ') {
        int l = start;
        int r = i - 1;

        while (l < r) {
          char temp = t[r];
          t[r] = t[l];
          t[l] = temp;

          l++;
          r--;
        }

        start = i + 1;
      }
    }

    return new String(t);
  }


}