package stepic.introduction;

import java.util.Scanner;

/**
 * Даны целые числа 1≤n≤10^18 и 2≤m≤10^5, необходимо найти остаток от деления n-го числа Фибоначчи
 * на m.
 *
 *
 * Создать массив для записи остатков от деления n-го числа Фибоначчи на m Определяем период ПИзано
 * Вычислить индекс в массиве с нужным остатком n % period Profit!!!
 */


public class PizanoPeriod {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    long n = in.nextLong();
    int m = in.nextInt();
    long[] pizano = new long[m * 6];
    if (n <= 1) {
      System.out.println(n % m);
      return;
    }
    pizano[0] = 0;
    pizano[1] = 1;
    int period = -1;
    for (int i = 2; i < pizano.length - 1; i++) {
      pizano[i] = (pizano[i - 1] + pizano[i - 2]) % m;
      period++;
      if (i > 2 && pizano[i - 1] == pizano[i] && pizano[i] == 1) {
        break;
      }
    }
    long index = n % period;
    System.out.println(pizano[(int) index]);
  }
}
