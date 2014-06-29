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
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode node = head.next;
        while(node != null){
            // for every node we need to find the three nodes for changing pointers
            ListNode preInsert = dummy;
            ListNode insert = dummy.next;
            ListNode preNode = insert;
            
            while(insert.val < node.val){
                preInsert = insert;
                insert = insert.next;
            }
            //if already in ascending order, simply go to next node
            if(insert == node){
                node = node.next;
                continue;
            }
            while(preNode.next != node)
                preNode = preNode.next;
                
            preNode.next = node.next;
            node.next = insert;
            preInsert.next = node;
            
            node = preNode.next;
        }
        return dummy.next;
    }
}