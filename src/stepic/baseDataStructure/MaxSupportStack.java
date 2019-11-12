package stepic.baseDataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class MaxSupportStack {
  private Stack<Integer> stack = new Stack<>();

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int q = Integer.parseInt(st.nextToken());
      MaxSupportStack maxSupportStack = new MaxSupportStack();
      for (int i = 0; i < q; i++) {
        st = new StringTokenizer(br.readLine());
        switch (st.toString()) {
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
    } catch (IOException e) {
      System.out.println("-------- Oops!!! --------");
    }
  }

  private void pop() {
    stack.pop();
  }

  private void push(int n) {
    stack.push(n);
  }

  private int max() {
    return 0;
  }
}
