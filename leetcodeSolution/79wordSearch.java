class Solution {
	private int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	public boolean exist(char[][] board, String word) {
		// sanity check
		if (board == null || board.length == 0 || board[0].length == 0) {
			return false;
		}

		if (word == null || word.length() == 0) {
			return true;
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					boolean rst = find(board, i, j, word, 0);
					if (rst) { return true; }
				}
			}
		}
		return false;
	}

	private boolean find (char[][] board, int x, int y, String word, int index) {
        // base line
		if (index == word.length()) {
			return true;
		}
        
		// sanity check
		if (x < 0 || x >= board.length || y < 0 || y >= board[0].length
				|| board[x][y] != word.charAt(index)) {
			return false;
		}
        
        // mark as visited
		board[x][y] = '#';
	    for (int[] dir : dirs) {
			int neiX = x + dir[0];
			int neiY = y + dir[1];
			boolean res = find(board, neiX, neiY, word, index + 1);
			if (res) { return true; }
		}
        // change back to previous value
        board[x][y] = word.charAt(index);
        return false;
	}
}