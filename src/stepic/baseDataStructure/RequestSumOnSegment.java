package stepic.baseDataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RequestSumOnSegment {

  private static Node tree;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int n = Integer.parseInt(br.readLine());
      StringTokenizer st;
      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        String key = st.nextToken();
        String value = st.nextToken();
        process(key, value);
      }
      print(tree);
      System.out.println("************");
    } catch (IOException e) {
      System.out.println("-------- Oops!!! --------");
    }
  }

  private static void process(String key, String value) {
    switch (key) {
      case "+":
        add(value);
        break;
      case "-":
        break;
      case "?":
        break;
      case "s":
        break;
    }
  }

  private static void add(String value) {
    int key = Integer.parseInt(value);
    if (tree == null) {
      tree = new Node(key, null);
    } else {
      Node node = createNode(key);
      if (node.left == null && node.right == null) {
//        fixHeight(node);
        balance(node.parent);
      }
    }
  }

  private static Node createNode(int key) {
    Node node = tree;
    while (key != node.val) {
      if (node.val > key) {
        if (node.left == null) {
          node.left = new Node(key, node);
        }
        node = node.left;
      } else {
        if (node.right == null) {
          node.right = new Node(key, node);
        }
        node = node.right;
      }
    }
    return node;
  }


  private static void balance(Node n) {
    if (n == null) return;
    fixHeight(n);
    int balance = bFactor(n);
    if (balance == 2) {
      if (bFactor(n.right) < 0)
        n.right = rightRotation(n.right);
      n = leftRotation(n);
    } else if (balance == -2) {
      if (bFactor(n.left) > 0)
        n.left = leftRotation(n.left);
      n = rightRotation(n);
    }
    balance(n.parent);
  }

  private static void fixHeight(Node n) {
    int hl = height(n.left);
    int hr = height(n.right);
    n.h = ((hl > hr) ? hl : hr) + 1;
  }

  private static Node leftRotation(Node n) {
    Node r = n.right;
    n.right = r.left;
    r.left = n;
    fixHeight(n);
    fixHeight(r);
    return r;
  }

  private static Node rightRotation(Node n) {
    Node l = n.left;
    n.left = l.right;
    l.right = n;
    fixHeight(n);
    fixHeight(l);
    return l;
  }


  private static int height(Node n) {
    return n != null ? n.h : 0;
  }

  private static int bFactor(Node n){
    return height(n.right) - height(n.left);
  }


  private static void print(Node node, int level) {
    if (node != null) {
      print(node.right, level + 1);
      for (int i = 0; i < level; i++) {
        System.out.print("\t");
      }
//            System.out.println(node.key + "->" + node.key+" h="+node.h+" balance="+node.balance);
      System.out.println(node.val + "->" + node.val + " h=" + node.h);
      print(node.left, level + 1);
    }
  }

  private static void print(Node root) {
    print(root, 0);
  }

  private static class Node {
    private int val;
    private int h;
    private int balance;
    private Node parent;
    private Node left;
    private Node right;

    public Node(int val, Node parent) {
      this.val = val;
      this.parent = parent;
      this.h = 1;
      this.balance = 0;
    }

    public Node(int val, Node left, Node right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }

    private static void print() {

    }
  }
}
