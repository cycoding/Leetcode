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
        TreeNode res = null;
        if(head == null)
            return res;
        int length = 0;
        ListNode start = head;
        while(start != null){
            length++;
            start = start.next;
        }
        //we create an array because java passes array by reference
        ListNode[] holder = {head};
        return dfs(holder, 0, length-1);
    }
    public TreeNode dfs(ListNode[] holder, int start, int end){
        if(start > end)
            return null;
        int mid = (start + end)/2;
        TreeNode left = dfs(holder, start, mid-1);
        //since java pass pointer by value, the modification to node would only stay in its subcall
        TreeNode root = new TreeNode(holder[0].val);
        root.left = left;
        holder[0] = holder[0].next;
        root.right = dfs(holder, mid+1, end);
        return root;
    }
}
