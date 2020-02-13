package stepic.baseDataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SearchTreeValidator {

  private static final String CORRECT = "CORRECT";
  private static final String INCORRECT = "INCORRECT";

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int n = Integer.parseInt(br.readLine());
      StringTokenizer st;
      Node[] tree = new Node[n];
      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        int key = Integer.parseInt(st.nextToken());
        int left = Integer.parseInt(st.nextToken());
        int right = Integer.parseInt(st.nextToken());
        if (tree[i] == null) {
          tree[i] = new Node(i, key, left, right, -1);
        } else {
          Node node = tree[i];
          node.key = key;
          node.left = left;
          node.right = right;
        }
        if (left != -1) {
          tree[left] = new Node(left, -1, -1, -1, i);
        }
        if (right != -1) {
          tree[right] = new Node(right, -1, -1, -1, i);
        }
      }
      if (isTreeValid(tree))
        System.out.println(CORRECT);
      else System.out.println(INCORRECT);
    } catch (IOException e) {
      System.out.println("-------- Oops!!! --------");
    }
  }

  private static boolean isTreeValid(Node[] tree) {

    if (tree.length == 0) return true;

    Node root = tree[0];

    boolean isValid = isTreeValid(tree, root);

    return isValid;
  }

  private static boolean isTreeValid(Node[] tree, Node v) {
    boolean isValid = true;
    if (v.left != -1) {
      isValid = isTreeValid(tree, tree[v.left]);
    }
    if (isValid) {
      if (!isNodeValid(tree, v)) return false;
      if (v.right != -1) {
        isValid = isTreeValid(tree, tree[v.right]);
      }
    }
    return isValid;
  }

  private static boolean isNodeValid(Node[] tree, Node v) {
    int nodeValue = v.key;
    Node parent;
    Node child = v;
    while (child.parent != -1) {
      parent = tree[child.parent];
      if (parent.left == child.index) {
        if (nodeValue < parent.key && child.key < parent.key) {
          child = parent;
        } else {
          return false;
        }
      } else {
        if (nodeValue > parent.key && child.key > parent.key) {
          child = parent;
        } else {
          return false;
        }
      }
    }
    return true;
  }


  private static class Node {
    private int index;
    private int key;
    private int left;
    private int right;
    private int parent;

    public Node(int index, int key, int left, int right, int parent) {
      this.index = index;
      this.key = key;
      this.left = left;
      this.right = right;
      this.parent = parent;
    }
  }
}
