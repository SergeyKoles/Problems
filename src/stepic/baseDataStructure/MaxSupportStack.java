package stepic.baseDataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class MaxSupportStack {
  private Stack<Integer> stack = new Stack<>();
  private Stack<Integer> auxiliary = new Stack<>();

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int n = Integer.parseInt(br.readLine());
      String[] q = new String[n];
      for (int i = 0; i < n; i++) {
        q[i] = br.readLine();
      }
      run(q, n);
    } catch (IOException e) {
      System.out.println("-------- Oops!!! --------");
    }
  }

  private static void run(String[] q, int n) {
    MaxSupportStack maxSupportStack = new MaxSupportStack();
    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(q[i]);

      switch (st.nextToken()) {
        case "pop":
          maxSupportStack.pop();
          break;
        case "push":
          maxSupportStack.push(Integer.parseInt(st.nextToken()));
          break;
        case "max":
          System.out.println(maxSupportStack.max());
          break;
      }
    }
  }

  private void pop() {
    stack.pop();
    auxiliary.pop();
  }

  private void push(int n) {
    stack.push(n);
    if (auxiliary.isEmpty()) {
      auxiliary.push(n);
    } else {
      int max = auxiliary.peek();
      if (n < max) auxiliary.push(max);
      else auxiliary.push(n);
    }
  }

  private int max() {
    return auxiliary.peek();
  }
}
