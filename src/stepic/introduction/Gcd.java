package stepic.introduction;

/**
 * По данным двум числам 1≤a,b≤2⋅10^9 найдите их наибольший общий делитель.
 */
public class Gcd {

  public static void main(String[] args) {
    System.out.println(gcd(14159572, 63967072));
    System.out.println(gcd(0, 2));
    System.out.println(gcd(1, 1));
    System.out.println(gcd(3, 3));
  }

  private static int gcdRecursion(int a, int b) {
    if (a == 0) {
      return b;
    }
    if (b == 0) {
      return a;
    }
    if (a > b) {
      return gcd(a % b, b);
    } else {
      return gcd(a, b % a);
    }
  }

  private static int gcd(int a, int b) {
    while (true) {
      if (a == 0) {
        return b;
      }
      if (b == 0) {
        return a;
      }
      if (a > b) {
        a %= b;
      } else {
        b %= a;
      }
    }
  }
}
