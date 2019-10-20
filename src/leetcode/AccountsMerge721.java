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
    Map<String, Map<String, Set<Account>>> map = new HashMap<>();

    for (int i = 0; i < accounts.size(); i++) {
      List<String> account = accounts.get(i);

      Account acc = new Account();
      acc.name = account.get(0);
      acc.index = i;
      acc.emails = new HashSet<>(account.subList(1, account.size()));

      map.putIfAbsent(acc.name, new HashMap<>());

      for (String email : acc.emails) {
        map.get(acc.name).putIfAbsent(email, new HashSet<>());
        map.get(acc.name).get(email).add(acc);
      }
    }

    List<Account> sol = new ArrayList<>();
    Set<Account> used = new HashSet<>();

    for (String name : map.keySet()) {
      Set<Account> accountsByName = map.get(name)
        .values()
        .stream()
        .flatMap(Collection::stream)
        .collect(Collectors.toSet());

      for (Account account : accountsByName) {
        if (used.contains(account)) {
          continue;
        }

        sol.add(account);

        dfs(account, account, map.get(name), used);
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

  private void dfs(Account merge, Account adj, Map<String, Set<Account>> map,
    Set<Account> used) {
    if (used.contains(adj)) {
      return;
    }

    used.add(adj);

    Set<Account> adjList = new HashSet<>();

    for (String email : adj.emails) {
      adjList.addAll(map.get(email));
    }

    adjList.remove(merge);

    merge.emails.addAll(adjList.stream()
      .map(account -> account.emails)
      .flatMap(Collection::stream)
      .collect(Collectors.toList()));

    for (Account account : adjList) {
      if (!used.contains(account)) {
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
