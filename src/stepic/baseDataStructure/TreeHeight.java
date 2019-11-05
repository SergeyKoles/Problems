package stepic.baseDataStructure;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * Высота дерева
 * Sample Input:
 *
 * 10
 * 9 7 5 5 2 9 9 9 2 -1
 * Sample Output:
 *
 * 4
 */
public class TreeHeight {
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int n = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      int[] A = new int[n];
      for (int i = 0; i < n; i++) {
        A[i] = Integer.parseInt(st.nextToken());
      }
      System.out.println(new TreeHeight().run(A, n));
    } catch (IOException e) {
      System.out.println("-------- Oops!!! --------");
    }
  }

  private int run(int[] A, int n) {
    int res = 0;
    for (int i = 0; i < n; i++) {
      int p = i;
      int cur = 1;
      while (A[p] != -1) {
        cur++;
        p = A[p];
      }
      res = Math.max(res, cur);
    }
    return res;
  }
}


