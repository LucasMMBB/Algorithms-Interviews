/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        if(cur == null || cur.next == null){ return head; }
        ListNode nxt = cur.next;
        while(nxt != null){
            if(nxt.val == cur.val){
                cur.next = nxt.next;
            } else {
                cur = nxt;
            }
            nxt = nxt.next;
        }
        return head;
    }
}