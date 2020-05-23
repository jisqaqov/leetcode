package leetcode.p0001;

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
 * Runtime: 44 ms, faster than 58.44% of Java online submissions
 * Memory Usage: 47.8 MB, less than 35.29% of Java online submissions
 */
public class AccountsMerge721 {

  public static void main(String[] args) {
    AccountsMerge721 problem = new AccountsMerge721();
    problem.test();
  }

  private void test() {
    List<List<String>> tc1a = Arrays.asList(
      Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
      Arrays.asList("John", "johnnybravo@mail.com"),
      Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
      Arrays.asList("Mary", "mary@mail.com"));

    System.out.println(accountsMerge(tc1a));
  }

  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    Map<String, Set<String>> graph = new HashMap<>();
    Map<String, String> emailName = new HashMap<>();

    for (List<String> account : accounts) {
      String name = account.get(0);
      String rootEmail = account.get(1);

      for (int i = 1; i < account.size(); i++) {
        String email = account.get(i);

        graph.putIfAbsent(rootEmail, new HashSet<>());
        graph.putIfAbsent(email, new HashSet<>());

        graph.get(rootEmail).add(email);
        graph.get(email).add(rootEmail);

        emailName.put(email, name);
      }
    }

    List<List<String>> output = new ArrayList<>();
    Set<String> used = new HashSet<>();

    for (String email : graph.keySet()) {
      if (used.contains(email)) {
        continue;
      }

      List<String> emails = new ArrayList<>();
      dfs(email, graph, emails, used);
      Collections.sort(emails);

      List<String> account = new ArrayList<>();
      account.add(emailName.get(email));
      account.addAll(emails);

      output.add(account);
    }

    return output;
  }

  private void dfs(String email, Map<String, Set<String>> graph, List<String> emails,
    Set<String> used) {
    used.add(email);
    emails.add(email);

    for (String adj : graph.get(email)) {
      if (!used.contains(adj)) {
        dfs(adj, graph, emails, used);
      }
    }
  }

  private static class V2 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
      DisjointSet ds = new DisjointSet(accounts.size());

      Map<String, Integer> emailToId = new HashMap<>();
      Map<Integer, String> idToName = new HashMap<>();

      int idx = 0;

      for (int i = 0; i < accounts.size(); i++) {
        String name = accounts.get(i).get(0);

        String prEmail = accounts.get(i).get(1);

        int id = emailToId.getOrDefault(prEmail, idx++);

        emailToId.put(prEmail, id);
        idToName.put(id, name);

        for (int j = 2; j < accounts.get(i).size(); j++) {
          String email = accounts.get(i).get(j);

          int emailId = emailToId.getOrDefault(email, id);
          emailToId.put(email, emailId);

          ds.union(id, emailId);
        }
      }

      Map<Integer, List<String>> idToEmails = new HashMap<>();

      for (String email : emailToId.keySet()) {
        int id = ds.root(emailToId.get(email));

        idToEmails.putIfAbsent(id, new ArrayList<>());
        idToEmails.get(id).add(email);
      }

      List<List<String>> output = new ArrayList<>();
      for (Integer id : idToEmails.keySet()) {
        List<String> account = new ArrayList<>();

        account.add(idToName.get(id));

        Collections.sort(idToEmails.get(id));
        account.addAll(idToEmails.get(id));

        output.add(account);
      }

      return output;
    }

    private static class DisjointSet {

      private int[] ds;

      public DisjointSet(int n) {
        ds = new int[n];
        for (int i = 0; i < n; i++) {
          ds[i] = i;
        }
      }

      private void union(int x, int y) {
        int rootX = root(x);
        int rootY = root(y);

        ds[rootX] = rootY;
      }

      private int root(int x) {
        while (ds[x] != x) {
          x = ds[ds[x]];
        }

        return ds[x];
      }
    }
  }

}
