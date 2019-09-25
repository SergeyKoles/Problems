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
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      Segment[] segments = new Segment[n];
      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        segments[i] = new Segment(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
      }
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < m; i++) {
        System.out.print(segmentCounter(segments, Integer.parseInt(st.nextToken())) + " ");
      }
    } catch (IOException e) {
      System.out.println("-------- Oops!!! --------");
    }
  }

  private static int segmentCounter(Segment[] s, int p) {
    int counter = 0;
    partition(s, p);
    int i = 0;
    while (i < s.length && s[i].l <= p) {
      if (s[i].r >= p)
        counter++;
      i++;
    }

    return counter;
  }

  private static void partition(Segment[] s, int p) {
    int l = 0;
    int r = s.length - 1;
    while (l <= r) {
      while (l < s.length && s[l].l <= p) l++;
      while (r >= 0 && s[r].l > p) r--;
      if (l <= r) {
        swap(s, l, r);
      }
      l++;
      r--;
    }
  }

  private static void swap(Segment[] s, int l, int r) {
    Segment tmp = s[l];
    s[l] = s[r];
    s[r] = tmp;
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
