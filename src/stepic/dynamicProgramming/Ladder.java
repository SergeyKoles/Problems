package stepic.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Даны число 1<=n<=10^2 ступенек лестницы и целые числа -10^4<=a1,…,an<=10^4, которыми помечены ступеньки.
 * Найдите максимальную сумму, которую можно получить, идя по лестнице снизу вверх (от нулевой до n-й ступеньки),
 * каждый раз поднимаясь на одну или две ступеньки.
 * <p>
 * Sample Input 1:
 * <p>
 * 2
 * 1 2
 * Sample Output 1:
 * <p>
 * 3
 * Sample Input 2:
 * <p>
 * 2
 * 2 -1
 * Sample Output 2:
 * <p>
 * 1
 * Sample Input 3:
 * <p>
 * 3
 * -1 2 1
 * Sample Output 3:
 * <p>
 * 3
 */
public class Ladder {
  private static int[] A;
  private static int n;
  private static int sum;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      A = new int[n];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
        A[i] = Integer.parseInt(st.nextToken());
      }
//      climbLadder(A);
//      climbLadder2(A);
      climbLadder3(A);
    } catch (IOException e) {
      System.out.println("-------- Oops!!! --------");
    }
  }

  private static void climbLadder3(int[] A) {
    int i = 0;
    sum += A[--n];
    while (i++ < n) {
      if (A[i] >= 0)
        sum += A[i];
      else {
        i = max(i, i + 1, i + 2, i + 3);
//        sum += A[i];
      }
    }
    System.out.println(sum);
  }

  private static void climbLadder2(int[] A) {
    int i = 2;
    sum += A[--n];
    while (i < n) {
      if (A[i - 2] < 0 && A[i - 1] < 0) {
        if (A[i - 2] + A[i] > A[i - 1] + A[i + 1]) {
          if (A[i - 2] > A[i - 1]) {
            sum += A[i - 2];
            i++;
          } else {
            sum += A[i - 1];
            i += 2;
          }
        } else {
          sum += A[i - 1];
          i += 2;
        }
      } else if (A[i - 2] > 0) {
        sum += A[i - 2];
        i++;
      } else if (A[i - 1] > 0) {
        sum += A[i - 1];
        i += 2;
      }
    }
    System.out.println(sum);
  }

  private static void climbLadder(int[] A) {
    int i = 0;
    sum += A[--n];
    while (i < n) {
      if (i + 1 == n) {
        if (A[i] > 0) {
          sum += A[i];
          break;
        }
        break;
      }
      if (A[i] >= 0) {
        sum += A[i++];
      } else {
        i = max(i, i + 1, i + 2, i + 3);
        sum += A[i++];
      }
    }
    System.out.println(sum);
  }

  private static int max(int i1, int i2) {
    if (i2 > n - 1) {
      if (A[i1] > 0) sum += A[i1];
      return i1;
    }
    if (A[i1] > A[i2]) {
      sum += A[i1];
      return i1;
    } else {
      sum += A[i2];
      return i2;
    }
  }

  private static int max(int i1, int i2, int i3) {
    if (i3 > n - 1)
      return max(i1, i2);
    if ((A[i1] + A[i3]) > A[i2]) {
      sum += A[i1];
      return i3;
    } else {
      sum += A[i2];
      return i2;
    }
  }

  private static int max(int i1, int i2, int i3, int i4) {
    if (i4 > n - 1) return max(i1, i2, i3);

    if (A[i2] > 0) {
      sum += A[i2];
      return i2;
    }
    if (A[i3] > 0) {
      sum += A[max(i1, i2)];
      sum += A[i3];
      return i3;
    }
    if (A[i4] > 0) {
      sum += A[max(i1, i2, i3)];
      sum += A[i4];
      return i4;
    }

    int st1 = max(i1, i2);
    int st2 = max(i3, i4);
    if (st1 + 2 >= st2) {
      sum += A[st1];
      sum += A[st2];
      return st2;
    } else if (A[i1] + A[i3] > A[i2] + A[i4]) {
      sum += A[st1];
      sum += A[--st2];
      return st1;
    } else {
      sum += A[++st1];
      sum += A[st2];
      return st1;
    }
  }
}
/*
7
1 1 -2 -4 -6 2 2
(2)
5
-64 -16 -13 -9 -48
(-73)
5
-2 -16 -13 -9 -48
(-63)
8
-60 -37 -22 -14 -7 -4 -2 -1
(-56)
7
-7 -6 -5 -4 -3 -2 -1
(-13)
 */