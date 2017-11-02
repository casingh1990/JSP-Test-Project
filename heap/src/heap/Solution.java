package heap;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  public static LinkedList<Integer> list;
  public static Double median = 0.0;

  public static PriorityQueue<Integer> lower;
  public static PriorityQueue<Integer> upper;

  public Solution() {

  }

  public static void rebalance() {
    if (Math.abs(lower.size() - upper.size()) > 1) {
      if (lower.size() > upper.size()) {
        upper.add(lower.poll());
      } else {
        lower.add(upper.poll());
      }
    }
  }

  public static double find_the_running_median(int cur) {

    if (!lower.isEmpty() && cur <= lower.peek()) {
      lower.offer(cur);
    } else {
      upper.offer(cur);
    }

    rebalance();
    //System.out.println(lower.size() + " - " + upper.size());
    //System.out.println(lower.toString() + " ..... " + upper.toString());

    if (upper.isEmpty() && !lower.isEmpty()) {
      return lower.peek();
    }
    if (!upper.isEmpty() && lower.isEmpty()) {
      return upper.peek();
    }
    if (lower.size() > upper.size()){
      return lower.peek();
    }
    if (upper.size() > lower.size()){
      return upper.peek();
    }
    return (double)((lower.peek() + upper.peek()) / 2.0);
    //median = (double)((lower.size() == upper.size()) ? ((lower.peek() + upper.peek()) / 2.0) : upper.peek());
    //return median;
  }

  public static void findSolution(String[] args) {
    try {
      File file = new File("input.txt");
      Scanner in = new Scanner(new FileInputStream(file));
      File result_file = new File("result.txt");
      Scanner result = new Scanner(new FileInputStream(result_file));
      int n = in.nextInt();
      int[] a = new int[n];

      lower = new PriorityQueue<>(Comparator.reverseOrder());
      upper = new PriorityQueue<>();

      for (int a_i = 0; a_i < n; a_i++) {
        a[a_i] = in.nextInt();
        Double res = result.nextDouble();
        Double output = find_the_running_median(a[a_i]);
        if (!Objects.equals(res, output)){
          System.out.println(lower.toString() + " ..... " + upper.toString());
          System.out.println(output);
          break;
        }
      }
    } catch (FileNotFoundException E) {
      System.out.println(E.toString());
    }
  }
}
