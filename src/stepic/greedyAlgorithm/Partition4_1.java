package stepic.greedyAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * По данному числу 1≤n≤10^9 найдите максимальное число k,
 * для которого n можно представить как сумму k различных натуральных слагаемых.
 * Выведите в первой строке число k, во второй — k слагаемых.
 *
 */
public class Partition4_1 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    List<Integer> row = new ArrayList<>();
    int sum = 0;
    for (int i = 1; i <= n; i++) {
      sum += i;
      row.add(i);
      if (sum >= n) {
        break;
      }
    }

    for (int i = 0; i < row.size(); i++) {
      if (sum==n)
        break;
      if ((sum - row.get(i)) == n) {
        row.remove(i);
        break;
      }
    }
    System.out.println(row.size());
    System.out.println(row.stream()
        .map(String::valueOf)
        .collect(Collectors.joining(" ")));
  }
}
