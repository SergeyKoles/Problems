package stepic.dynamicProgramming.practise;

import java.util.Arrays;
import java.util.Scanner;

public class EditDistance {
  private static String first;
  private static String second;

  private static int[][] d;
  private static boolean[][] calculated;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    first = scanner.next();
    second = scanner.next();
    d = new int[first.length() + 1][second.length() + 1];
    calculated = new boolean[first.length() + 1][second.length() + 1];
    System.out.println(editDistance(first.length(), second.length()));
  }

  private static int editDistance(int n, int m) {
    //first[0..n-1], second[0..m-1]
    if (n == 0 && m == 0) return 0;
    if (n == 0) return m;
    if (m == 0) return n;
    if (calculated[n][m]) {
      return d[n][m];
    }
    int res1 = editDistance(n, m - 1) + 1;
    int res2 = editDistance(n - 1, m) + 1;
    int res3 = editDistance(n - 1, m - 1) + (first.charAt(n - 1) == second.charAt(m - 1) ? 0 : 1);
    int result = Math.min(Math.min(res1, res2), res3);
    calculated[n][m] = true;
    d[n][m] = result;
    return result;
  }
}
