package JAVACODE;

import java.util.*;
import java.io.*;

class SolveNss{
     public static void main(String[] args)throws IOException{
          FastScanner scan = new FastScanner();
          //SuperFastScanner scan = new SuperFastScanner();
          PrintWriter out = new PrintWriter(System.out);
          StringBuilder result = new StringBuilder();
     
          int t = scan.nextInt();
          while (t-- > 0){

               result.append(solve());
               result.append("\n");
               
          }
          out.println(result);
          out.flush();
     }
     public static int solve(){
          return 0;
     }


     static class DSU {
          int[] parent;
          int[] rank;
          public DSU(int n){
               parent = new int[n+1];
               rank = new int[n+1];
               for(int i = 1;i<=n;i++){
                    parent[i] = i;
                    rank[i] = 0;
               }
          }
          
          public int find(int node){
               if(node == parent[node]){
                    return node;
               }
              return parent[node] = find(parent[node]);
          }
          public void Union(int u,int v){
              u = find(u);
              v = find(v);
      
              if(rank[u] < rank[v]){
                  parent[u] = v;
              }else if(rank[u] > rank[v]){
                  parent[v] = u;
              }else{
                  parent[v] = u;
                  rank[u]++;
              }
          }
     }

     static class BIT {
          int bit[]; // 1 index based;
          int n;
          public BIT(int n){
              bit = new int[n+1];
              this.n = n;
          }
          public int sum(int index){//1 based index put;
               int sum = 0;
               while(index>0){
                    sum+=bit[index];
                    index-=(index&-index);
               }
               return sum;
          }
          public void update(int index,int diff){ // 1based
               while(index<=n){
                    bit[index]+=diff;
                    index+=(index & -index);
               }
          }
          public int sum(int i,int j){//1 based index put;
               return sum(j)-sum(i-1);
          }
     }

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
     
     static class SuperFastScanner {  //10^5 -- .08 sec  && 4*10^6 ---> .46 sec
          final private int BUFFER_SIZE = 1 << 16;
          private DataInputStream din;
          private byte[] buffer;
          private int bufferPointer, bytesRead;

          public SuperFastScanner(){
               din = new DataInputStream(System.in);
               buffer = new byte[BUFFER_SIZE];
               bufferPointer = bytesRead = 0;
          }

          public SuperFastScanner(String file_name) throws IOException{
               din = new DataInputStream(new FileInputStream(file_name));
               buffer = new byte[BUFFER_SIZE];
               bufferPointer = bytesRead = 0;
          }

          public String nextLine() throws IOException{
               StringBuilder buf = new StringBuilder();
               int  c;
               while ((c = read()) != -1) {
                    if (c == '\n') {
                         break;
                    }
                    char ch = (char)c;
                    buf.append(ch);
               }
               return buf.toString();
          }
          public String next() throws IOException {
               StringBuilder res = new StringBuilder();
               int c = 0;
               while (c <= 32) c = read();
               while (c > 32) {
                    char ch = (char)c;
                    res.append(ch);
                    c = read();
               }
               return res.toString();
          }
          private byte read() throws IOException{
               if (bufferPointer == bytesRead) fillBuffer();
               return buffer[bufferPointer++];
          }

          public int nextInt() throws IOException{
               int ret = 0;
               byte c = read();
               while (c <= ' ') c = read();
               boolean neg = (c == '-');
               if (neg) c = read();
               do{
                    ret = ret * 10 + c - '0';
               }while ((c = read()) >= '0' && c <= '9');

               if (neg) return -ret;
               return ret;
          }

          public long nextLong() throws IOException{
               long ret = 0;
               byte c = read();
               while (c <= ' ') c = read();
               boolean neg = (c == '-');
               if (neg) c = read();
               do{
                    ret = ret * 10 + c - '0';
               }while ((c = read()) >= '0' && c <= '9');
               if (neg) return -ret;
               return ret;
          }

          public double nextDouble() throws IOException{
               double ret = 0, div = 1;
               byte c = read();
               while (c <= ' ') c = read();
               boolean neg = (c == '-');
               if (neg) c = read();

               do{
                    ret = ret * 10 + c - '0';
               }while ((c = read()) >= '0' && c <= '9');

               if (c == '.'){
                    while ((c = read()) >= '0' && c <= '9') {
                         ret += (c - '0') / (div *= 10);
                    }
               }

               if (neg) return -ret;
               return ret;
          }

          private void fillBuffer() throws IOException{
               bytesRead = din.read(buffer, bufferPointer = 0,BUFFER_SIZE);
               if (bytesRead == -1) buffer[0] = -1;
          }

          public void close() throws IOException{
               if (din == null) return;
               din.close();
          }
     
          public int[] nextIntArray(int n){
               int arr[] = new int[n];
               for(int i = 0;i<n;i++){
                    try {
                         arr[i] = nextInt();     
                    }catch (IOException  e){
                         e.printStackTrace();
                    }
               }
               return arr;
          }
          public long[] nextLongArray(int n){
               long arr[] = new long[n];
               for(int i = 0;i<n;i++){
                    try {
                         arr[i] = nextLong();     
                    }catch (IOException  e){
                         e.printStackTrace();
                    }
               }
               return arr;
          }
          public double[] nextDoubleArray(int n){
               double arr[] = new double[n];
               for(int i = 0;i<n;i++){
                    try {
                         arr[i] = nextDouble();     
                    }catch (IOException  e){
                         e.printStackTrace();
                    }
               }
               return arr;
          }
          public String[] nextStringArray(int n){
               try {
                    String arr[] = nextLine().split(" ");  
                    return arr;
               }catch (IOException  e){
                    e.printStackTrace();
               }
               return null;
          }
     }

