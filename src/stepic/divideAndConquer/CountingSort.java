package stepic.divideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * Первая строка содержит число 1≤n≤10^4, вторая — n натуральных чисел, не превышающих 10.
 * Выведите упорядоченную по неубыванию последовательность этих чисел.
 */
public class CountingSort {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int[] A = new int[n];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
        A[i] = Integer.parseInt(st.nextToken());
      }
      A = countingSort(A);
      System.out.println(Arrays.stream(A)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "))
      );
    } catch (IOException e) {
      System.out.println("-------- Oops!!! --------");
    }
  }

  private static int[] countingSort(int[] A) {
    int[] B = new int[11];
    for (int i = 0; i < A.length; i++) {
      B[A[i]] += 1;
    }
    for (int i = 1; i < B.length; i++) {
      B[i] += B[i - 1];
    }
    int[] result = new int[A.length];
    for (int i = A.length - 1; i >= 0; i--) {
      result[B[A[i]]-1] = A[i];
      B[A[i]] -= 1;
    }
    return result;
  }
}
