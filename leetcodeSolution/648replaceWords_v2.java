class Solution {
    public String replaceWords(List<String> roots, String sentence) {
        Trie trie = new Trie();
        for(String root : roots){
            trie.insert(root);
        }

        StringBuilder sb = new StringBuilder();
        for(String word : sentence.split("\\s+")) {
            if(sb.length() > 0) { sb.append(" "); }
            sb.append(trie.getPrefix(word));
        }
        return sb.toString();
    }
}

class Trie {
    class TrieNode {
        TrieNode[] children;
        String word;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()) {
            if(node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode();
            }
            node = node.children[ch - 'a'];
        }
        node.word = word;
    }

    public String getPrefix(String word){
        TrieNode node = root;
        for(char ch : word.toCharArray()) {
            if(node.children[ch - 'a'] == null || node.word != null){ break; }
            node = node.children[ch - 'a'];
        }
        return node.word != null ? node.word : word;
    }

}