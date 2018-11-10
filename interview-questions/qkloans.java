class solution {
	// question 1
	// hackrank: isBalanced or Leetcode: valid parentheses
	public String isBalances(String s) {
        char[] arr = s.toCharArray();
        Map<Character, Character> right = new HashMap<>();
        right.put(')', '(');
        right.put(']', '[');
        right.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (char ch : arr) {
            if(right.containsKey(ch) && stack.size() != 0){
                if (stack.peek() == right.get(ch)) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }

    // questions 2
    private static int finalPrice(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0 ;
        for(int i = nums.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && nums[i] < stack.peek()){
                stack.pop();
            }
            sum += stack.isEmpty() ? nums[i] : nums[i] - stack.peek();
            stack.push(nums[i]);
        }
        return sum;
    }
}