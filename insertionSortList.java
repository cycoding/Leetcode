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
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = null;
        ListNode prev = null;
        ListNode node = head.next;
        ListNode fore = head;
        while(node != null){
            // first preserve its next node
            prev = dummy;
            // head pointer is unchanged
            cur = prev.next;
            // find the place to insert node
            while(cur.val <= node.val && cur != node){
                prev = cur;
                cur = cur.next;
            }
            if(cur != node){
                // so first we have to change the parent node of node to its child
                fore.next = node.next;
                // then we need to insert the node between prev and cur
                prev.next = node;
                node.next = cur;
                node = fore.next;
            }
            else{
                fore = node;
                node = node.next;
            }
        }
        return dummy.next;
    }
}
