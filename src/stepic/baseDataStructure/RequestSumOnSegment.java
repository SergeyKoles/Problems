package stepic.baseDataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RequestSumOnSegment {

  public static final String NOT_FOUND = "Not found";
  public static final String FOUND = "Found";
  private static Node root;

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
        delete(value);
        break;
      case "?":
        find(value);
        break;
      case "s":
        break;
    }
  }

  private static void delete(String value) {
    int val = Integer.parseInt(value);
    Node d = findNode(val);
    if (d == null) return;

    Node nodeForSwap = d;

    if (d.left != null) {
      nodeForSwap = findMaxNode(d.left);
    } else if (d.right != null) {
      nodeForSwap = findMinNode(d.right);
    }

    Node parent = d.parent;
    if (nodeForSwap.val == d.val) {
      if (parent != null) {
        setParentSon(d.val, null, parent);
        balance(parent);
      } else {
        root = null;
      }
    } else {
      if (parent != null) {
        setParentSon(d.val, nodeForSwap, parent);
      }
      setParentSon(nodeForSwap.val, null, nodeForSwap.parent);
      nodeForSwap.right = d.right;
      nodeForSwap.left = d.left;
      nodeForSwap.parent = d.parent;

      if (nodeForSwap.left != null)
        nodeForSwap.left.parent = nodeForSwap;
      if (nodeForSwap.right != null)
        nodeForSwap.right.parent = nodeForSwap;

      balance(nodeForSwap);
    }
    d = null;
  }

  private static void find(String value) {
    int val = Integer.parseInt(value);

    if (findNode(val) == null)
      System.out.println(NOT_FOUND);
    else System.out.println(FOUND);
  }

  private static void add(String value) {
    int val = Integer.parseInt(value);
    if (root == null) {
      root = new Node(val, null);
    } else {
      Node node = createNode(val);
      balance(node.parent);
    }
  }

  // ==========================================

  private static Node createNode(int val) {
    Node node = root;
    while (val != node.val) {
      if (node.val > val) {
        if (node.left == null) {
          node.left = new Node(val, node);
        }
        node = node.left;
      } else {
        if (node.right == null) {
          node.right = new Node(val, node);
        }
        node = node.right;
      }
    }
    return node;
  }

  private static Node findNode(int val) {
    Node node = root;
    while (val != node.val) {
      if (node.val > val) {
        node = node.left;
      } else {
        node = node.right;
      }
      if (node == null) {
        return null;
      }
    }
    return node;
  }

  private static Node findMaxNode(Node nodeForSwarp) {
    while (nodeForSwarp.right != null) {
      nodeForSwarp = nodeForSwarp.right;
    }
    return nodeForSwarp;
  }

  private static Node findMinNode(Node nodeForSwarp) {
    while (nodeForSwarp.left != null) {
      nodeForSwarp = nodeForSwarp.left;
    }
    return nodeForSwarp;
  }

  private static void setParentSon(int val, Node son, Node parent) {
    if (parent.right != null && parent.right.val == val)
      parent.right = son;
    else parent.left = son;
  }

  private static void balance(Node n) {
    while (n != null) {
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
      if (n.parent == null)
        root = n;
      n = n.parent;
    }
  }

  private static Node leftRotation(Node n) {
    Node r = n.right;
    if (n.parent != null) {
      setParentSon(n.val, r, n.parent);
    }
    n.right = r.left;
    if (n.right != null)
      n.right.parent = n;
    r.left = n;
    r.parent = n.parent;
    n.parent = r;
    fixHeight(n);
    fixHeight(r);
    return r;
  }

  private static Node rightRotation(Node n) {
    Node l = n.left;
    if (n.parent != null) {
      setParentSon(n.val, l, n.parent);
    }
    n.left = l.right;
    if (n.left != null)
      n.left.parent = n;
    l.right = n;
    l.parent = n.parent;
    n.parent = l;
    fixHeight(n);
    fixHeight(l);
    return l;
  }

  private static void fixHeight(Node n) {
    int hl = height(n.left);
    int hr = height(n.right);
    n.h = ((hl > hr) ? hl : hr) + 1;
  }

  private static int height(Node n) {
    return n != null ? n.h : 0;
  }

  private static int bFactor(Node n) {
    return height(n.right) - height(n.left);
  }

  private static class Node {
    private int val;
    private int h;
    private Node parent;
    private Node left;
    private Node right;

    public Node(int val, Node parent) {
      this.val = val;
      this.parent = parent;
      this.h = 1;
    }

    @Override
    public String toString() {
      return "val=" + val +
              ", h=" + h;
    }
  }
}