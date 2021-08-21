package AdvDataStructure;

public class FenwikTree {
    int ftree[]; // 1 index based;
    int n;
    public void construct(int n){
        ftree = new int[n+1];
        this.n = n;
    }
    public int sum(int index){//1 based;
        int sum = 0;
        while(index>0){
            sum+=ftree[index];
            index-=(index&-index);
        }
        return sum;
    }
    public void update(int index,int diff){ // 1based
        while(index<=n){
            ftree[index]+=diff;
            index+=(index & -index);
        }
    }
}
