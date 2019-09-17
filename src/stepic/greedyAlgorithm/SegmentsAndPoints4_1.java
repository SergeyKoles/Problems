package stepic.greedyAlgorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Задача о покрытии отрезков точками
 *
 * Дано N отрезков на прямой.
 * Требуется покрыть их наименьшим числом точек, т.е.
 * найти наименьшее множество точек такое, что каждому отрезку принадлежит хотя бы одна точка.
 *
 */

/**
 * Решение
 *
 * Возьмём все точки-концы отрезков (как левые, так и правые) и отсортируем их.
 * При этом для каждой точки сохраним вместе с ней номер отрезка, а также то, каким концом его она является (левым или правым).
 * Кроме того, отсортируем точки таким образом, что, если есть несколько точек с одной координатой, то сначала будут идти левые концы, и только потом - правые.
 * Заведём стек, в котором будут храниться номера отрезков, рассматриваемых в данный момент; изначально стек пуст.
 * Будем двигаться по точкам в отсортированном порядке. Если текущая точка - левый конец, то просто добавляем номер её отрезка в стек.
 * Если же она является правым концом, то проверяем, не был ли покрыт этот отрезок (для этого можно просто завести массив булевых переменных).
 * Если он уже был покрыт, то ничего не делаем и переходим к следующей точке (забегая вперёд, мы утверждаем, что в этом случае в стеке текущего отрезка уже нет).
 * Если же он ещё не был покрыт, то мы добавляем текущую точку в ответ, и теперь мы хотим отметить для всех текущих отрезков, что они становятся покрытыми.
 * Поскольку в стеке как раз хранятся номера непокрытых ещё отрезков, то будем доставать из стека по одному отрезку и отмечать,
 * что он уже покрыт, пока стек полностью не опустеет.
 * По окончании работы алгоритма все отрезки будут покрыты, и притом наименьшим числом точек (повторимся, здесь важно требование,
 * что при равенстве координат сначала идут левые концы, и только затем правые).
 *
 * Таким образом, весь алгоритм выполняется за O (N), не считая сортировки точек, а итоговая сложность алгоритма как раз равна O (N log N).
 */
public class SegmentsAndPoints4_1 {

  private List<Point> points;
  private Map<Integer, Segment> segments;

  public static void main(String[] args) {
    SegmentsAndPoints4_1 sp = new SegmentsAndPoints4_1();
    sp.init();
    sp.pointsCounter();
  }

  private void pointsCounter() {
    List<Integer> result = new ArrayList<>();
    Deque<Segment> stack = new ArrayDeque<>();
    int count = 0;
    Point p = null;
    for (int i = 0; i < points.size(); i++) {
      p = points.get(i);
      if ("l".equals(p.side))
        stack.push(segments.get(p.segNum));
      else {
        if (!segments.get(p.segNum).isCovered){
          count++;
          result.add(p.x);
          while (!stack.isEmpty()){
            Segment s = stack.pop();
            s.isCovered = true;
          }
        }
      }
    }

    System.out.println(count);
    System.out.println(result.stream()
        .map(String::valueOf)
        .collect(Collectors.joining(" ")));
  }

  private void init() {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int l, r;
    segments = new HashMap<>();
    points = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      l = in.nextInt();
      r = in.nextInt();
      Point left = new Point(l, "l", i);
      Point right = new Point(r, "r", i);
      points.add(left);
      points.add(right);
      segments.put(i, new Segment(left, right, i));
    }
    Collections.sort(points);
  }

  private class Segment {

    Point l;
    Point r;
    Integer num;
    boolean isCovered;

    public Segment(Point l, Point r, Integer num) {
      this.l = l;
      this.r = r;
      this.num = num;
      this.isCovered = false;
    }

    @Override
    public String toString() {
      return " |" + l + " " + r + "| ";
    }
  }

  private class Point implements Comparable<Point> {

    Integer x;
    String side;
    Integer segNum;

    public Point(Integer x, String side, Integer segNum) {
      this.x = x;
      this.side = side;
      this.segNum = segNum;
    }

    @Override
    public int compareTo(Point o) {
      int res = this.x.compareTo(o.x);
      if (res == 0) {
        return "l".equals(this.side) ? -1 : 1;
      }
      return res;
    }

    @Override
    public String toString() {
      return x + side;
    }
  }
}
