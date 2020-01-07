package prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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
      topToys(6, 2, new String[]{"elmo", "elsa", "legos", "drone", "tablet", "warcraft"}, 6,
        new String[]{
          "Elmo is the hottest of the season! Elmo will be on every kid's wishlist!",
          "The new Elmo dolls are super high quality",
          "Expect the Elsa dolls to be very popular this year, Elsa!",
          "Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good",
          "For parents of older kids, look into buying them a drone",
          "Warcraft is slowly rising in popularity ahead of the holiday season"
        }));
  }

  private static List<String> topToys(int numToys, int topToys, String[] toys, int numQuotes, String[] quotes) {
    List<String> res = new ArrayList<>();
    Set<String> setToys = new HashSet<>();
    Map<String, WordStats> mapWords = new HashMap<>();

    for (int i = 0; i < numToys; i++)
      setToys.add(toys[i]);

    for (int i = 0; i < numQuotes; i++)
    {
      String q = quotes[i];
      q = q.replaceAll("[\\!?,;.]", "").toLowerCase();
      String[] words = q.split(" ");

      for (int w = 0; w < words.length; w++)
      {
        String word = words[w];
        if (setToys.contains(word))
        {
          WordStats stats;
          if (mapWords.containsKey(word))
            stats = mapWords.get(word);
          else
            stats = new WordStats(word, 0);
          stats.countTimes++;
          stats.quotesIds.add(i);
          mapWords.put(word, stats);
        }
      }
    }

    PriorityQueue<WordStats> pq = new PriorityQueue<WordStats>(new Comparator<WordStats>() {
      @Override
      public int compare(WordStats o1, WordStats o2) {
        if (o1.countTimes != o2.countTimes)
          return Integer.compare(o2.countTimes, o1.countTimes);
        else if (o1.quotesIds.size() != o2.quotesIds.size())
          return Integer.compare(o2.quotesIds.size(), o1.quotesIds.size());
        else
          return o1.word.compareTo(o2.word);
      }
    });
    pq.addAll(mapWords.values());

    if (topToys > pq.size())
      for (int i = 0; i < numToys && !pq.isEmpty(); i++)
        res.add(pq.poll().word);
    else
      for (int i = 0; i < pq.size(); i++)
        res.add(pq.poll().word);

    return res;
  }

  private static class WordStats {
    String word;
    int countTimes;
    Set<Integer> quotesIds;
    public WordStats(String word, int countTimes) {
      this.word = word;
      this.countTimes = countTimes;
      this.quotesIds = new HashSet<>();
    }
  }

}