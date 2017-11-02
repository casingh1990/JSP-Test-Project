
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  public static int grid[][];
  public static int m;
  public static int n;
  static int regionCounter = 0;
  static int region[][];
  static int max_region = 0;
  //static Hashtable<Integer, Integer> region_size;

  public static int find_max_region2() {
    max_region = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        max_region = Math.max(max_region, check_region(i, j));
      }
    }
    return max_region;
  }

  public static int check_region(int i, int j) {
    
    if ((i < 0) || (j < 0) || (i >= n) || (j >= m)) {
      return 0;
    }
    if (grid[i][j] == 0) {
      return 0;
    }
    int count = grid[i][j]--;
    //check left
    count += check_region(i - 1, j);
    //check right
    count += check_region(i + 1, j);
    //check diagonal top left
    count += check_region(i - 1, j - 1);
    //check diagonal top right
    count += check_region(i + 1, j - 1);
    //check diagonal bottom left
    count += check_region(i - 1, j + 1);
    //check diagonal bottom right
    count += check_region(i + 1, j + 1);
    //check top
    count += check_region(i, j - 1);
    //check bottom
    count += check_region(i, j + 1);
    return count;
  }
  /*
  old solution --- first try
  public static int find_max_region(int n, int m) {
    region_size = new Hashtable<>();
    region = new int[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        region[i][j] = 0;
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {

        //check left
        check_cell(i, j, i - 1, j);
        //check right
        check_cell(i, j, i + 1, j);
        //check diagonal top left
        check_cell(i, j, i - 1, j - 1);
        //check diagonal top right
        check_cell(i, j, i + 1, j - 1);
        //check diagonal bottom left
        check_cell(i, j, i - 1, j + 1);
        //check diagonal bottom right
        check_cell(i, j, i + 1, j + 1);
        //check top
        check_cell(i, j, i, j - 1);
        //check bottom
        check_cell(i, j, i, j + 1);
      }
    }
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        System.out.print(region[i][j] + " ");
      }
      System.out.println();
    }

    Iterator itr = region_size.values().iterator();
    int i = 0;
    while (itr.hasNext()) {
      System.out.println(Integer.toString(i++) + " " + itr.next());
    }
    System.out.println(regionCounter);
    return max_region;
  }

  public static void mark_region(int cur_n, int cur_m, int check_n, int check_m) {
    int cur_region;
    int cur_size = 0;
    if ((region[cur_n][cur_m] == region[check_n][check_m]) && (region[cur_n][cur_m] > 0)) {
      //noting to do because both regions are already visited
      return;
    } else if (region[cur_n][cur_m] > 0) {
      cur_region = region[cur_n][cur_m];
      //if (region[check_n][check_m] > 0){
      //  cur_size = region_size.get(cur_region);
      //}
      region[check_n][check_m] = cur_region;
      cur_size += region_size.get(cur_region);
      region_size.put(cur_region, cur_size + 1);
    } else if (region[check_n][check_m] > 0) {
      cur_region = region[cur_n][cur_m];
      //if (region[check_n][check_m] > 0){
      //  cur_size = region_size.get(cur_region);
      //}
      region[cur_n][cur_m] = cur_region;
      cur_size += region_size.get(cur_region);
      region_size.put(cur_region, cur_size + 1);
    } else {
      regionCounter++;
      cur_region = regionCounter;
      region[cur_n][cur_m] = cur_region;
      region[check_n][check_m] = cur_region;
      region_size.put(cur_region, 2);
    }
    try {
      if (region_size.get(cur_region) > max_region) {
        max_region = region_size.get(cur_region);
      }
    } catch (Exception e) {
      System.out.println(e.toString());
    }
  }

  public static boolean check_cell(int cur_n, int cur_m, int check_n, int check_m) {
    if ((check_n >= 0) && (check_n < n) && (check_m >= 0) && (check_m < m)) {
      if ((grid[cur_n][cur_m] == 1) && (grid[check_n][check_m] == 1)) {
        mark_region(cur_n, cur_m, check_n, check_m);
        return true;
      }
    }
    return false;
  }*/

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    int grid[][] = new int[n][m];
    System.out.println();
    System.out.println();
    for (int grid_i = 0; grid_i < n; grid_i++) {
      for (int grid_j = 0; grid_j < m; grid_j++) {
        grid[grid_i][grid_j] = in.nextInt();
      }
    }
    Solution.m = m;
    Solution.n = n;
    Solution.grid = grid;
    System.out.println(find_max_region2());
  }
}
