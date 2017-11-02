/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  public Stack<Character> stack;
  public char[] input;
  public char[] start_chrs = {'{', '(', '['};
  public char[] end_chrs = {'}', ')', ']'};

  public Solution(String Expression) {
    this.stack = new Stack<>();
    this.input = Expression.toCharArray();
  }

  public boolean checkIFBalanced() {
    boolean ret = true;
    for (char token : input) {
      ret = ret & checkIFBalancedHelper(token);
    }
    /**
     * If stack is empty then we must declare false
     */
    if (this.stack.size() > 0){
      ret = false;
    }
    return ret;
  }

  public boolean checkIFBalancedHelper(char token) {
    if (new String(start_chrs).contains(new Character(token).toString())) {
      this.stack.push((Character) token);
      return true;
    } else {
      try {
        char top = (char) this.stack.pop();
        
        char matched = matched_token(top);
        if (token == matched_token(top)) {
          return true;
        }
      } catch (Exception E) {
        return false;
      }
    }
    return false;
  }

  public char matched_token(char token) {
    if (token == '(') {
      return ')';
    }
    if (token == '{') {
      return '}';
    }
    if (token == '[') {
      return ']';
    }
    return 'n';
  }

  public static boolean isBalanced(String expression) {
    Solution sol = new Solution(expression);
    return sol.checkIFBalanced();
  }

  public static void main(String[] args) {
    
    System.out.println("Working Directory = " +
              System.getProperty("user.dir"));
    FileInputStream input;
    try {
      File file = new File("input.txt");
      input = new FileInputStream(file);
      Scanner in = new Scanner(input);
      int t = in.nextInt();

      for (int a0 = 0; a0 < t; a0++) {
        String expression = in.next();
        if (a0 == 8){
          System.out.println((isBalanced(expression)) ? "YES" : "NO");
        }
      }
    } catch (FileNotFoundException E) {
      System.out.println(E.toString());
    }

  }
}
