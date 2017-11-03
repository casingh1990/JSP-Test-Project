import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int solve(int n, int[] s, int d, int m){
        // Complete this function
        int start=0;
        int num = 0;
        int temp_sum = 0;
        for (int i=0; i<n; i++){
            temp_sum += s[i];
            int cur_bar_count=((i - start)+1);
            //System.out.println("I " + i + "   Sum " + temp_sum + " start:" + start + " d" + d + " check " + cur_bar_count + " m " + m);
            if ( (cur_bar_count > m) || (temp_sum > d) ){
              temp_sum = temp_sum - s[start];
              start++;
              cur_bar_count=((i - start)+1);
            }
            //System.out.println("I " + i + "   Sum " + temp_sum + " start:" + start + " d" + d + " check " + cur_bar_count + " m " + m + "\n");
            if ((cur_bar_count == m) && (temp_sum == d)){
              //System.out.println("I " + i + "   Sum " + temp_sum + " start:" + start + " d" + d + " check " + cur_bar_count + " m " + m);
              for (int j=start; j<=i; j++){
                //System.out.print(s[j] + " ");
              }
              //System.out.println("\n");
                temp_sum = temp_sum - s[start];
                start++;
                num++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
        for(int s_i=0; s_i < n; s_i++){
            s[s_i] = in.nextInt();
        }
        int d = in.nextInt();
        int m = in.nextInt();
        
        /**
        31
2 2 2 1 3 2 2 3 3 1 4 1 3 2 2 1 2 2 4 2 2 3 5 3 4 3 2 1 4 5 4
10 4
**/
        /*n = 31;
        s = new int[] {2 ,2 ,2 ,1 ,3 ,2 ,2, 3, 3, 1, 4, 1, 3, 2, 2, 1, 2, 2, 4, 2, 2, 3, 5, 3, 4, 3, 2, 1, 4, 5, 4};
        d= 10;
        m=4;*/
        int result = solve(n, s, d, m);
        System.out.println(result);
    }
}