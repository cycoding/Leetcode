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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        //swap values of two adjacent nodes
        int temp = head.val;
        head.val = head.next.val;
        head.next.val = temp;
        // here is the recursive part
        head.next.next = swapPairs(head.next.next);
        return head;
    }
}
