
import java.io.*;
import java.util.*;

public class Solution {

  public String cases[];

  public Solution(String cases[]) {
    this.cases = cases;
  }

  public void find_odd_even_substrings() {
    for (String cur : this.cases) {
      String odd = "";
      String even = "";
      char[] chars = cur.toCharArray();
      
      for (int i=0; i<chars.length; i++){
        if ((i%2)==0){
          even += Character.toString(chars[i]);
        }else{
          odd += Character.toString(chars[i]);
        }
      }//end for char
      
      //printing the results
      System.out.println(even + " " + odd);
      
    }//end foreach string
  }

  public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    String[] cases = new String[n];
    for (int i = 0; i < n; i++) {
      cases[i] = scan.next();
    }
    new Solution(cases).find_odd_even_substrings();;
  }
}
