class TrieForBit {
    class TrieNode{
        TrieNode[] trie = new TrieNode[2];
        int num;
    }
    TrieNode root = new TrieNode();
    
    public void construct(int[] nums) {

        for(int num : nums){
            insert(root,num);
        }
    }
    public void insert(TrieNode node,int num){
        for(int i = 31;i>=0;i--){
            int bit = (num >> i) & 1;
            if(node.trie[bit] == null){
                node.trie[bit] = new TrieNode();
            }
            node = node.trie[bit];
        }
        node.num = num;
    }
    public int search(TrieNode node,int num){
        for(int i = 31;i>=0;i--){
            int bit = (num >> i) & 1;
            
            if(node.trie[bit] != null){
                node = node.trie[bit];
            }else{
                return -1; //not fount num;
            }
        }
        return node.num;
    }
}