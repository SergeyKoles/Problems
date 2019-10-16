package stepic.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Дано целое число 1?n?10^3 и массив A[1…n] натуральных чисел, не превосходящих 2?10^9.
 * Выведите максимальное 1?k?n, для которого найдётся подпоследовательность 1?i1<i2<…<ik?n длины k,
 * в которой каждый элемент делится на предыдущий (формально: для  всех 1?j<k, A[ij]|A[ij+1]).
 * <p>
 * Sample Input: *
 * 4
 * 3 6 7 12
 * Sample Output: *
 * 3
 */
public class LISBottomUp {
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int n = Integer.parseInt(br.readLine());
      int[] A = new int[n];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
        A[i] = Integer.parseInt(st.nextToken());
      }
      System.out.println(lis(A));
    } catch (IOException e) {
      System.out.println("-------- Oops!!! --------");
    }
  }

  public static int lis(int[] A) {
    int[] D = new int[A.length];
    for (int i = 0; i < A.length; ++i) {
      D[i] = 1;
      for (int j = 0; j < i; ++j) {
        if ((A[i] % A[j] == 0) && D[i] < (D[j] + 1)) {
          D[i] = D[j] + 1;
        }
      }
    }
    int ans = 0;
    for (int i = 0; i < D.length; i++) {
      if (D[i] > ans)
        ans = D[i];
    }
    return ans;
  }
}
