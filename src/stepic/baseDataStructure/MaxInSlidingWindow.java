package stepic.baseDataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class MaxInSlidingWindow {
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int n = Integer.parseInt(br.readLine());
      int[] A = new int[n];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
        A[i] = Integer.parseInt(st.nextToken());
      }
      int m = Integer.parseInt(br.readLine());
      new MaxInSlidingWindow().run(n, m, A);
    } catch (IOException e) {
      System.out.println("-------- Oops!!! --------");
    }
  }

  private void run(int n, int m, int[] A) {
    TreeSet<Integer> wind = new TreeSet<>();
    for (int i = 0; i < m; i++) {
      wind.add(A[i]);
    }
    System.out.print(wind.last() + " ");
    for (int i = m, j = 0; i < n; i++, j++) {
      wind.remove(A[j]);
      wind.add(A[i]);
      System.out.print(wind.last() + " ");
    }
  }
}
