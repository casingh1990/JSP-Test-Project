import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Solution {
    public static int numberNeeded(String first, String second) {
      
      char[] str1 = first.toCharArray();
      char[] str2 = second.toCharArray();
      
      ArrayList<Character> arr1 = new ArrayList<>(first.length());
      ArrayList<Character> arr2 = new ArrayList<>(second.length());
      
      ArrayList<Character> common_char1 = new ArrayList<>(second.length());
      ArrayList<Character> common_char2 = new ArrayList<>(first.length());
      
      for (int i=0; i<first.length(); i++){
        arr1.add(str1[i]);
      }
      for (int j=0; j<second.length(); j++){
        arr2.add(str2[j]);
      }
      
      
      
      return 0;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
