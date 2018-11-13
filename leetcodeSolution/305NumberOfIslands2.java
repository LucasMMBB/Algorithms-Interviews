// TODO
class Solution {
	class UnionFind {
		HashMap<Integer, Integer> father = new HashMap<>();
		public UnionFind(int n, int m) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					int id = convertId(i, j, m);
					father.put(id, id);
				}
			}
		}
	}
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        
    }

    public int convertId(int x, int y, int cols) {
    	return x * cols + y;
    }
}