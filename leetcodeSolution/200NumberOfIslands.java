public class Solution {
	// next check directions
	private final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    // time: O(rows * cols)
    // space: O(1) no extra space needed
	public int numIslands(char[][] grid){
		// sanity check
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int count = 0;
		final int rows = grid.length;
		final int cols = grid[0].length;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == '1') {
					count++;
					checkNeighbors(grid, i, j, rows, cols);
				}
			}
		}
		return count;
	}

	private void checkNeighbors(char[][] grid, int x, int y, int rows, int cols){
		// base case
		if (x < 0 || x >= rows || y < 0 || y >= cols || grid[x][y] == '0' || grid[x][y] == '2') {
			return;
		}
		// recursive rule
		grid[x][y] = '2';
		for (int[] dir : dirs) {
			int neighborX = x + dir[0];
			int neighborY = y + dir[1];
			checkNeighbors(grid, neighborX, neighborY, rows, cols);
		}
	}
}

class Solution {
	final int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
	/**
	 * defind union find class
	 */
	public class UnionFind {
		private int[] parent = null;
		private int count;

		private int find(int x) {
			if (parent[x] == x) {
				return x;
			}
			parent[x] = find(parent[x]);
			return parent[x];
		}
		public UnionFind(int n) {
            parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = i;
			}
		}

		public void connect(int a, int b){
			int rootA = find(a), rootB = find(b);
			if (rootA != rootB) {
				parent[rootA] = rootB;
				count--;
			}
		}
		public int query() {
			return count;
		}
		public void setCount(int total) {
			count = total;
		}
	}
	public int numIslands(char[][] grid) {
		// sanity check
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		final int rows = grid.length;
		final int cols = grid[0].length;

		UnionFind uf = new UnionFind(rows * cols);

		int total = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == '1') {
					total++;
				}
			}
		}
		uf.setCount(total);

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == '1') {
					grid[i][j] = '0';
					for (int[] dir : dirs) {
						int neiX = i + dir[0];
						int neiY = j + dir[1];

						if (neiX >= 0 && neiY >= 0 && neiX < rows && neiY < cols && grid[neiX][neiY] == '1' ) {
                            uf.connect(i * cols + j, neiX * cols + neiY);
                        }
					}
				}
			}
		}
		return uf.query();

	}
}