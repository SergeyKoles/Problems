package stepic.baseDataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TreeTraversal {

  private static Node[] tree;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int n = Integer.parseInt(br.readLine());
      StringTokenizer st;
      tree = new Node[n];
      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        int key = Integer.parseInt(st.nextToken());
        int left = Integer.parseInt(st.nextToken());
        int right = Integer.parseInt(st.nextToken());
        tree[i] = new Node(key, left, right);
      }
      printInOrder(tree);
      printPreOrder(tree);
      printPostOrder(tree);
    } catch (IOException e) {
      System.out.println("-------- Oops!!! --------");
    }
  }

  private static void printInOrder(Node[] tree) {
    System.out.println(inOrder(tree[0], new StringBuilder()).toString());
  }

  private static StringBuilder inOrder(Node v, StringBuilder sb) {
    if (v.left != -1) {
      inOrder(tree[v.left], sb);
    }
    sb.append(v.key).append(" ");
    if (v.right != -1) {
      inOrder(tree[v.right], sb);
    }
    return sb;
  }

  private static void printPreOrder(Node[] tree) {
    System.out.println(preOrder(tree[0], new StringBuilder()).toString());
  }

  private static StringBuilder preOrder(Node v, StringBuilder sb) {
    sb.append(v.key).append(" ");
    if (v.left != -1) {
      preOrder(tree[v.left], sb);
    }
    if (v.right != -1) {
      preOrder(tree[v.right], sb);
    }
    return sb;
  }

  private static void printPostOrder(Node[] tree) {
    System.out.println(postOrder(tree[0], new StringBuilder()).toString());
  }

  private static StringBuilder postOrder(Node v, StringBuilder sb) {
    if (v.left != -1) {
      postOrder(tree[v.left], sb);
    }
    if (v.right != -1) {
      postOrder(tree[v.right], sb);
    }
    sb.append(v.key).append(" ");
    return sb;
  }

  private static class Node {
    private int key;
    private int left;
    private int right;

    public Node(int key, int left, int right) {
      this.key = key;
      this.left = left;
      this.right = right;
    }
  }
}
