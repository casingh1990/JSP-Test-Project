import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    
    static String solve(int year){
        // Complete this function
        String month = "09";
        String day = "13";
        
        //int month_days[] = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        if (year == 1918){
            day = "26";
            month = "09";
        }
        else if (year < 1918){
          if ((year%4 == 0)){
            day = "12";
            month = "09";
          }
        }
        else{
          //leap year condition
          if ((year%4 == 0) && ((year%100 != 0) || (year%400 == 0))){
            day = "12";
            month = "09";
          }
        } 
        return day + "." + month + "." + year;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        String result = solve(year);
        System.out.println(result);
    }
}