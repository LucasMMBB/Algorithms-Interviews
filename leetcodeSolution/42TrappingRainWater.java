/**
 * caculate each unit trapped water
 * we need to know the max numbers on the left and right sides
 * where we can also improve our time complexity
 */
class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int len = height.length;
        for (int i = 0; i < len - 1; i++) {
            int max_left = 0, max_right = 0;
            // left max number
            for (int j = i; j >= 0; j--) {
                max_left = Math.max(max_left, height[j]);
            }
            
            // right max number
            for (int j = i; j < len; j++) {
                max_right = Math.max(max_right, height[j]);
            }
            
            // add the current unit water
            ans += Math.min(max_left, max_right) - height[i];
        }
        return ans;
    }

    /**
     * method 2: dynamic programming
     * record the left max, right max number seperately
     * caculate the overlap height(Math.min)
     *
     */
    public int trap2(int[] height) {
        // dynamic programming method
        int ans = 0;
        int left_max = 0, right_max = 0;
        int[] left_maxValue = new int[height.length];
        int[] right_maxValue = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            left_max = Math.max(left_max, height[i]);
            left_maxValue[i] = left_max - height[i];
        }
        
        for (int j = height.length - 1; j >= 0; j--) {
            right_max = Math.max(right_max, height[j]);
            right_maxValue[j] = right_max - height[j];
        }
        
        for (int i = 0; i < height.length; i++) {
            ans += Math.min(left_maxValue[i], right_maxValue[i]);
        }
        return ans;
    }

    // O(n) time, O(1) space.
    // best solution
    public int trap3(int[] height) {
        // two pointers
        // based on the method 2, we can improve the in one scan.
        int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= left_max) { left_max = height[left]; } else { ans += (left_max - height[left]); }
                ++left;
            } else {
                if (height[right] >= right_max) { right_max = height[right]; } else { ans += (right_max - height[right]); }
                --right;
            }
        }
        return ans;
    }
}
