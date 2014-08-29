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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // BFS
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null)
            return res;
        List<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        Stack<List<Integer>> stack = new Stack<List<Integer>>();
        while(list.size() > 0){
            List<TreeNode> temp = new ArrayList<TreeNode>();
            List<Integer> num = new ArrayList<Integer>();
            for(TreeNode node : list){
                num.add(node.val);
                if(node.left != null)
                    temp.add(node.left);
                if(node.right != null)
                    temp.add(node.right);
            }
            stack.push(num);
            list = temp;
        }
        // WHEN directly convert a stack to arraylist, 
        // the Iterator would return the sequence as the reversed order of the pop() version
        while(!stack.empty())
            res.add(stack.pop());
        return res;
    }
}
