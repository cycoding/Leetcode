public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode node = null;
        if(head == null || head.next == null)
            return node;
        ListNode slow = head;
        ListNode fast = head;
        boolean first = true;
        //the first time slow is equal to fast
        while(fast!= null && fast.next != null && ((!first && fast != slow) || first)){
            slow = slow.next;
            fast = fast.next.next;
            first = false;
        }
        if(fast == null || fast.next == null)
            return node;
        //at this time there is a cycle
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
        
    }
}