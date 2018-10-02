class Solution {
    public int myAtoi(String str) {       
        int index = 0, sign = 1, val = 0;
        while(index < str.length() && str.charAt(index) == ' ') {
            index++;
        }
        
        if(index < str.length() && (str.charAt(index) == '-' || str.charAt(index) == '+')){
            sign = str.charAt(index) == '-' ? -1 : 1;
            index++;
        }
        
        while(index < str.length()){
            int digit = str.charAt(index) - '0';
            if(digit > 9 || digit < 0){ break;}
            //check if total will be overflow after 10 times and add digit
            if(Integer.MAX_VALUE/10 < val || (Integer.MAX_VALUE/10 == val && Integer.MAX_VALUE %10 < digit)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            val = val * 10 + digit;
            index++;
        }
        return sign * val;
    }
}