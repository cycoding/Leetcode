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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k < 2)
            return head;
        return reverseNodes(head, k, new Stack<ListNode>());
    }
    public ListNode reverseNodes(ListNode head, int k, Stack<ListNode> stack) {
        int i = 0;
        ListNode node = head;
        while(i < k && node != null){
            stack.push(node);
            node = node.next;
            i++;
        }
        // two situations where node could be null: one when the size is exactly n*k, one is smaller than k which we should process
        if(node == null && i < k)
            return head;
        ListNode start = stack.pop();
        ListNode newHead = start;
        while(stack.size() > 0){
            ListNode temp = stack.pop();
            start.next = temp;
            start = temp;
        }
        start.next = reverseNodes(node, k, stack);
        return newHead;
    }
}