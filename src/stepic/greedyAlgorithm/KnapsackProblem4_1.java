package stepic.greedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Первая строка содержит количество предметов 1<=n<=10^3 и вместимость рюкзака 0<=W<=2*10^6.
 * Каждая из следующих n строк задаёт стоимость 0<=ci<=2*10^6 и объём 0<wi<=2*10^6 предмета (n, W, ci, wi — целые числа).
 * Выведите максимальную стоимость частей предметов (от каждого предмета можно отделить любую часть, стоимость и объём при этом пропорционально уменьшатся),
 * помещающихся в данный рюкзак, с точностью не менее трёх знаков после запятой.
 */

/*
3
50
60
20
100
50
120
30
 */
public class KnapsackProblem4_1 {
  private List<Item> items = new ArrayList<>();
  private Double totalW;

  public static void main(String[] args) {
    KnapsackProblem4_1 kp = new KnapsackProblem4_1();
    kp.init();
    kp.stacker();
  }

  private void stacker() {
    double maxSum = 0;
    for (Item item : items) {
      if (item.wi <= totalW) {
        maxSum += item.ci;
        totalW -= item.wi;
      } else if (totalW != 0.0) {
        maxSum += (totalW * item.val);
        break;
      }
    }
    System.out.format("%.3f", maxSum);
  }

  private void init() {
    Scanner in = new Scanner(System.in);
    double n = in.nextDouble();
    totalW = in.nextDouble();
    for (int i = 0; i < n; i++) {
      double ci = in.nextInt();
      double wi = in.nextInt();
      items.add(new Item(ci, wi));
    }
    Collections.sort(items);
  }

  private class Item implements Comparable<Item> {

    Double ci;
    Double wi;
    Double val;

    public Item(Double ci, Double wi) {
      this.ci = ci;
      this.wi = wi;
      this.val = ci / wi;
    }

    @Override
    public int compareTo(Item o) {
      return o.val.compareTo(this.val);
    }

    @Override
    public String toString() {
      return "| ci: " + ci + " wi: " + wi + "| val: " + val;
    }
  }
}
