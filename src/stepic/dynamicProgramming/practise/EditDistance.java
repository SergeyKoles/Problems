package stepic.dynamicProgramming.practise;

import java.util.Scanner;

public class EditDistance {
  private static String first;
  private static String second;

  private static int[] cur;
  private static int[] prev;


  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    first = scanner.next();
    second = scanner.next();
    cur = new int[second.length() + 1];
    prev = new int[second.length() + 1];
    System.out.println(editDistance());
  }

  private static int editDistance() {

    for (int n = 0; n <= first.length(); n++) {
      for (int m = 0; m <= second.length(); m++) {
        if (n == 0 && m == 0) cur[m] = 0;
        else {
          int result = Integer.MAX_VALUE;
          if (m > 0)
            result = Math.min(result, cur[m - 1] + 1);
          if (n > 0)
            result = Math.min(result, prev[m] + 1);
          if (n > 0 && m > 0)
            result = Math.min(result, prev[m - 1] + (first.charAt(n - 1) == second.charAt(m - 1) ? 0 : 1));
          cur[m] = result;
        }
      }
//      System.arraycopy(cur, 0, prev, 0, second.length() + 1);
      int[] tmp = cur;
      cur = prev;
      prev = tmp;
    }
    return prev[second.length()];
  }
}