     static class SuperFastScanner2{ // same as //10^5 -- .08 sec  && 4*10^6 ---> .46 sec 
          private int BS = 1 << 16;
          private char NC = (char) 0;
          private byte[] buf = new byte[BS];
          private int bId = 0, size = 0;
          private char c = NC;
          private double cnt = 1;
          private BufferedInputStream in;

          public SuperFastScanner2() {
               in = new BufferedInputStream(System.in, BS);
          }
          public SuperFastScanner2(String s) {
               try {
                    in = new BufferedInputStream(new FileInputStream(new File(s)), BS);
               } catch (Exception e) {
                    in = new BufferedInputStream(System.in, BS);
               }
          }

          private char getChar() {
               while (bId == size) {
                    try {
                         size = in.read(buf);
                    } catch (Exception e) {
                         return NC;
                    }
                    if (size == -1) return NC;
                    bId = 0;
               }
               return (char) buf[bId++];
          }

          public int nextInt() {
               return (int) nextLong();
          }

          public int[] nextIntArray(int N) {
               int[] res = new int[N];
               for (int i = 0; i < N; i++) {
                    res[i] = (int) nextLong();
               }
               return res;
          }

          public long[] nextLongArray(int N) {
               long[] res = new long[N];
               for (int i = 0; i < N; i++) {
                    res[i] = nextLong();
               }
               return res;
          }

          public long nextLong() {
               cnt = 1;
               boolean neg = false;
               if (c == NC) c = getChar();
               for (; (c < '0' || c > '9'); c = getChar()) {
                    if (c == '-') neg = true;
               }
               long res = 0;
               for (; c >= '0' && c <= '9'; c = getChar()) {
                    res = (res << 3) + (res << 1) + c - '0';
                    cnt *= 10;
               }
               return neg ? -res : res;
          }

          public double nextDouble() {
               double cur = nextLong();
               return c != '.' ? cur : cur + nextLong() / cnt;
          }

          public double[] nextDoubleArray(int N) {
               double[] res = new double[N];
               for (int i = 0; i < N; i++) {
                    res[i] = nextDouble();
               }
               return res;
          }

          public String next() {
               StringBuilder res = new StringBuilder();
               while (c <= 32) c = getChar();
               while (c > 32) {
                    res.append(c);
                    c = getChar();
               }
               return res.toString();
          }

          public String nextLine() {
               StringBuilder res = new StringBuilder();
               while (c <= 32) c = getChar();
               while (c != '\n' || c == -1) {
                    res.append(c);
                    c = getChar();
               }
               return res.toString();
          }

          public boolean hasNext() {
               if (c > 32) return true;
               while (true) {
                    c = getChar();
                    if (c == NC) return false;
                    else if (c > 32) return true;
               }
          }
     }

     public static boolean isPrime(long n){
          if(n < 2) return false;
          if(n == 2 || n == 3) return true;
          if(n%2 == 0 || n%3 == 0) return false;
          long sqrtN = (long)Math.sqrt(n)+1;
          for(long i = 6L; i <= sqrtN; i += 6) {
              if(n%(i-1) == 0 || n%(i+1) == 0) return false;
          }
          return true;
     }
  
     public static long gcd(long a, long b){
          if(a > b) a = (a+b)-(b=a);
          if(a == 0L) return b;
          return gcd(b%a, a);
     }

     public static long totient(long n){
          long result = n;
          for (int p = 2; p*p <= n; ++p){
               if (n % p == 0){
                    while(n%p == 0) n /= p;
                    result -= result/p;
               }
          }
          if(n > 1) result -= result/n;
          return result;
          /*
          find phi(i) from 1 to N fast
          O(N*loglogN)
          long[] arr = new long[N+1];
          for(int i=1; i <= N; i++)
              arr[i] = i;
          for(int v=2; v <= N; v++)
              if(arr[v] == v)
                  for(int a=v; a <= N; a+=v)
                      arr[a] -= arr[a]/v;
           */
     }

     public static int countBits(int a){
          int bit = 0;
          while(a>0){
               bit += (a&1)==1?1:0;
               a = a>>1;
          }
          return bit;
     }

     public static void sort(int[] arr){
          //because Arrays.sort() uses quicksort which is dumb
          //Collections.sort() uses merge sort
          ArrayList<Integer> ls = new ArrayList<Integer>();
          for(int x: arr)
          ls.add(x);
          Collections.sort(ls);
          for(int i=0; i < arr.length; i++)
          arr[i] = ls.get(i);
     }
      
     public static long power(long x, long y, long p){
          //0^0 = 1
          long res = 1L;
          x = x%p;
          while(y > 0){
               if((y&1)==1) // multiply on set bit only x^bit
                    res = (res*x)%p;
               y >>= 1;
               x = (x*x)%p;
          }
          return res;
     }
     
     public static long[][] multiply(long[][] left, long[][] right){ // matrix multiplication
          long MOD = 1000000007L;
          int N = left.length;
          int M = right[0].length;
          long[][] res = new long[N][M];
          for(int i=0; i < N; i++){
               for(int j=0; j < M; j++){
                    for(int k=0; k < left[0].length; k++){
                         res[i][j] += (res[i][j] % MOD + (left[i][k]*right[k][j]) % MOD) % MOD;
                    }
               }
          }
          return res;
     }

     public static long[][] power(long[][] grid, long pow){ // matrix A^n
          int r = grid.length,c = grid[0].length;
          long[][] res = new long[r][c];

          for(int i=0; i < res.length; i++){
          res[i][i] = 1L; //identity
          }
          long[][] curr = grid.clone();
          while(pow > 0){
          if((pow&1L) == 1L)
               res = multiply(curr, res);
          pow >>= 1;
          curr = multiply(curr, curr);
          }
          return res;
     }




}