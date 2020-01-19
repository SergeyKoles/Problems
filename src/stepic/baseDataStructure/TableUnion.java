package stepic.baseDataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TableUnion {
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      int[] R = new int[n];
      st = new StringTokenizer(br.readLine());
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < n; i++) {
        int r = Integer.parseInt(st.nextToken());
        if (r > max)
          max = r;
        R[i] = r;
      }
      int[] parent = makeSet(n);
      int[][] DS = new int[2][m];
      int d;
      int s;
      for (int i = 0; i < m; i++) {
        st = new StringTokenizer(br.readLine());
        d = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        DS[0][i] = d;
        DS[1][i] = s;
      }
      for (int i = 0; i < m; i++) {
        max = union(--DS[0][i], --DS[1][i], max, R, parent);
        System.out.println(max);
      }
    } catch (IOException e) {
      System.out.println("-------- Oops!!! --------");
    }
  }

  private static int[] makeSet(int n) {
    int[] p = new int[n];
    for (int i = 0; i < n; i++) {
      p[i] = i;
    }
    return p;
  }

  private static int union(int d, int s, int max, int[] R, int[] parent) {
    if (d != s) {
      int dId = find(parent, d);
      int sId = find(parent, s);
      if (dId != sId) {
        parent[sId] = dId;
        R[dId] += R[sId];
        if (R[dId] > max) {
          max = R[dId];
        }
      }
    }
    return max;
  }

  private static int find(int[] parent, int d) {
    int i = d;
    if (parent[i] != i) {
      parent[i] = find(parent, parent[i]);
    }
    return parent[i];
  }
}
