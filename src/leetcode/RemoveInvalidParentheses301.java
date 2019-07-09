package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Jandos Iskakov
 * problem: 301. Remove Invalid Parentheses
 * algorithm: BFS
 * time complexity: ????
 * space complexity: ????
 */
//This problem should be optimized
public class RemoveInvalidParentheses301 {

    public static void main(String[] args) {
        RemoveInvalidParentheses301 problem = new RemoveInvalidParentheses301();
        problem.test();
    }

    private void test() {
        System.out.println(removeInvalidParentheses("()())()"));
        System.out.println(removeInvalidParentheses("(a)())()"));
        System.out.println(removeInvalidParentheses(")("));
        System.out.println(removeInvalidParentheses("()((())h()(()()()))(("));//608: ()((())h()(()()()))
    }

    public List<String> removeInvalidParentheses(String s) {
        if (s.length() == 0) {
            return new ArrayList<>(Collections.singletonList(""));
        }

        List<Node> solution = new ArrayList<>();
        List<Boolean> booleans = Arrays.asList(true, false);

        Set<String> set = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();

        Node node1 = new Node(false, s.charAt(0), 0, 0);
        if (node1.balance >= 0) {
            queue.add(node1);
            set.add(node1.sb.toString());
        }

        Node node2 = new Node(true, s.charAt(0), 0, 0);
        if (node2.balance >= 0) {
            queue.add(node2);
            set.add(node2.sb.toString());
        }

        boolean hasBalanced = false;

        while (!queue.isEmpty()) {
            Node currNode = queue.poll();
            set.remove(currNode.sb.toString());

            if (currNode.sb.length() == 0 && hasBalanced) {
                continue;
            }

            if (currNode.index == s.length() - 1) {
                if (currNode.balance == 0 && currNode.sb.length() > 0) {
                    solution.add(currNode);
                }

                continue;
            }

            for (boolean remove : booleans) {
                Node adjNode = new Node(currNode, currNode.index + 1);

                if (!remove) {
                    adjNode.addChar(s.charAt(currNode.index + 1));
                }

                String text = adjNode.sb.toString();
                if (adjNode.balance < 0) {
                    continue;
                }

                if (adjNode.balance == 0 && text.length() > 0) {
                    hasBalanced = true;
                }

                if (!set.contains(text)) {
                    set.add(text);
                    queue.add(adjNode);
                }
            }
        }

        if (solution.size() == 0) {
            return new ArrayList<>(Collections.singletonList(""));
        }

        int max = solution.stream()
                .map(node -> node.sb.length())
                .max(Comparator.comparingInt(len -> len))
                .orElse(0);

        return solution.stream()
                .filter(t -> t.sb.length() == max)
                .map(node -> node.sb.toString())
                .collect(Collectors.toList());
    }

    private static class Node {
        private StringBuilder sb = new StringBuilder();
        private int index;
        private int balance = 0;

        Node(boolean remove, char ch, int index, int balance) {
            this.index = index;
            this.balance = balance;
            if (!remove) {
                addChar(ch);
            }
        }

        Node(Node parent, int index) {
            this.balance = parent.balance;
            this.sb = new StringBuilder(parent.sb);
            this.index = index;
        }

        void addChar(char ch) {
            if (ch == '(' || ch == ')') {
                balance += (ch == '(' ? 1 : -1);
            }

            sb.append(ch);
        }
    }

}
