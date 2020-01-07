package prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Prep {

  public static void main(String[] args) {
    Prep problem = new Prep();
    problem.test();
  }

  private void test() {
    System.out.println(
      topToys(6, 2, Arrays.asList("elmo", "elsa", "legos", "drone", "tablet", "warcraft"), 6,
        Arrays.asList(
          "Elmo is the hottest of the season! Elmo will be on every kid's wishlist!",
          "The new Elmo dolls are super high quality",
          "Expect the Elsa dolls to be very popular this year, Elsa!",
          "Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good",
          "For parents of older kids, look into buying them a drone",
          "Warcraft is slowly rising in popularity ahead of the holiday season"
        )));
  }

  private List<String> topToys(int numToys, int topToys, List<String> toys, int numQuotes,
    List<String> quotes) {
    Map<String, Integer> freq = new HashMap<>();
    for (String toy : toys) {
      freq.put(toy, 0);
    }

    for (String quote : quotes) {
      Set<String> used = new HashSet<>();

      String[] words = quote.split(" ");
      for (String word : words) {
        String wordLc = word.toLowerCase();
        if (used.contains(wordLc) || !freq.containsKey(wordLc)) {
          continue;
        }

        used.add(wordLc);
        freq.put(wordLc, freq.get(wordLc) + 1);
      }
    }

    PriorityQueue<String> pq = new PriorityQueue<>((t1, t2) -> {
      if (freq.get(t1).compareTo(freq.get(t2)) == 0) {
        return t2.compareTo(t1);
      }

      return freq.get(t1) - freq.get(t2);
    });

    if (topToys > numToys) {
      for (String toy : freq.keySet()) {
        if (freq.get(toy) > 0) {
          pq.add(toy);
        }
      }
    } else {
      for (String toy : toys) {
        pq.add(toy);

        if (pq.size() > topToys) {
          pq.poll();
        }
      }
    }

    List<String> output = new ArrayList<>();
    while (!pq.isEmpty()) {
      output.add(pq.poll());
    }

    Collections.reverse(output);

    return output;
  }

}