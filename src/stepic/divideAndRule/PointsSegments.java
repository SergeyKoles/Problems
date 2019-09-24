package stepic.divideAndRule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * В первой строке задано два целых числа 1≤n≤50000 и 1≤m≤50000 — количество отрезков и точек на прямой, соответственно.
 * Следующие n строк содержат по два целых числа ai и bi (ai≤bi) — координаты концов отрезков.
 * Последняя строка содержит m целых чисел — координаты точек. Все координаты не превышают 10^8 по модулю. Т
 * очка считается принадлежащей отрезку, если она находится внутри него или на границе.
 * Для каждой точки в порядке появления во вводе выведите, скольким отрезкам она принадлежит.
 * <p>
 * <p>
 * Sample Input:
 * 2 3
 * 0 5
 * 7 10
 * 1 6 11
 * Sample Output:
 * 1 0 0
 */

public class PointsSegments {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int n = Integer.parseInt(br.readLine());
      int m = Integer.parseInt(br.readLine());
      Segment[] segments = new Segment[n];
      StringTokenizer st;
      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        segments[i] = new Segment(l, r);
      }
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < m; i++) {
        int p = Integer.parseInt(st.nextToken());
        System.out.println();
      }
    } catch (IOException e) {
      System.out.println("-------- Oops!!! --------");
    }
  }

  private static int segmentCounter(Segment[] s, int p) {
    int counter = 0;
    return counter;
  }

  private static class Segment {

    int l;
    int r;

    public Segment(int l, int r) {
      this.l = l;
      this.r = r;
    }

    @Override
    public String toString() {
      return "{" + l + " - " + r + "}";
    }
  }
}
