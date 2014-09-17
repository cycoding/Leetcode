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
    public ListNode mergeKLists(List<ListNode> lists) {
        if(lists == null || lists.size() == 0)
            return null;
        return mergesort(lists, 0, lists.size()-1);
    }
    public ListNode mergesort(List<ListNode> lists, int start, int end){
        // if(start > end)
        //     return null;
        if(start == end)
            return lists.get(start);
        int mid = (start + end)/2;
        // has to be start->mid, mid+1->end; can't be start->mid-1 etc.
        ListNode low = mergesort(lists, start, mid);
        ListNode high = mergesort(lists, mid+1, end);
        return merge(low, high);
    }
    public ListNode merge(ListNode low, ListNode high){
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        
        while(low != null && high != null){
            if(low.val < high.val){
                dummy.next = low;
                dummy = low;
                low = low.next;
            }
            else {
                dummy.next = high;
                dummy = high;
                high = high.next;
            }
        }
        if(low == null)
            dummy.next = high;
        else
            dummy.next = low;
        return head.next;
    }
}
