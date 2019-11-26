package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Jandos Iskakov
 * problem: 721. Accounts Merge
 * algorithm: DFS, Graph
 * time complexity: O(V+E)
 * space complexity: O(V+E)
 * Runtime: 44 ms, faster than 58.44% of Java online submissions for Accounts Merge.
 * Memory Usage: 47.8 MB, less than 35.29% of Java online submissions for Accounts Merge.
 */
public class AccountsMerge721 {

  public static void main(String[] args) {
    AccountsMerge721 problem = new AccountsMerge721();
    problem.test();
  }

  private void test() {
    List<List<String>> tc1a = new ArrayList<>();
    tc1a.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
    tc1a.add(Arrays.asList("John", "johnnybravo@mail.com"));
    tc1a.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
    tc1a.add(Arrays.asList("Mary", "mary@mail.com"));

    System.out.println(accountsMerge(tc1a));
  }

  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    Map<String, Set<String>> graph = new HashMap<>();
    Map<String, String> emailName = new HashMap<>();

    for (List<String> account : accounts) {
      String username = account.get(0);

      String rootEmail = account.get(1);

      for (int i = 1; i < account.size(); i++) {
        String email = account.get(i);

        graph.putIfAbsent(email, new HashSet<>());

        graph.get(email).add(rootEmail);
        graph.get(rootEmail).add(email);

        emailName.putIfAbsent(email, username);
      }
    }

    Set<String> used = new HashSet<>();
    List<List<String>> output = new ArrayList<>();

    for (String email : graph.keySet()) {
      if (used.contains(email)) {
        continue;
      }

      List<String> emails = new ArrayList<>();
      dfs(emails, graph, used, email);
      Collections.sort(emails);

      List<String> account = new ArrayList<>();
      account.add(emailName.get(email));
      account.addAll(emails);

      output.add(account);
    }

    return output;
  }

  private void dfs(List<String> list, Map<String, Set<String>> graph, Set<String> used,
    String email) {
    list.add(email);

    used.add(email);

    for (String adj : graph.get(email)) {
      if (!used.contains(adj)) {
        dfs(list, graph, used, adj);
      }
    }
  }

}
