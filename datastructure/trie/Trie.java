import java.util.HashMap;
import java.util.Map;

/**
 * Trie class
 *
 * @author maoxul
 * @date 9/25/2018
 * */
public class Trie {
    class TrieNode {
        Map<Character, TrieNode> map;
        boolean isEnd;
        String word;

        public TrieNode(){
            map = new HashMap<>();
            isEnd = false;
            word = null;
        }
    }

    TrieNode root;
    public Trie() {
        root = new TrieNode();
    } 

    public void insert(String word){
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            if(!node.map.containsKey(ch)) {
                node.map.put(ch, new TrieNode());
            }
            node = node.map.get(ch);
        }
        node.isEnd = true;
        node.word = word;
    }
}
