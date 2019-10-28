package stepic.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * У вас есть примитивный калькулятор, который умеет выполнять всего три операции с текущим числом x: заменить x на 2x, 3x или x+1.
 * По данному целому числу 1<=n<=10^5 определите минимальное число операций k, необходимое, чтобы получить n из 1.
 * Выведите k и последовательность промежуточных чисел.
 *
 * Sample Input 1:
 *
 * 1
 * Sample Output 1:
 *
 * 0
 * 1
 * Sample Input 2:
 *
 * 5
 * Sample Output 2:
 *
 * 3
 * 1 2 4 5
 * Sample Input 3:
 *
 * 96234
 * Sample Output 3:
 *
 * 14
 * 1 3 9 10 11 22 66 198 594 1782 5346 16038 16039 32078 96234
 */
public class Calculator {
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int n = Integer.parseInt(br.readLine());
      List<Integer> seq = foundMinNumberOfMathOperation(n);
      System.out.println(seq.size());
      seq.forEach(r -> System.out.print(r + " "));
    } catch (IOException e) {
      System.out.println("-------- Oops!!! --------");
    }
  }

  private static List<Integer> foundMinNumberOfMathOperation(int n) {
    ArrayList<Integer> seq = new ArrayList<>();



    return seq;
  }
}
