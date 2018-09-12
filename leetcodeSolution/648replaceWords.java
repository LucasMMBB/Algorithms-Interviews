class Solution {
    public String replaceWords(List<String> roots, String sentence) {
        TrieNode trie = new TrieNode();
        
        // store the data into trie
        for (String root : roots) {
            TrieNode cur = trie;
            for (char ch : root.toCharArray()) {
                if(!cur.children.containsKey(ch)){
                    cur.children.put(ch, new TrieNode());
                }
                cur = cur.children.get(ch); // alwasy a empty node
            }
            cur.word = root;
        }

        // check the data from the trie
        StringBuilder sb = new StringBuilder();
        for (String word : sentence.split("\\s+")) {
            if (sb.length() > 0){ sb.append(" "); }
            TrieNode cur = trie;
            for (char ch : word.toCharArray()) {
                if (!cur.children.containsKey(ch) || cur.word != null) { break; }
                cur = cur.children.get(ch);
            }
            sb.append(cur.word != null ? cur.word : word);
        }

        return sb.toString();
    }
}


/*
 * Trie Node class using array
 */
class TrieNode {
    TrieNode[] children;
    String word;
    TrieNode() {
        children = new TrieNode[26];
    }
}

/*
 * Trie Node class using HashMap
 */
class TrieNode {
    Map<Character, TrieNode> children;
    String word;
    TrieNode() {
        children = new HashMap<>();
    }
}