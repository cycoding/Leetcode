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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null)
            return null;
        return add(l1, l2, 0);
    }
    public ListNode add(ListNode left, ListNode right, int carry){
        if(left == null && right == null && carry == 0)
            return null;
        int sum = 0;
        //here we need only to change left and right if they have next pointers
        if(left != null){
            sum += left.val;
            left = left.next;
        }
        if(right != null){
            sum += right.val;
            right = right.next;
        }
        sum += carry;
        ListNode result = new ListNode(sum%10);
        result.next = add(left, right, sum/10);
        return result;
    }
}