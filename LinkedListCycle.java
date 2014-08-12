public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean first = true;
        // keep in mind that at first fast is equal to slow
        while(fast != null && fast.next != null && (first || fast != slow)){
            slow = slow.next;
            fast = fast.next.next;
            first = false;
        }
        if(fast == null || fast.next == null)
            return false;
        return true;
    }
}
