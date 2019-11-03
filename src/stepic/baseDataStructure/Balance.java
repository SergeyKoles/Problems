package stepic.baseDataStructure;


import java.util.LinkedList;
import java.util.Scanner;

/**
 * Расстановка скобок в коде
 * Sample Input 1:
 * <p>
 * ([](){([])})
 * Sample Output 1:
 * <p>
 * Success
 * Sample Input 2:
 * <p>
 * ()[]}
 * Sample Output 2:
 * <p>
 * 5
 * Sample Input 3:
 * <p>
 * {{[()]]
 * Sample Output 3:
 * <p>
 * 7
 */
public class Balance {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println(isBalanced(sc.next()));
  }

  private static String isBalanced(String str) {
    char or = 40; // "("
    char os = 91; // "["
    char ob = 123; // "{"
    char cr = 41; // ")"
    char cs = 93; // "]"
    char cb = 125; // "}"
    LinkedList<Bracket> stack = new LinkedList<>();

    char c;
    Bracket b;
    for (int i = 0; i < str.length(); i++) {
      c = str.charAt(i);
      if (or == c || os == c || ob == c || cr == c || cs == c || cb == c) {
        if (or == c || os == c || ob == c) {
          stack.push(new Bracket(c, i));
        } else if (!stack.isEmpty()) {
          b = stack.peek();
          if (or == b.c && c != cr) return ++i + "";
          if (os == b.c && c != cs) return ++i + "";
          if (ob == b.c && c != cb) return ++i + "";
          stack.pop();
        } else {
          return ++i + "";
        }
      }
    }
    if (stack.isEmpty()) return "Success";
    return ++stack.getFirst().index + "";
  }

  private static class Bracket {
    private char c;
    private int index;

    private Bracket(char c, int index) {
      this.c = c;
      this.index = index;
    }
  }
}
