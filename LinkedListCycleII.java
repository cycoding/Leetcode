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

    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;

        ListNode fast = head;

        boolean cycle = false;

        // first check if there is a cycle

        while(fast != null && fast.next != null){

            slow = slow.next;

            fast = fast.next.next;

            if(slow == fast){

                cycle = true;

                break;

            }

        }

        if(!cycle)

            return null;

        // then we move slow back to head again

        slow = head;

        while(slow != fast){

            slow = slow.next;

            fast = fast.next;

        }

        return slow;

    }

}

>>>>>>> a53fe752551369e1da73f5017d5b9993fbf107f2
