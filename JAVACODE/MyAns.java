package JAVACODE;

import java.util.*;
//import java.lang.*;
import java.io.*;
public class MyAns {
     static class FastScanner{ //10^5 -- .15 sec && 4*10^6 ---> .86 sec

          BufferedReader br;
          StringTokenizer st;
          
          public FastScanner(){
               br = new BufferedReader(new InputStreamReader(System.in));
          }
          public String next(){
               while (st == null || !st.hasMoreElements()){
               try{
                    st = new StringTokenizer(br.readLine());
               }catch (IOException  e){
                    e.printStackTrace();
               }
               }
               return st.nextToken();
          }
          public int nextInt(){
               return Integer.parseInt(next());
          }
          public long nextLong(){
               return Long.parseLong(next());
          }
          public double nextDouble(){
               return Double.parseDouble(next());
          }
          public String nextLine(){
               String str = "";
               try{
                    str = br.readLine();
               }catch (IOException e){
                    e.printStackTrace();
               }
               return str;
          }
          public int[] nextIntArray(int n){
               int arr[] = new int[n];
               for(int i = 0;i<n;i++){
                    arr[i] = nextInt();
               }
               return arr;
          }
          public long[] nextLongArray(int n){
               long arr[] = new long[n];
               for(int i = 0;i<n;i++){
                    arr[i] = nextLong();
               }
               return arr;
          }
          public double[] nextDoubleArray(int n){
               double arr[] = new double[n];
               for(int i = 0;i<n;i++){
                    arr[i] = nextDouble();
               }
               return arr;
          }
          public String[] nextStringArray(int n){
               String arr[] = new String[n];
               for(int i = 0;i<n;i++){
                    arr[i] = next();
               }
               return arr;
          }
    }
     static int oddleaf;
     public static void main(String[] args)throws IOException{
          FastScanner scan = new FastScanner();
          //SuperFastScanner scan = new SuperFastScanner();
          PrintWriter out = new PrintWriter(System.out);
          StringBuilder sb = new StringBuilder();
     
          int t = scan.nextInt();
          while (t-- > 0){
               int n = scan.nextInt();
               int q = scan.nextInt();
               ArrayList<Integer>[] adj = new ArrayList[n+1];
               for(int i = 0;i<=n;i++){
                    adj[i] = new ArrayList<>();
               }
               for(int i =1;i<n;i++){
                    int u = scan.nextInt();
                    int v = scan.nextInt();
                    adj[u].add(v);
                    adj[v].add(u);
               }
               oddleaf = 0;
               ArrayList<Integer> levels = solve(adj,n);
               
               int black = 0,white=0;
               int cost = 0,value = 0;
               boolean odd = true;
               for(int l : levels){
                    if(odd){
                         cost+=l;
                         black+=l;
                    }else{
                         white+=l;
                    }
                    odd = odd ? false : true;
               }
               // System.out.println(black);
               // System.out.println(white);
               // System.out.println(oddleaf);
               if(q==1){
                    value = Math.abs(black-white);
                    black-=oddleaf;
                    white+=oddleaf;
                    value = Math.max(value,Math.abs(black-white));
               }else{
                    value = Math.abs(black-white);
               }
               // System.out.println(black);
               // System.out.println(white);
               // System.out.println();
               sb.append(value);
               
               sb.append("\n");
               
          }
          out.println(sb);
          out.flush();
     }
     public static ArrayList<Integer> solve(ArrayList<Integer>[] adj,int n){
          ArrayList<Integer> ans = new ArrayList<>();
          ArrayDeque<Integer> q = new ArrayDeque<>();
          boolean visited[] = new boolean[n+1];
          boolean odd = true;
          q.add(1);
          visited[1] = true;
          while(!q.isEmpty()){
               int l = q.size();
               ans.add(l);
               for(int i = 0;i<l;i++){
                    int par = q.poll();
                    if(adj[par].size()==1 && odd){
                         oddleaf++;
                    }
                    for(int child : adj[par]){
                         if(visited[child]!=true){
                              q.add(child);
                              visited[child] = true;
                         }
                              
                    }    
               }
               odd = odd ? false : true;
               
          }
          // for(int val : ans){
          //      System.out.print(val + " ");
          // }
          // System.out.println(oddleaf);
          return ans;
     }

}
