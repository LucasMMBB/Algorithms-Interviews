class Solution {
    class UnionFind {
        private int[] father;
        private int size;
        private int find (int x) {
            if (father[x] == x) {
                return x;
            }
            father[x] = find(father[x]);
            return father[x];
        }
        public UnionFind (int n) {
            father = new int[n];
            for (int i = 0; i < n; i++) {
                father[i] = i;
                size = n;
            }
        }
        
        public boolean union (int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA != rootB) {
                father[rootA] = rootB;
                size--;
                return true;
            } else {
                return false;
            }
        }
        
        public int getSize() {
            return size;
        }
    }
    public boolean validTree(int n, int[][] edges) {
        // sanity check
        UnionFind uf = new UnionFind(n);
        
        // connecting components
        for (int[] edge : edges) {
            boolean isValid = uf.union(edge[0], edge[1]);
            if (!isValid) { return false; }
        }
        
        // check whether they are all connected or not
        return uf.getSize() == 1;
    }
}