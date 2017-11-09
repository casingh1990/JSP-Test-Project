import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        char[] binary = Integer.toBinaryString(n).toCharArray();
        int start_max = -1;
        int end_max;
        int max = 0;
        int cur = 0;
        for(int i=0; i<binary.length; i++){
            if (binary[i] == '1'){
                cur++;
                if (start_max < 0){
                    start_max = i;
                }
            }
            else{
                cur = 0;
                start_max = -1;
            }
            if (cur > max){
                max = cur;
            }
        }
        System.out.println(max);
    }
}