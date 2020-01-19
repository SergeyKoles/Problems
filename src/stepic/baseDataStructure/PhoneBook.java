package stepic.baseDataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PhoneBook {

  private static final String ADD = "add";
  private static final String DEL = "del";
  private static final String NOT_FOUND = "not found";

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      String[] phoneBook = new String[10_000_000];
      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        String request = st.nextToken();
        int number = Integer.parseInt(st.nextToken());
        if (request.equals(ADD)) {
          String name = st.nextToken();
          phoneBook[number] = name;
        } else if (request.equals(DEL)) {
          phoneBook[number] = null;
        } else {
          if (phoneBook[number] == null) {
            System.out.println(NOT_FOUND);
            continue;
          }
          System.out.println(phoneBook[number]);
        }
      }

    } catch (IOException e) {
      System.out.println("-------- Oops!!! --------");
    }
  }
}
