/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean first = true;
        while(fast != null && fast.next != null && (slow != fast || first)){
            if(first)
                first = false;
            slow = slow.next;
            fast = fast.next.next;
        }
        // extremely important not to forget including this !first condition
        // cause if head or head.next is null, it would enter this true prediction
        if(fast == slow && !first)
            return true;
        return false;
    }
}
