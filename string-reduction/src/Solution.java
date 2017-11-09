
import java.io.*;
import java.util.*;

public class Solution {

  public static void printOutput(String output) {

  }

  public static void checkStrings(String[] test_cases, int n) {
    for (int i = 0; i < n; i++) {
      System.out.println(test_cases[i]);
      char cur[] = test_cases[i].toCharArray();
      boolean same = true;

      int counts[] = new int[]{0, 0, 0};

      for (int j = 0; j < cur.length; j++) {
        /*
              if string does not consist of the same character break;
         */
        if (cur[0] != cur[j]) {
          same = false;
        }
        if (cur[j] == 'a'){
          counts[0]++;
        }else if(cur[j] == 'b'){
          counts[1]++;
        }else{
          counts[2]++;
        }
        
      }

      //if string consists of more than one char
      if (same) {
        System.out.println(cur.length);
      } else {
        boolean all_even = true;
        boolean all_odd = true;
        
        for (int c=0; c<counts.length; c++){
          if ( (counts[c]%2) == 1){
            all_even = false;
          }else{
            all_odd = false;
          }
        }
        
        if (!all_even || !all_odd) {
          System.out.println("1");
        } else {
          System.out.println("2");
        }
      }
    }
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    String test_cases[] = new String[n];
    int i = 0;
    for (i = 0; i < n; i++) {
      test_cases[i] = scan.next();
    }
    Solution.checkStrings(test_cases, n);
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
  }
}
