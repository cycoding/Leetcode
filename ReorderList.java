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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return;
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode dummy = head;
        while(dummy != null){
            stack.push(dummy);
            dummy = dummy.next;
        }
        dummy = head;
        while(!stack.empty()){
            ListNode temp = stack.pop();
            //there are two separate conditions for exiting the program
            if(dummy == temp)
                break;
            if(dummy.next == temp){
                dummy = temp;
                break;
            }
            ListNode next = dummy.next;
            dummy.next = temp;
            temp.next = next;
            dummy = next;
        }
        dummy.next = null;
    }
}
