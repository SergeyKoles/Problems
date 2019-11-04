package stepic.baseDataStructure;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TreeHeight {
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int n = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      String[] A = new String[n];
      for (int i = 0; i < n; i++) {
        A[i] = st.nextToken();
      }
      System.out.println(new TreeHeight().run(A));
    } catch (IOException e) {
      System.out.println("-------- Oops!!! --------");
    }
  }

  private int run(String[] A) {
    Node root = null;
    Map<String, Node> nodes = new HashMap<>();
    for (int i = 0; i < A.length; i++) {
      if (nodes.containsKey(i + "")) {
        Node c = nodes.get(i + "");
        if (nodes.containsKey(A[i])) {
          Node p = nodes.get(A[i]);
          p.children.add(c);
          int dif = c.height - p.height;
          if (dif >= 0) heightsRecalculation(p, dif + 1);
        } else {
          Node p = new Node(A[i]);
          p.height = c.height + 1;
          p.children.add(c);
          nodes.put(p.value,p);
          if (A[i].equals("-1")) root = p;
        }
      } else {
        Node c = new Node(i + "");
        c.height = 1;
        nodes.put(i + "", c);
        if (nodes.containsKey(A[i])) {
          Node parent = nodes.get(A[i]);
          parent.children.add(c);
          c.parent = parent;
          if (parent.height == 1) {
            parent.height =2;
          }
        } else {
          Node p = new Node(A[i]);
          p.height = 2;
          c.children.add(c);
          nodes.put(A[i], p);
          if (A[i].equals("-1")) root = p;
        }
      }
    }
    return new ArrayList<>(root.children).get(0).height;
  }

  private void heightsRecalculation(Node n, int v) {
    n.height += v;
    int h = n.height;
    if (n.parent == null) return;

    int dif = h - n.parent.height;
    if (dif >= 0)
      heightsRecalculation(n.parent, dif + 1);
  }

  private class Node {
    private String value;
    private Node parent = null;
    private HashSet<Node> children = new HashSet<>();
    private int height = 1;

    public Node(String value) {
      this.value = value;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Node node = (Node) o;
      return value == node.value;
    }

    @Override
    public int hashCode() {
      return Objects.hash(value);
    }
  }
}
