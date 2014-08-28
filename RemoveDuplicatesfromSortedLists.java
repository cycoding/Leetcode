/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode cur = head;
        int count = 0;
        
        //better to draw an illustration for better understanding. here we need to delete all duplicate ones
        while(true){
            while(cur != null && cur.next != null && cur.val == cur.next.val){
                count++;
                cur = cur.next;
            }
            if(cur.next == null){
                if(count > 0)
                    prev.next = cur.next;
                return dummy.next;
            }
            else{
                if(count > 0)
                    prev.next = cur.next;
                else
                    prev = cur;
                cur = cur.next;
            }
            count = 0;
        }
    }
}