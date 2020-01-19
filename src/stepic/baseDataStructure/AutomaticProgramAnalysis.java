package stepic.baseDataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AutomaticProgramAnalysis {
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());

      int[] parent = makeSet(n);
      int[][] equality = new int[2][e];
      int[][] inEquality = new int[2][d];

      for (int i = 0; i < e; i++) {
        st = new StringTokenizer(br.readLine());
        equality[0][i] = Integer.parseInt(st.nextToken());
        equality[1][i] = Integer.parseInt(st.nextToken());
      }
      for (int i = 0; i < d; i++) {
        st = new StringTokenizer(br.readLine());
        inEquality[0][i] = Integer.parseInt(st.nextToken());
        inEquality[1][i] = Integer.parseInt(st.nextToken());
      }
      for (int i = 0; i < e; i++) {
        union(--equality[0][i], --equality[1][i], parent);
      }
      for (int i = 0; i < d; i++) {
        if (!isInEquality(--inEquality[0][i], --inEquality[1][i], parent)) {
          System.out.println("0");
          return;
        }
      }
      System.out.println("1");

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

  private static void union(int d, int s, int[] parent) {
    if (d != s) {
      int dId = find(parent, d);
      int sId = find(parent, s);
      if (dId != sId) {
        parent[sId] = dId;
      }
    }
  }

  private static int find(int[] parent, int d) {
    int i = d;
    if (parent[i] != i) {
      parent[i] = find(parent, parent[i]);
    }
    return parent[i];
  }

  private static boolean isInEquality(int n1, int n2, int[] parent) {
    if (n1 != n2) {
      int n1Id = find(parent, n1);
      int n2Id = find(parent, n2);
      return n1Id != n2Id;
    }
    return false;
  }
}
