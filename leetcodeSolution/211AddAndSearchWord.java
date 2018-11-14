// HashMap version
class TrieNode {
	Map<Character, TrieNode> children;
	public boolean hasWord;

	public TrieNode() {
		children = new HashMap<>();
		hasWord = false;
	}
}

// array version
class TrieNode2 {
    public int R = 26;
    public TrieNode[] next;
    public boolean isWordEnd;
    
    public TrieNode() {
        this.next = new TrieNode[R];
        for (int i = 0; i < R; i++) {
            this.next[i] = null;
        }
        this.isWordEnd = false;
    }
}

public class WordDictionary {

	private TrieNode root;

	/** Initialize your data structure here. */
	public WordDictionary() {
		root = new TrieNode();
	}

	/** Adds a word into the data structure. */
	public void addWord(String word) {
		TrieNode cur = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (!cur.children.containsKey(ch)) {
				cur.children.put(ch, new TrieNode());
			}
			cur = cur.children.get(ch);
		}
		cur.hasWord = true;
	}

	/** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
	public boolean search(String word) {
		return searchHelper(word, 0, root);
	}

	/** Search helper function using DFS **/
	private boolean searchHelper(String word, int index, TrieNode now) {
		// base case
		if(index == word.length()){
			return now.hasWord;
		}
		Character c = word.charAt(index);
		if (now.children.containsKey(c)) {
			return searchHelper(word, index+1, now.children.get(c)) ;
		}else if(c == '.'){
			// check all entries(skip the current node and check next ones)
			// using recursice
			for(Map.Entry<Character, TrieNode> child: now.children.entrySet()){
				if (child.getValue() != null && searchHelper(word, index+1, child.getValue())) {
					return true;
				}
			}
		}
		return false;
	}
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */