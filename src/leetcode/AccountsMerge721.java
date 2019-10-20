package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Jandos Iskakov
 * problem: 721. Accounts Merge
 * algorithm: DFS, Graph
 * time complexity: O(V+E)
 * space complexity: O(V+E)
 * Runtime: 208 ms, faster than 5.64% of Java online submissions for Accounts Merge.
 * Memory Usage: 58.7 MB, less than 5.88% of Java online submissions for Accounts Merge.
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
    Map<String, List<Account>> map = new HashMap<>();

    for (int i = 0; i < accounts.size(); i++) {
      List<String> emails = accounts.get(i);

      Account account = new Account();
      account.name = emails.get(0);
      account.index = i;
      account.emails = new HashSet<>(emails.subList(1, emails.size()));

      for (String email : account.emails) {
        map.putIfAbsent(email, new ArrayList<>());
        map.get(email).add(account);
      }
    }

    List<Account> sol = new ArrayList<>();
    Set<Integer> used = new HashSet<>();

    for (String email : map.keySet()) {
      for (Account account : map.get(email)) {
        if (used.contains(account.index)) {
          continue;
        }

        sol.add(account);

        dfs(account, account, map, used);
      }
    }

    return sol.stream()
      .map(account -> {
        List<String> emails = new ArrayList<>();
        emails.add(account.name);
        emails.addAll(account.emails
          .stream()
          .sorted()
          .collect(Collectors.toList()));
        return emails;
      }).collect(Collectors.toList());
  }

  private void dfs(Account merge, Account adj, Map<String, List<Account>> map,
    Set<Integer> used) {
    if (used.contains(adj.index)) {
      return;
    }

    used.add(adj.index);

    Set<Account> adjList = new HashSet<>();

    for (String email : adj.emails) {
      adjList.addAll(map.get(email));
    }

    adjList.remove(merge);

    for (Account account : adjList) {
      merge.emails.addAll(account.emails);

      if (!used.contains(account.index)) {
        dfs(merge, account, map, used);
      }
    }
  }

  private static class Account {

    String name;
    Set<String> emails;
    int index;

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Account account = (Account) o;
      return index == account.index &&
        Objects.equals(name, account.name);
    }

    @Override
    public int hashCode() {
      return Objects.hash(name, index);
    }
  }

}
