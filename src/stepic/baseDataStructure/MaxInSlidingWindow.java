package stepic.baseDataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
    } catch (IOException e) {
      System.out.println("-------- Oops!!! --------");
    }
  }

  private void run(int n, int m, int[] A) {
  }
}
