package facebook;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Jandos Iskakov
 * algorithm: Hash Table
 * time complexity: O(N)
 * space complexity: O(N)
 * problem:
 * https://leetcode.com/discuss/interview-question/486188/Facebook-or-Phone-or-Friend-Suggestion
 * Suppose you have a small, in-memory, social network and each person registered in it is modelled as follow:
 *
 * Person: {int id, Set<Integer> friends}
 *
 * Now code a method public Person friendSuggestion(Person p) which will return the person that has most in friends in common with the input 'p'. In case multiple people have the same number of friends in common, return any one of them. And in case there is no person to return, then NULL should be the answer.
 *
 * Suppose the following scenario:
 *
 * Person A: [B, C]
 * Person B: [A, D, E]
 * Person C: [A, D, F]
 * Person D: [B, C, E]
 * Person E: [B, D, F]
 * Person F: [C, E]
 *
 * When we call friendSuggestion(A) it will return Person D.
 */
public class FriendSuggestion {

  public static void main(String[] args) {
    FriendSuggestion problem = new FriendSuggestion();
    problem.test1();
    problem.test2();
  }

  private void test1() {
    Person a = new Person(1);
    Person b = new Person(2);
    Person c = new Person(3);
    Person d = new Person(4);
    Person e = new Person(5);
    Person f = new Person(6);

    a.friends.addAll(Arrays.asList(b, c));
    b.friends.addAll(Arrays.asList(a, d, e));
    c.friends.addAll(Arrays.asList(a, d, f));
    d.friends.addAll(Arrays.asList(b, c, e));
    e.friends.addAll(Arrays.asList(b, d, f));
    f.friends.addAll(Arrays.asList(c, e));

    System.out.println(friendSuggestion(a));
  }

  private void test2() {
    Person a = new Person(1);
    Person b = new Person(2);
    Person c = new Person(3);

    a.friends.addAll(Arrays.asList(b, c));
    b.friends.addAll(Arrays.asList(a, c));
    c.friends.addAll(Arrays.asList(a, b));

    System.out.println(friendSuggestion(a));
  }

  public Person friendSuggestion(Person p) {
    int max = -1;
    Person output = null;

    Map<Person, Integer> map = new HashMap<>();

    for (Person friend : p.friends) {
      for (Person mutual : friend.friends) {
        if (mutual.id != p.id && !p.friends.contains(mutual)) {
          map.put(mutual, map.getOrDefault(mutual, 0) + 1);
        }
      }
    }

    for (Map.Entry<Person, Integer> mutual : map.entrySet()) {
      if (mutual.getValue() > max) {
        max = mutual.getValue();
        output = mutual.getKey();
      }
    }

    return output;
  }

  private static class Person {

    private int id;
    private Set<Person> friends = new HashSet<>();

    public Person(int id) {
      this.id = id;
    }

    @Override
    public String toString() {
      return "Person{" +
        "id=" + id +
        '}';
    }
  }

}