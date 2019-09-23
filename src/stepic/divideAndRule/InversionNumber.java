package stepic.divideAndRule;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://ru.stackoverflow.com/questions/375825/Разделяй-и-властвуй-подсчет-количества-инверсий-в-массиве/375841#375841
 * <p>
 * Первая строка содержит число 1<=n<=10^5, вторая — массив A[1…n], содержащий натуральные числа, не превосходящие 10^9.
 * Необходимо посчитать число пар индексов 1<=i<j<=n, для которых A[i]>A[j].
 * (Такая пара элементов называется инверсией массива.
 * Количество инверсий в массиве является в некотором смысле его мерой неупорядоченности: например,
 * в упорядоченном по неубыванию массиве инверсий нет вообще, а в массиве,
 * упорядоченном по убыванию, инверсию образуют каждые два элемента.)
 * <p>
 * Sample Input:
 * 5
 * 2 3 9 2 9
 * Sample Output:
 * 2
 */
public class InversionNumber {
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

    } catch (IOException e) {
      System.out.println("-------- Oops!!! --------");
    }
  }

  public static long inversionCounter(int[] A) {
    long counter = 0;

    return counter;
  }

}
