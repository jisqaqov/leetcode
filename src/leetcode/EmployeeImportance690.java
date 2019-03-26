package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Jandos Iskakov
 * problem: 690. Employee Importance
 * algorithm: BFS
 * time complexity: O(n)
 * space complexity: O(n)
 */
public class EmployeeImportance690 {

    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = employees.stream()
                .collect(Collectors.toMap(o -> o.id, o -> o));

        int imp = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(id);

        while (!queue.isEmpty()) {
            int currId = queue.poll();
            imp += map.get(currId).importance;

            queue.addAll(map.get(currId).subordinates);
        }

        return imp;
    }

}
