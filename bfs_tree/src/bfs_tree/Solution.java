package bfs_tree;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  public static class Graph {

    private ArrayList<ArrayList<Integer>> nodes;
    int size;
    Queue<Integer> q;

    public Graph(int size) {
      this.size = size;
      this.nodes = new ArrayList<>(size);
      while(size-- > 0){
        this.nodes.add(new ArrayList<>());
      }
      this.q = new LinkedList<>();
    }
    
    public void debug(String message){
      //System.out.println(message);
    }

    public void addEdge(int first, int second) {
      this.debug("Adding " + first + " , " + second);
      this.nodes.get(first).add(second);
      this.nodes.get(second).add(first);
    }

    public int[] shortestReach(int startId) { // 0 indexed
      this.debug("size of input " + Integer.toString(this.size));
      this.debug("start " + startId);
      int[] visited = new int[size];
      q.add(startId);

      for (int i = 0; i < size; i++) {
        visited[i] = -1;
      }
      int cur = startId;
      visited[cur] = 0;

      while (q.isEmpty() == false) {
        cur = q.remove();
        ArrayList node = this.nodes.get(cur);
        Iterator neighbors = node.iterator();
        while (neighbors.hasNext()) {
          int cur_neighbor = (Integer) neighbors.next();
          if (visited[cur_neighbor] == -1) {
            visited[cur_neighbor] = visited[cur] + 6;
            q.add(cur_neighbor);
          }
        }
      }
      for (int i = 0; i < visited.length; i++) {
        this.debug(i + " is " + visited[i]);
      }
      return visited;
    }
  }

  public static void main(String[] args) {
    try{
    File test = new File("input.txt");
    Scanner scanner = new Scanner(new FileInputStream(test));
    //Scanner scanner = new Scanner(System.in);

    int queries = scanner.nextInt();

    for (int t = 0; t < queries; t++) {

      // Create a graph of size n where each edge weight is 6:
      Graph graph = new Graph(scanner.nextInt());
      int m = scanner.nextInt();

      // read and set edges
      for (int i = 0; i < m; i++) {
        int u = scanner.nextInt() - 1;
        int v = scanner.nextInt() - 1;

        // add each edge to the graph
        graph.addEdge(u, v);
      }

      // Find shortest reach from node s
      int startId = scanner.nextInt() - 1;
      int[] distances = graph.shortestReach(startId);

      for (int i = 0; i < distances.length; i++) {
        if (i != startId) {
          System.out.print(distances[i]);
          System.out.print(" ");
        }
      }
      System.out.println();
    }

    scanner.close();
    }catch(FileNotFoundException e){
      System.out.println(e.toString());
    }
  }
}
