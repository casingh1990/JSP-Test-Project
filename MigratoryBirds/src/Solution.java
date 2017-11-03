import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[] type = new int[]{0,0,0,0,0};
    static int max = 0;
    
    static void addBirdToType(int type){
      type--;
      Solution.type[type]++;
      if (Solution.type[type] > Solution.type[max]){
        max = type;
      }else if ((max != type) && (Solution.type[type] == Solution.type[max])){
        if (max > type){
          max = type;
        }
      }
    }
    
    static int migratoryBirds(int n, int[] ar) {
        // Complete this function
        for (int i=0; i<n; i++){
          addBirdToType(ar[i]);
        }
        return (max+1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = migratoryBirds(n, ar);
        System.out.println(result);
    }
}
