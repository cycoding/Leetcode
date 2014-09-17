/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        // Now lets try without extra storage
        // if(head == null)
        //     return null;
        // // use arraylist to store the value
        // List<Integer> list = new ArrayList<Integer>();
        // while(head != null){
        //     list.add(head.val);
        //     head = head.next;
        // }
        // return binary(list, 0, list.size()-1);
        if(head == null)
            return null;
        // special case: if not handled, prev would be null
        if(head.next == null)
            return new TreeNode(head.val);
        // first find the mid pointer
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // here slow points to the mid one
        TreeNode root = new TreeNode(slow.val);
        prev.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
    // public TreeNode binary(List<Integer> list, int start, int end){
    //         if(start > end)
    //             return null;
    //         if(start == end)
    //             return new TreeNode(list.get(start));
    //         int mid = (start + end)/2;
    //         TreeNode root = new TreeNode(list.get(mid));
    //         root.left = binary(list, start, mid-1);
    //         root.right = binary(list, mid+1, end);
    //         return root;
    // }
}
