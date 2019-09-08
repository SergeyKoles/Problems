package sedgewick;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

public class HuffmanCompression {

  public static void main(String[] args) {
    compress();
  }

  private static int R = 256;

  public static void compress() {
    Scanner in = new Scanner(System.in);
    String s = in.next();

    char[] input = s.toCharArray();

    // Tabulate frequency count
    int freq[] = new int[R];
    for (int i = 0; i < input.length; i++) {
      freq[input[i]]++;
    }
    // Build Huffman code trie
    Node root = buildTrie(freq);
    Map<Character, String> dic = new TreeMap<>();
    String[] st = new String[R];
    if (!root.isLeaf()) {
      buildCode(st, root, "");
      dic = writeTrie(input, st);
    }else {
      st[root.ch] = "0";
      dic.put(input[0], "0");
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < input.length; i++) {
      sb.append(st[input[i]]);
    }
    System.out.println(dic.size() + " " + sb.length());
    dic.forEach((key, value) -> System.out.println(key + ": " + value));
    System.out.println(sb.toString());
  }

  private static Map<Character, String> writeTrie(char[] input, String[] st) {
    Map<Character, String> dic = new TreeMap<>();
    for (int i = 0; i < input.length; i++) {
      dic.putIfAbsent(input[i], st[input[i]]);
    }
    return dic;
  }

  private static Node buildTrie(int[] freq) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    for (char c = 0; c < R; c++) {
      if (freq[c] > 0) {
        pq.add(new Node(c, freq[c], null, null));
      }
    }
    while (pq.size() > 1) {
      Node x = pq.poll();
      Node y = pq.poll();
      Node parent = new Node('\0', x.freq + y.freq, x, y);
      pq.add(parent);
    }
    return pq.poll();
  }

  private static void buildCode(String[] st, Node x, String s) {
    if (x.isLeaf()) {
      st[x.ch] = s;
      return;
    }
    buildCode(st, x.left, s + '0');
    buildCode(st, x.right, s + '1');
  }

  private static class Node implements Comparable<Node> {

    private char ch;
    private int freq;
    private final Node left, right;

    Node(char ch, int freq, Node left, Node right) {
      this.ch = ch;
      this.freq = freq;
      this.left = left;
      this.right = right;
    }

    public boolean isLeaf() {
      return left == null && right == null;
    }

    @Override
    public int compareTo(Node o) {
      return this.freq - o.freq;
    }
  }
}
