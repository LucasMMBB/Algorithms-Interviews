class Node {
	int num1Index, num2Index, num1Value, num2Value, sum;
	public Node (int num1Index, int num2Index, int num1Value,
				int num2Value, int sum) {
		this.num1Index = num1Index;
		this.num2Index = num2Index;
		this.num1Value = num1Value;
		this.num2Value = num2Value;
		this.sum = sum;
	}
}

class NodeComparator implements Comparator<Node> {
	@Override
	public int compare(Node a, Node.b) {
		return a.sum - b.sum;
	}
}

/**
 * Question: find kth smallest sum in two arrays
 */
class Solution {
	public int findKthSmallestSum(int[] arr1, int arr2, int k){
		// sort the arrays
		Arrays.sort(arr1);
		Arrays.sort(arr2);

		int len1 = arr1.length, len2 = arr2.length;

		PriorityQueue<Node> minHeap = new PriorityQueue<>(k, new NodeComparator());

		minHeap.add(new Node(0, 0, arr1[0], arr2[0], arr1[0] + arr2[0]));

		int count = 1;
		while(!minHeap.isEmpty()){
			Node node = minHeap.poll();
			int num1_ind = node.num1Index;
			int num2_ind = node.num2Index;
			int num1Value = node.num1Value;
			int num2Value = node.num2Value;
			int node_sum = node.sum;

			if (count == k) {
				return node.sum;
			}
			count++;

			if (num1_ind + 1 < len1) {
				Node tmp = new Node(num1_ind+1, num2_ind, arr1[num1_ind+1], arr2[num2_ind], arr[num1_ind+1] + arr2[num2_ind]);
				minHeap.add(tmp);
			}

			if (num2_ind + 1 < len2) {
				Node tmp = new Node(num1_ind, num2_ind+1, arr1[num1_ind], arr2[num2_ind+1], arr1[num1_ind] + arr2[num2_ind+1]);
				minHeap.add(tmp);
			}
		}
		return -1;
	}
}