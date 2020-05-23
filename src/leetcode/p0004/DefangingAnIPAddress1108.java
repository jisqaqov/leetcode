package leetcode.p0004;

/**
 * @author Jandos Iskakov
 * problem: 1108. Defanging an IP Address
 * algorithm: String
 * time complexity: O(N)
 * space complexity: O(N)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions
 * Memory Usage: 37.5 MB, less than 100.00% of Java online submissions
 */
public class DefangingAnIPAddress1108 {

  public static void main(String[] args) {
    DefangingAnIPAddress1108 problem = new DefangingAnIPAddress1108();
    problem.test();
  }

  private void test() {
    System.out.println(defangIPaddr("1.1.1.1"));//1[.]1[.]1[.]1
    System.out.println(defangIPaddr("255.100.50.0"));//255[.]100[.]50[.]0
  }

  public String defangIPaddr(String address) {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < address.length(); i++) {
      char ch = address.charAt(i);
      if (ch == '.') {
        sb.append("[.]");
      } else {
        sb.append(ch);
      }
    }

    return sb.toString();
  }

}