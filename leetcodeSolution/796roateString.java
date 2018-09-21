class Solution {
    public boolean rotateString(String A, String B) {
        return (A.length() == B.length())
        	&& (new StringBuilder(A).append(A).toString().contains(B));
    }
}