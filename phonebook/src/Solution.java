//Complete this code or write your own from scratch
import java.util.*;
import java.io.*;

class Solution{
    
    private Hashtable<String, Integer> phonebook;
    
    public Solution(int n){
      this.phonebook = new Hashtable<>(n);
    }
    
    public void addEntry(String name, Integer number){
      this.phonebook.put(name, number);
    }
    
    public String getnumber(String name){
      //System.out.println(this.phonebook);
      //System.out.println("'" + name + "'");
      //System.out.println(this.phonebook.contains(name));
      if (this.phonebook.get(name) != null){
        return name + "=" + this.phonebook.get(name);
      }
      return "Not found";
    }
    
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Solution phonebook = new Solution(n);
        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
            phonebook.addEntry(name, phone);
        }
        while(in.hasNext()){
            String s = in.next();
            System.out.println(phonebook.getnumber(s));
        }
        in.close();
    }
}
