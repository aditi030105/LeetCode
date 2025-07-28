/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode curr = head;
        for(int i = 0; i < k; i++){
            if(curr == null) return head;
            curr = curr.next;
        }
        ListNode pre = null;
        curr = head;
        int cnt = 0;
        while(cnt < k){
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
            cnt++;
        }
        head.next = reverseKGroup(curr, k);
        return pre;
    }
}