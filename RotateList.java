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
    public ListNode rotateRight(ListNode head, int n) {
        if(head == null)
            return head;
        //get length of the nodes
        int length = 0;
        ListNode node = head;
        while(node != null){
            node = node.next;
            length++;
        }
        
        //calculate the real offset from the right
        int offset = n%length;
        if(offset == 0)
            return head;
            
        //previous->the actual tail node
        //node-> actual head
        //tail-> previous tail node
        node = head;
        ListNode previous = null;
        int pos = 0;
        while(pos < length-offset){
            previous = node;
            node = node.next;
            pos++;
        }
        ListNode tail = head;
        while(tail.next != null)
            tail = tail.next;
        tail.next = head;
        previous.next = null;
        return node;
    }
}