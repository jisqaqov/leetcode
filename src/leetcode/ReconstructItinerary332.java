package leetcode;

import java.util.*;

/**
 * @author Jandos Iskakov
 * problem: 332. Reconstruct Itinerary
 * algorithm: DFS, Graph
 */
public class ReconstructItinerary332 {

    public static void main(String[] args) {
        ReconstructItinerary332 solution = new ReconstructItinerary332();
        solution.test();
    }

    public void test() {
        String[][] tc1a  = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
        String[][] tc2a  = {{"MUC", "LHR"},{"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
        String[][] tc3a  = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
        String[][] tc4a  = {{"JFK","AAA"},{"AAA","JFK"},{"JFK","BBB"},{"JFK","CCC"},{"CCC","JFK"}};
        String[][] tc5a  = {{"EZE","AXA"},{"TIA","ANU"},{"ANU","JFK"},{"JFK","ANU"},{"ANU","EZE"},{"TIA","ANU"},{"AXA","TIA"},{"TIA","JFK"},{"ANU","TIA"},{"JFK","TIA"}};
        String[][] tc6a  = {{"EZE","TIA"},{"EZE","HBA"},{"AXA","TIA"},{"JFK","AXA"},{"ANU","JFK"},{"ADL","ANU"},{"TIA","AUA"},{"ANU","AUA"},{"ADL","EZE"},{"ADL","EZE"},{"EZE","ADL"},{"AXA","EZE"},{"AUA","AXA"},{"JFK","AXA"},{"AXA","AUA"},{"AUA","ADL"},{"ANU","EZE"},{"TIA","ADL"},{"EZE","ANU"},{"AUA","ANU"}};
        String[][] tc7a  = {{"AUA","PER"},{"LST","ADL"},{"CNS","TIA"},{"ADL","VIE"},{"ADL","VIE"},{"BNE","CBR"},{"EZE","VIE"},{"JFK","ADL"},{"CBR","HBA"},{"CNS","AUA"},{"HBA","BNE"},{"OOL","LST"},{"PER","AUA"},{"SYD","AXA"},{"TIA","BNE"},{"MEL","AXA"},{"AUA","OOL"},{"LST","OOL"},{"DRW","SYD"},{"CNS","SYD"},{"INN","CBR"},{"BNE","INN"},{"BNE","EZE"},{"BNE","CNS"},{"OOL","DRW"},{"BNE","EZE"},{"CBR","BNE"},{"TIA","LST"},{"OOL","JFK"},{"SYD","CBR"},{"PER","MEL"},{"HBA","OOL"},{"MEL","EZE"},{"OOL","HBA"},{"AUA","PER"},{"DRW","HBA"},{"VIE","ANU"},{"HBA","BNE"},{"DRW","TIA"},{"AXA","VIE"},{"LST","BNE"},{"CNS","MEL"},{"ADL","HBA"},{"VIE","OOL"},{"TIA","MEL"},{"PER","DRW"},{"INN","CNS"},{"JFK","LST"},{"LST","DRW"},{"MEL","TIA"},{"EZE","CNS"},{"AXA","CNS"},{"ADL","LST"},{"TIA","JFK"},{"VIE","SYD"},{"INN","JFK"},{"VIE","ADL"},{"SYD","AUA"},{"ANU","INN"},{"BNE","SYD"},{"JFK","INN"},{"SYD","PER"},{"ADL","TIA"},{"JFK","ADL"},{"CBR","ADL"},{"EZE","BNE"}};
        
        System.out.println(findItinerary(tc1a).toString().equals("[JFK, ATL, JFK, SFO, ATL, SFO]"));
        System.out.println(findItinerary(tc2a).toString().equals("[JFK, MUC, LHR, SFO, SJC]"));
        System.out.println(findItinerary(tc3a).toString().equals("[JFK, NRT, JFK, KUL]"));
        System.out.println(findItinerary(tc4a).toString().equals("[JFK, AAA, JFK, CCC, JFK, BBB]"));
        System.out.println(findItinerary(tc5a).toString().equals("[JFK, ANU, EZE, AXA, TIA, ANU, JFK, TIA, ANU, TIA, JFK]"));
        System.out.println(findItinerary(tc6a).toString().equals("[JFK, AXA, AUA, ADL, ANU, AUA, ANU, EZE, ADL, EZE, ANU, JFK, AXA, EZE, TIA, AUA, AXA, TIA, ADL, EZE, HBA]"));
        System.out.println(findItinerary(tc7a).toString().equals("[JFK, ADL, HBA, BNE, CBR, ADL, LST, ADL, TIA, BNE, CNS, AUA, OOL, DRW, HBA, BNE, EZE, BNE, EZE, CNS, MEL, AXA, CNS, SYD, AUA, PER, AUA, PER, DRW, SYD, AXA, VIE, ADL, VIE, ANU, INN, CBR, BNE, INN, CNS, TIA, JFK, ADL, VIE, OOL, HBA, OOL, JFK, INN, JFK, LST, BNE, SYD, PER, MEL, TIA, LST, OOL, LST, DRW, TIA, MEL, EZE, VIE, SYD, CBR, HBA]"));
    }

    public List<String> findItinerary(String[][] tickets) {
        List<String> itinerary = new ArrayList<>();
        Map<String, Integer> visited = new HashMap<>();

        Map<String, List<String>> ticketsMap = new HashMap<>();
        for (String[] ticket : tickets) {
            ticketsMap.putIfAbsent(ticket[0], new ArrayList<>());
            ticketsMap.get(ticket[0]).add(ticket[1]);

            String ticketHash = ticket[0] + ":" + ticket[1];
            visited.put(ticketHash, visited.getOrDefault(ticketHash, 0) + 1);
        }

        for (String departure : ticketsMap.keySet()) {
            ticketsMap.get(departure).sort(String::compareTo);
        }

        String start = "JFK";

        Deque<String> deque = new ArrayDeque<>();
        deque.addLast(start);

        int flights = 0;
        dfs(tickets.length, start, deque, ticketsMap, visited, flights);

        while (!deque.isEmpty()) {
            itinerary.add(deque.poll());
        }

        return itinerary;
    }

    private boolean dfs(int n, String from, Deque<String> queue,
                        Map<String, List<String>> map,
                        Map<String, Integer> visited, int flights) {
        if (flights == n) {
            return true;
        }

        if (!map.containsKey(from)) {
            return false;
        }

        for (String to : map.get(from)) {
            String ticket = from + ":" + to;
            if (visited.getOrDefault(ticket, 0) <= 0) {
                continue;
            }

            visited.put(ticket, visited.get(ticket) - 1);
            queue.addLast(to);
            flights++;

            boolean valid = dfs(n, to, queue, map, visited, flights);
            if (!valid) {
                flights--;
                visited.put(ticket, visited.get(ticket) + 1);
                queue.removeLast();
            } else {
                return true;
            }
        }

        return false;
    }

}
