// I like this question
// May be use array instead of HashSet? a little improvement?
class Solution {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('A');
        set.add('e');
        set.add('E');
        set.add('i');
        set.add('I');
        set.add('o');
        set.add('O');
        set.add('u');
        set.add('U');
        
        char[] chars = s.toCharArray();
        int l = 0, r = s.length() - 1;
        while (l < r) {
            // keep checking precondition: left < right
            while (l < r && !set.contains(chars[l])) {
                l++;
            }
            
            // keep checking precondition: left < right
            while (l < r && !set.contains(chars[r])) {
                r--;
            }
            char tmp = chars[l];
            chars[l] = chars[r];
            chars[r] = tmp;
            l++;
            r--;
        }
        return new String(chars);
    }
}