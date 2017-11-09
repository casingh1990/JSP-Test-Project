
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  /**
   * maximum row in matrix
   */ 
  private int i_max;
  /**
   * maximum column in matrix
   */
  private int j_max;
  /**
   * Matrix being considered
   */
  public int[][] matrix;

  /**
   * Constructor for class
   * @param i max row
   * @param j max column
   */
  public Solution(int i, int j) {
    this.i_max = i;
    this.j_max = j;
  }

  /**
   * Private helper function
   * @param i
   * @param j
   * @return 
   */
  private int getHourGlass(int i, int j) {
    if (((i > 0) && (i < i_max)) && ( (j>0) && (j<j_max) )){
      int sum = this.matrix[i][j];
      //top left
      sum += this.matrix[i-1][j-1];
      //top middle
      sum += this.matrix[i-1][j];
      //top right
      sum += this.matrix[i-1][j+1];
      //bottom left
      sum += this.matrix[i+1][j-1];
      //bottom middle
      sum += this.matrix[i+1][j];
      //bottom right
      sum += this.matrix[i+1][j+1];
      return sum;
    }
    return 0;
  }

  /**
   * find the largest hourglass
   * @return Integer
   */
  public int getMaxHourGlass() {
    int max = Integer.MIN_VALUE;
    for (int i=1; i<(this.i_max-1); i++){
      for (int j=1; j<(this.j_max-1); j++){
        max = Math.max(max, this.getHourGlass(i, j));
        System.out.println(i + " " + j + " == " + this.matrix[i][j] + " sums " + this.getHourGlass(i, j));
      }
    }
    return max;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int arr[][] = new int[6][6];
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 6; j++) {
        arr[i][j] = in.nextInt();
      }
    }
    Solution sol = new Solution(6, 6);
    sol.matrix = arr;
    System.out.println(sol.getMaxHourGlass());
  }
}
