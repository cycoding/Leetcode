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
        int length = 0;
        ListNode temp = head;
        while(temp != null){
            length++;
            temp = temp.next;
        }
        //create a holder to pass reference
        ListNode[] holder = {head};
        return mergesort(holder, 0, length-1);
    }
    public ListNode mergesort(ListNode[] holder, int start, int end){
        //everytime when we return a node, we have to set its next to null to prevent dead loop
        if(start == end){
        	ListNode node = holder[0];
            ListNode temp = holder[0].next;
            holder[0].next = null;
            holder[0] = temp;
            return node;
        }
        int mid = (start+end)/2;
        ListNode left = mergesort(holder, start, mid);
        ListNode right = mergesort(holder, mid+1, end);
        //merge two sorted lists whose heads are left and right
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(left != null && right != null){
            if(left.val < right.val){
                dummy.next = left;
                left = left.next;
            }
            else{
                dummy.next = right;
                right = right.next;
            }
            dummy = dummy.next;
        }
        if(left != null)
            dummy.next = left;
        if(right != null)
            dummy.next = right;
        return head.next;
    }
}
