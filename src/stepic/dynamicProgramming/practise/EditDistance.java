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
//    for recursion
//    calculated = new boolean[first.length() + 1][second.length() + 1];

    System.out.println(editDistance());
  }

  private static int editDistance() {
    for (int n = 0; n <= first.length(); n++) {
      for (int m = 0; m <= second.length(); m++) {
        if (n == 0 && m == 0) d[n][m] = 0;
        else if (n == 0) d[n][m] = m;
        else if (m == 0) d[n][m] = n;
        else {
          int res1 = d[n][m - 1] + 1;
          int res2 = d[n - 1][m] + 1;
          int res3 = d[n - 1][m - 1] + (first.charAt(n - 1) == second.charAt(m - 1) ? 0 : 1);
          int result = Math.min(Math.min(res1, res2), res3);
          d[n][m] = result;
        }
      }
    }
    int n = first.length();
    int m = second.length();

    StringBuilder firstLine = new StringBuilder();
    StringBuilder secondLine = new StringBuilder();

    while (n > 0 || m > 0) {
      boolean moveFirst = false;
      boolean moveSecond = false;
      if (n == 0) {
        moveSecond = true;
      } else if (m == 0) {
        moveFirst = true;
      } else {
        int res1 = d[n][m - 1] + 1;
        int res2 = d[n - 1][m] + 1;
        int res3 = d[n - 1][m - 1] + (first.charAt(n - 1) == second.charAt(m - 1) ? 0 : 1);
        if (res1 <= res2 && res1 <= res3) {
          moveSecond = true;
        } else {
          if (res2 <= res3) {
            moveFirst = true;
          } else {
            moveFirst = true;
            moveSecond = true;
          }
        }
      }
      if (moveFirst) {
        firstLine.append(first.charAt(n - 1));
        n--;
      } else {
        firstLine.append("-");
      }
      if (moveSecond) {
        secondLine.append(second.charAt(m - 1));
        m--;
      } else {
        secondLine.append("-");
      }
    }
    firstLine.reverse();
    secondLine.reverse();
    System.out.println(firstLine);
    System.out.println(secondLine);
    return d[first.length()][second.length()];
  }

  private static int editDistanceRecursion(int n, int m) {
    //first[0..n-1], second[0..m-1]
    if (n == 0 && m == 0) return 0;
    if (n == 0) return m;
    if (m == 0) return n;
    if (calculated[n][m]) {
      return d[n][m];
    }
    int res1 = editDistanceRecursion(n, m - 1) + 1;
    int res2 = editDistanceRecursion(n - 1, m) + 1;
    int res3 = editDistanceRecursion(n - 1, m - 1) + (first.charAt(n - 1) == second.charAt(m - 1) ? 0 : 1);
    int result = Math.min(Math.min(res1, res2), res3);
    calculated[n][m] = true;
    d[n][m] = result;
    return result;
  }
}
