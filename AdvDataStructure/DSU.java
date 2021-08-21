package AdvDataStructure;
import java.util.*;
class DSU {

    static int[] parent = new int[100001];
    static int[] rank = new int[100001];

    public static void makeSet(){
        for(int i = 1;i<parent.length;i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }
    public static int findParent(int node){
        if(node == parent[node]){
            return node;
        }
        return parent[node] = findParent(parent[node]);
    }
    public static void Union(int u,int v){
        u = findParent(u);
        v = findParent(v);

        if(rank[u] < rank[v]){
            parent[u] = v;
        }else if(rank[u] > rank[v]){
            parent[v] = u;
        }else{
            parent[v] = u;
            rank[u]++;
        }
    }
    public static void main(String[] args) {
        makeSet();
        Scanner scan = new Scanner(System.in);
        int t = 0;
        t = Integer.parseInt(scan.nextLine());
        
        int u=0,v=0;
        while(t-->0){
            u = Integer.parseInt(scan.nextLine());
            v = Integer.parseInt(scan.nextLine());
            
            Union(u,v);
        }
        
        u = Integer.parseInt(scan.nextLine());
        v = Integer.parseInt(scan.nextLine());
        
        if(findParent(u) != findParent(v)){
            System.out.println("both are in sam set");
        }else{
            System.out.println("both are in in diff set");
        }
        scan.close();

    }
}