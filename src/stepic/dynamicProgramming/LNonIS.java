package stepic.dynamicProgramming;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * ƒано целое число 1<=n<=10^5 и массив A[1Еn], содержащий неотрицательные целые числа, не превосход€щие 10^9.
 * Ќайдите наибольшую невозрастающую подпоследовательность в A.
 * ¬ первой строке выведите еЄ длину k, во второй Ч еЄ индексы 1<=i1<i2<Е<ik<=n (таким образом, A[i1]>=A[i2]>=Е>=A[in]).
 * <p>
 * Sample Input: *
 * 5
 * 5 3 4 4 2
 * Sample Output: *
 * 4
 * 1 3 4 5
 */
public class LNonIS {
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out))) {
      int n = Integer.parseInt(br.readLine());
      int[] A = new int[n];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
        A[i] = Integer.parseInt(st.nextToken());
      }
      int[] result = lNonIs(A);
      int l= result.length;
      writer.println(l);
        for (int i = 0; i < l; i++) {
            writer.print(result[i] + " ");
        }
    } catch (IOException e) {
      System.out.println("-------- Oops!!! --------");
    }
  }

  private static int[] lNonIs(int[] A) {
    int n = A.length;
    int[] D = new int[n];
    Arrays.fill(D, -1);
    int[] index = new int[n];
    int max = 1;
    D[0] = A[0];
    index[0] = 1;
    for (int i = 1; i < n; i++) {
      int j = biSearch(D, A[i]);
      D[j] = A[i];
      index[i] = j + 1;
      if (max < j + 1) max = j + 1;
    }
    return makeResultArray(index, max);
  }

  private static int biSearch(int[] D, int n) {
    int l = 0;
    int r = D.length - 1;
    int index = -1;
    while (l <= r) {
      int m = (l + r) >>> 1;
      if (D[m] < n) {
        r = m - 1;
        index = m;
      } else if (D[m] >= n)
        l = m + 1;
    }
    return index;
  }

  private static int[] makeResultArray(int[] index, int max) {
    int[] result = new int[max];
    int j = max;
    for (int i = index.length - 1; i >= 0; i--) {
      if (index[i] == j) {
        result[j - 1] = i + 1;
        j--;
      }
      if (j < 0) break;
    }
    return result;
  }
}
