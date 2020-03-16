package stepic.baseDataStructure.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TestRequestSumOnSegment {

  private static ArrayList<Long> list = new ArrayList<>();

  public static void add(long value) {
    if (!list.contains(value)) {
      list.add(value);
      Collections.sort(list);
    }
  }

  public static void delete(long value) {
    list.remove(value);
  }

  public static String find(long value) {
    if (list.contains(value))
      return "Found";
    return "Not found";
  }

  public static long sum(long left, long right) {
    long sum = 0;
    for (Long i : list) {
      if (i >= left) {
        if (i <= right) {
          sum += i;
        } else {
          return sum;
        }
      }
    }
    return sum;
  }

  public static String print() {
    return list.stream().map(Object::toString).collect(Collectors.joining(" "));
  }
}
