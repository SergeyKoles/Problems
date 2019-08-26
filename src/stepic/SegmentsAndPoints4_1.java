package stepic;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SegmentsAndPoints4_1 {

  private List<Point> points;
  private Map<Integer, Segment> segments;

  public static void main(String[] args) {
    SegmentsAndPoints4_1 sp = new SegmentsAndPoints4_1();
    sp.init();
    sp.pointsCounter();

    System.out.println(sp.segments.values().toString());
    System.out.println(sp.points.toString());
  }

  private void pointsCounter() {
    List<Integer> result = new ArrayList<>();
    Deque<Segment> stack = new ArrayDeque<>();
    int count = 0;
    Point p = null;
    for (int i = 0; i < points.size(); i++) {
      p = points.get(i);
      if (p.side.equals("l"))
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
    System.out.println(result.toString());
//    result.forEach(System.out::print);
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
        return this.side.equals("l") ? -1 : 1;
      }
      return res;
    }

    @Override
    public String toString() {
      return x + side;
    }
  }
}
