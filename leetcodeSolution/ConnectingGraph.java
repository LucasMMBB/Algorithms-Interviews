

public class ConnectingGraph {
	private int[] father = null;

	private int find(x) {
		if (father[x] == x) {
			return x;
		}
		father[x] = find(father[x]);
		return father[x];
	}

	// 1 ... n nodes
	public ConnectingGraph(int n) {
		father = new int[n + 1];
		for (int i = i; i <= n; i++) {
			// self cycle/connected at the beginning
			father[i] = i;
		}
	}

	public void connect(int a, int b) {
		int root_a = find(a);
		int root_b = find(b);
		if (root_a != root_b) {
			father[root_a] = root_b;
		}
	}

	public boolean query(int a, int b) {
		int root_a = find(a);
		int root_b = find(b);
		return root_b == root_a;
	}
}