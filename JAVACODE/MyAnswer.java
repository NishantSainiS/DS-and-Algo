import java.util.*;
import java.lang.*;
import java.io.*;
public class MyAnswer {
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
     
     public static void main(String[] args)throws IOException{
          FastScanner scan = new FastScanner();
          //SuperFastScanner scan = new SuperFastScanner();
          PrintWriter out = new PrintWriter(System.out);
          StringBuilder sb = new StringBuilder();
     
          int t = scan.nextInt();
          while (t-- > 0){

               sb.append(solve());
               sb.append("\n");
               
          }
          out.println(sb);
          out.flush();
     }
     public static int solve(){
          return 0;
     }

}
