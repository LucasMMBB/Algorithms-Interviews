class Solution {
    private String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if(digits.length() == 0){ return ans; }
        ans.add("");
        for(char digit : digits.toCharArray()){
            int size = ans.size();
            for(int i = 0; i < size; i++){
                String tmp = ans.poll();
                for(char ch : letters[digit - '0'].toCharArray()){ ans.add(tmp + ch); }
            }
        }
        return ans;
    }
}