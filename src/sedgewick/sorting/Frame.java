package sedgewick.sorting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public abstract class Frame {

  static boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }

  static void exch(Comparable[] a, int i, int j) {
    Comparable t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  static void show(Comparable[] a) {
    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i]);
    }
    System.out.println();
  }

  static String[] initArray(String size) {
    String[] a = null;
    String fileName = "";
    switch (size) {
      case ("small"):
        fileName = "src.sedgewick.sorting.testData.small.txt";
        break;
      case ("middle"):
        fileName = "src.sedgewick.sorting.testData.small.txt";
        break;
      case ("large"):
        fileName = "src.sedgewick.sorting.testData.small.txt";
        break;
    }
    try (BufferedReader in = new BufferedReader(new FileReader(new File(fileName)))) {
      a = in.readLine().split("");
    } catch (IOException e) {
    }
    return a;
  }
}
