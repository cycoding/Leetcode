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

        // this takes o(N) space and 0(N) time complexity

        // first find latter half of the list

        ListNode slow = head;

        ListNode fast = head;

        while(fast != null && fast.next != null){

            slow = slow.next;

            fast = fast.next.next;

        }

        if(slow == null)

            return;

        // here slow is at the middle of the list

        Stack<ListNode> stack = new Stack<ListNode>();

        while(slow != null){

            stack.push(slow);

            slow = slow.next;

        }

        // then insert latter half into former half

        slow = head;

        ListNode cur = stack.peek();

        while(slow.next != cur && slow != cur){

            cur = stack.pop();

            cur.next = slow.next;

            slow.next = cur;

            slow = cur.next;

            cur = stack.peek();

        }

        if(slow == cur)

            slow.next = null;

        else

            slow.next.next = null;

    }

}
