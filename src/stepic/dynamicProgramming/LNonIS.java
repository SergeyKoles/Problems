package stepic.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ƒано целое число 1?n?10^5 и массив A[1Еn], содержащий неотрицательные целые числа, не превосход€щие 10^9.
 * Ќайдите наибольшую невозрастающую подпоследовательность в A.
 * ¬ первой строке выведите еЄ длину k, во второй Ч еЄ индексы 1?i1<i2<Е<ik?n (таким образом, A[i1]?A[i2]?Е?A[in]).
 *
 * Sample Input: *
 * 5
 * 5 3 4 4 2
 * Sample Output: *
 * 4
 * 1 3 4 5
 */
public class LNonIS {
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int n = Integer.parseInt(br.readLine());
      int[] A = new int[n];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
        A[i] = Integer.parseInt(st.nextToken());
      }
      System.out.println(lNonIs(A));
    } catch (IOException e) {
      System.out.println("-------- Oops!!! --------");
    }
  }

  private static int[] lNonIs(int[] A){
    return A;
  }
}
