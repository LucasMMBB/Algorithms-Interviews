ass MapSum {
    public TrieNode root;
    class TrieNode {
        Map<Character, TrieNode> childrenMap;
        boolean isEnd;
        int value;
        
        public TrieNode() {
            childrenMap = new HashMap<>();
            isEnd = false;
            value = 0;
        }
    }
    /** Initialize your data structure here. */
    public MapSum() {
        root = new TrieNode();
    }
    
    public void insert(String key, int val) {
        TrieNode node = root;
        for(char ch : key.toCharArray()) {
            if(!node.childrenMap.containsKey(ch)) {
                node.childrenMap.put(ch, new TrieNode());
            }
            node = node.childrenMap.get(ch);
        }
        node.isEnd = true;
        node.value = val;
    }
    
    public int sum(String prefix) {
        TrieNode node = root;
        for(char ch : prefix.toCharArray()){
            if(!node.childrenMap.containsKey(ch)){
                return 0;
            }
            node = node.childrenMap.get(ch);
        }
        return bfs(node);
    }
    
    public int dfs(TrieNode root) {
        int sum = 0;
        for(char ch : root.childrenMap.keySet()) {
            sum += dfs(root.childrenMap.get(ch));
        }
        return sum + root.value;
    }
    
    public int bfs(TrieNode root) {
        int sum = 0;
        Queue<TrieNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TrieNode node = queue.poll();
            sum += node.value;
            for(char ch : node.childrenMap.keySet()){
                queue.add(node.childrenMap.get(ch));
            }
        }
        return sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
