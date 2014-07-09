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
        if(lists == null)
            return null;
        if(lists.size() == 1)
            return lists.get(0);
            
        return mergesort(lists, 0, lists.size() - 1);
    }
    public ListNode mergesort(List<ListNode> lists, int start, int end){
        if(start > end)
            return null;
        else if(start == end)
            return lists.get(start);
        else {
            int center = (start+end)/2;
            ListNode left = mergesort(lists, start, center);
            ListNode right = mergesort(lists, center+1, end);
            return merge(left, right);
        }
    }
    public ListNode merge(ListNode p1, ListNode p2){
        ListNode dummy = new ListNode(0);
        ListNode fakeHead = dummy;

            while(p1 != null && p2 != null){
                if(p1.val < p2.val){
                    dummy.next = p1;
                    p1 = p1.next;
                }
                else {
                    dummy.next = p2; 
                    p2 = p2.next;
                }
                dummy = dummy.next;
            }
        
            if(p1 == null)
                dummy.next = p2;
            else if(p2 == null)
                dummy.next = p1;
            return fakeHead.next;
        }
        
    
}