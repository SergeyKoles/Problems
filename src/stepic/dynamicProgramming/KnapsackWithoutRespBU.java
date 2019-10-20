package stepic.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ѕерва€ строка входа содержит целые числа 1<=W<=10^4 и 1<=n<=300 Ч вместимость рюкзака и число золотых слитков.
 * —ледующа€ строка содержит n целых чисел 0<=w1,Е,wn<=10^5, задающих веса слитков.
 * Ќайдите максимальный вес золота, который можно унести в рюкзаке.
 * <p>
 * Sample Input:
 * <p>
 * 10 3
 * 1 4 8
 * Sample Output:
 * <p>
 * 9
 */
public class KnapsackWithoutRespBU {
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int W = Integer.parseInt(st.nextToken());
      int n = Integer.parseInt(st.nextToken());
      int[] C = new int[n];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
        C[i] = Integer.parseInt(st.nextToken());
      }
      System.out.println(knapsackWithoutRespBU(W, C));
    } catch (IOException e) {
      System.out.println("-------- Oops!!! --------");
    }
  }

  private static int knapsackWithoutRespBU(int W, int[] C) {
    int[][] D = new int[W + 1][C.length + 1];
    for (int i = 0; i < C.length; i++) {
      for (int w = 0; w < W; w++) {
        if (C[i] > w + 1) {
          D[w + 1][i + 1] = D[w + 1][i];
        } else {
          D[w + 1][i + 1] = Math.max(D[w + 1][i], D[w + 1 - C[i]][i] + C[i]);
        }
      }
    }
    print(D);
    return D[W][C.length];
  }

  private static void print(int[][] D) {
    for (int j = 0; j < D[0].length; j++) {
      for (int i = 0; i < D.length; i++) {
        System.out.printf("%d \t", D[i][j]);
      }
      System.out.println();
    }
  }
}
