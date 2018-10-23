class Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int l = 0; l < s.length(); l += 2*k) {
            int right = l + k - 1 > s.length() - 1 ? s.length() - 1 : l + k - 1;
            reverse(chars, l, right);
        }
        return new String(chars);
    }
    
    private void reverse(char[] chars, int left, int right) {
        while (left < right) {
            swap(chars, left++, right--);
        }
    }
    
    private void swap(char[] chars, int left, int right) {
        char tmp = chars[left];
        chars[left] = chars[right];
        chars[right] = tmp;
    }
}