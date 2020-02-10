package booking.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;

public class AwardTopKHotels {

  public static void main(String[] args) {
    AwardTopKHotels problem = new AwardTopKHotels();
    problem.test();
  }

  public static List<Integer> awardTopKHotels(String positiveKeywords, String negativeKeywords,
    List<Integer> hotelIds, List<String> reviews, int k) {

    int hotels = new HashSet<>(hotelIds).size();

    Set<String> positiveKeywordSet = new HashSet<>(
      Arrays.asList(positiveKeywords.toLowerCase().split(" ")));

    Set<String> negativesKeywordSet = new HashSet<>(
      Arrays.asList(negativeKeywords.toLowerCase().split(" ")));

    Map<Integer, Integer> scores = new HashMap<>();
    for (int i = 0; i < reviews.size(); i++) {

      String[] words = reviews.get(i).toLowerCase().split("\\W+");
      Map<String, Integer> counter = new HashMap<>();

      for (String word : words) {
        if (positiveKeywordSet.contains(word) || negativesKeywordSet.contains(word)) {
          counter.put(word, counter.getOrDefault(word, 0) + 1);
        }
      }

      int score = 0;
      for (String word : counter.keySet()) {
        if (positiveKeywordSet.contains(word)) {
          score += counter.get(word) * 3;
        } else {
          score += counter.get(word) * -1;
        }
      }

      scores.put(hotelIds.get(i), scores.getOrDefault(hotelIds.get(i), 0) + score);
    }

    for (int hotelId : hotelIds) {
      if (!scores.containsKey(hotelId)) {
        scores.put(hotelId, 0);
      }
    }

    List<Entry<Integer, Integer>> list = new ArrayList<>(scores.entrySet());

    List<Integer> output = new ArrayList<>();

    if (k > hotels) {
      list.sort((e1, e2) -> e2.getValue() - e1.getValue());

      for (Map.Entry<Integer, Integer> entry : list) {
        output.add(entry.getKey());
      }
    } else {
      PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
        Comparator.comparingInt(Entry::getValue));

      for (Map.Entry<Integer, Integer> entry : scores.entrySet()) {
        pq.add(entry);
        if (pq.size() > k) {
          pq.poll();
        }
      }

      while (!pq.isEmpty()) {
        output.add(pq.poll().getKey());
      }

      Collections.reverse(output);
    }

    return output;
  }

  private void test() {
    String p = "breakfast beach citycenter location metro view staff price";
    String n = "not";
    List<Integer> hotelIds = new ArrayList<>(Arrays.asList(1, 2, 1, 1, 2, 5));

    List<String> r = new ArrayList<>(
      Arrays.asList("This hotel has a nice view of the citycenter. The location is perfect.",
        "The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth.",
        "Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel.",
        "They said I couldn't take my dog and there were other guests with dogs! That is not fair.",
        "Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter."));
    System.out.println(awardTopKHotels(p, n, hotelIds, r, 2));
  }

}