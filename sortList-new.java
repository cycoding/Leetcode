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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        // first get the length of the linked list
        int length = 0;
        ListNode node = head;
        while(node != null){
            length++;
            node = node.next;
        }
        // then start mergesort
        ListNode[] list = {head};
        return mergesort(list, 0, length-1);
    }
    public ListNode mergesort(ListNode[] list, int start, int end){
        // we can't move node to its next node after mergesort, which would cause node to move too fast
        // instead, in order to make node go to its next for both former and latter half
        // we should move it when we return a node
        if(start == end){
            // since java pass by reference, the change of node in this block would not be kept when returned
            ListNode node = list[0];
            list[0] = node.next;
            node.next = null;
            return node;
        }
        int mid = (start + end)/2;
        ListNode first = mergesort(list, start, mid);
        ListNode latter = mergesort(list, mid+1, end);
        return merge(first, latter);
    }
    public ListNode merge(ListNode first, ListNode latter){
        ListNode dummy = new ListNode(1);
        ListNode head = dummy;
        while(first != null && latter != null){
            if(first.val <= latter.val){
                dummy.next = first;
                dummy = first;
                first = first.next;
            }
            else {
                dummy.next = latter;
                dummy = latter;
                latter = latter.next;
            }
        }
        if(first == null)
            dummy.next = latter;
        else
            dummy.next = first;
        return head.next;
    }
}