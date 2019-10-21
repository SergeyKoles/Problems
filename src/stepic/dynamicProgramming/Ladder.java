package stepic.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Даны число 1<=n<=10^2 ступенек лестницы и целые числа -10^4<=a1,…,an<=10^4, которыми помечены ступеньки.
 * Найдите максимальную сумму, которую можно получить, идя по лестнице снизу вверх (от нулевой до n-й ступеньки),
 * каждый раз поднимаясь на одну или две ступеньки.
 *
 * Sample Input 1:
 *
 * 2
 * 1 2
 * Sample Output 1:
 *
 * 3
 * Sample Input 2:
 *
 * 2
 * 2 -1
 * Sample Output 2:
 *
 * 1
 * Sample Input 3:
 *
 * 3
 * -1 2 1
 * Sample Output 3:
 *
 * 3
 */
public class Ladder {
  private static int[] A;
  private static int sum;
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      A = new int[n];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
        A[i] = Integer.parseInt(st.nextToken());
      }
      climbLadder(A);
    } catch (IOException e) {
      System.out.println("-------- Oops!!! --------");
    }
  }

  private static void climbLadder(int[] A){

  }

}
