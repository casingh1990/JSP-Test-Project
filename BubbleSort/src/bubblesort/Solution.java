/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubblesort;

import java.util.Scanner;

/**
 *
 * @author Amit
 */
public class Solution {

  public long bubble_sort(int a[], int n) {
    int temp;
    long swap_counter = 0;
    for (int i = 0; i < n; i++) {
      // Track number of elements swapped during a single array traversal
      int numberOfSwaps = 0;

      for (int j = 0; j < n - 1; j++) {
        // Swap adjacent elements if they are in decreasing order
        if (a[j] > a[j + 1]) {
          temp = a[j];
          a[j] = a[j + 1];
          a[j + 1] = temp;
          numberOfSwaps++;
        }
      }
      swap_counter += numberOfSwaps;
      // If no elements were swapped during a traversal, array is sorted
      if (numberOfSwaps == 0) {
        break;
      }

    }
    return swap_counter;
  }

  public static void main(String args[]){
    Scanner scan = new Scanner(System.in);
    int num = scan.nextInt();
    int[] a = new int[num];
    for (int i=0; i<num; i++){
      a[i] = scan.nextInt();
    }
    
    Solution sol = new Solution();
    
    long num_swap = sol.bubble_sort(a, num);
    
    System.out.println("Array is sorted in " + num_swap + " swaps.");
    System.out.println("First Element: " + a[0]);
    System.out.println("Last Element: " + a[num-1]);
  }
  
}
