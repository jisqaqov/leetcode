package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import utils.TestUtils;

public class ExclusiveTimeOfFunctions636 {

  public static void main(String[] args) {
    ExclusiveTimeOfFunctions636 problem = new ExclusiveTimeOfFunctions636();
    problem.test();
  }

  private void test() {
    List<String> tc1a = Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6");
    TestUtils.printArray(exclusiveTime(2, tc1a));

    List<String> tc2a = Arrays
      .asList("0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7");
    TestUtils.printArray(exclusiveTime(1, tc2a));

    List<String> tc3a = Arrays
      .asList("0:start:0", "0:start:2", "0:end:5", "1:start:7", "1:end:7", "0:end:8");
    TestUtils.printArray(exclusiveTime(2, tc3a));

    List<String> tc4a = Arrays.asList(
      "0:start:0", "1:start:5", "2:start:6", "3:start:9", "4:start:11", "5:start:12", "6:start:14",
      "7:start:15", "1:start:24", "1:end:29", "7:end:34", "6:end:37", "5:end:39", "4:end:40",
      "3:end:45", "0:start:49", "0:end:54", "5:start:55", "5:end:59", "4:start:63", "4:end:66",
      "2:start:69", "2:end:70", "2:start:74", "6:start:78", "0:start:79", "0:end:80", "6:end:85",
      "1:start:89", "1:end:93", "2:end:96", "2:end:100", "1:end:102", "2:start:105", "2:end:109",
      "0:end:114");
    TestUtils.printArray(exclusiveTime(8, tc4a));//[20,14,35,7,6,9,10,14]
  }

  public int[] exclusiveTime(int n, List<String> logs) {
    int[] funcs = new int[n];
    if (n == 0) {
      return funcs;
    }

    Deque<Integer> stack = new ArrayDeque<>();
    stack.push(getLog(logs.get(0)).functionId);

    List<Log> list = new ArrayList<>();
    for (String log : logs) {
      list.add(getLog(log));
    }

    for (int i = 1; i < list.size(); i++) {
      Log prevLog = list.get(i - 1);
      Log log = list.get(i);

      if (log.order.equals("start")) {
        int units = 0;
        if (prevLog.order.equals("start")) {
          units = log.timestamp - prevLog.timestamp;
        } else {
          units = log.timestamp - prevLog.timestamp - 1;
        }

        if (!stack.isEmpty()) {
          funcs[stack.peek()] += units;
        }

        stack.push(log.functionId);
      } else {
        int units = log.timestamp - prevLog.timestamp;

        if (prevLog.order.equals("start")) {
          // same function as previous
          funcs[log.functionId] += (units + 1);
        } else {
          funcs[log.functionId] += units;
        }

        stack.pop();
      }
    }

    return funcs;
  }

  private Log getLog(String s) {
    String[] parts = s.split(":");

    Log log = new Log();
    log.functionId = Integer.parseInt(parts[0]);
    log.order = parts[1];
    log.timestamp = Integer.parseInt(parts[2]);

    return log;
  }

  private static class Log {
    private int functionId;
    private String order;
    private int timestamp;
  }

}
