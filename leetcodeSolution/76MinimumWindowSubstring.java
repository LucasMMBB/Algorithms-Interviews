/**
 * sliding window problem
 * two pointer: left, right starting from 0 position
 * right is used to extend the string and left is used to reduce the string
 * whenever there is chance current string(lenght: right - left + 1) contains all the required
 * characters, we start to move left pointer to reduce the string.
 * when the current string no longer contains all the required characters, we start to move
 * right pointer again to extend the current string.
 * By doing the above procedure, we can scan the whole string and have the shortest substring.
 */
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> dicT = new HashMap<>();
        for (char ch : t.toCharArray()) {
        	int count = dicT.getOrDefault(ch, 0);
        	dicT.put(ch, count + 1);
        }

        HashMap<Character, Integer> map = new HashMap<>();

        int required = dicT.size();
        int current = 0;
        int l = 0, r = 0;
        int[] ans = {-1, 0, 0}; // save the current ans
        while (r < s.length()) {
        	char ch = s.charAt(r);
        	int count = map.getOrDefault(ch, 0);
        	map.put(ch, count + 1);

        	if (dicT.containsKey(ch) && map.get(ch).intValue() == dicT.get(ch).intValue()) {
        		current++;
        	}

        	while (l <= r && current == required) {
        		ch = s.charAt(l);
        		if (ans[0] == -1 || r - l + 1 < ans[0]) {
        			ans[0] = r - l + 1;
        			ans[1] = l;
        			ans[2] = r;
        		}

        		map.put(ch, map.get(ch) - 1);
        		if (dicT.containsKey(ch) && dicT.get(ch).intValue() > map.get(ch).intValue()) {
        			current--;
        		}
        		l++;
        	}
            r++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}