package leetcode.p0006;

/**
 * @author Jandos Iskakov
 * problem: 997. Find the Town Judge
 * time complexity: O(n)
 * space complexity: O(n)
 * algorithm: Graph
 */
public class FindTheTownJudge997 {

    public static void main(String[] args) {
        FindTheTownJudge997 solution = new FindTheTownJudge997();
        solution.test();
    }

    public void test() {
        System.out.println(findJudge(2, new int[][] {{1,2}}));
        System.out.println(findJudge(3, new int[][] {{1,3},{2,3}}));
        System.out.println(findJudge(3, new int[][] {{1,3},{2,3},{3, 1}}));
        System.out.println(findJudge(4, new int[][] {{1,3},{1,4},{2,3},{2,4},{4,3}}));
    }

    public int findJudge(int n, int[][] trust) {
        int[] inEdges = new int[n + 1];
        int[] outEdges = new int[n + 1];

        for (int[] people : trust) {
            outEdges[people[0]]++;
            inEdges[people[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (inEdges[i] == n - 1 && outEdges[i] == 0) {
                return i;
            }
        }

        return -1;
    }

}
