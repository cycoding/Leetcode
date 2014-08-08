/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
		return generateBST(1, n);
	}

	public List<TreeNode> generateBST(int start, int end) {
		List<TreeNode> res = new ArrayList<TreeNode>();
		
		//when you return a list containing null object, it would make program easier
		if (start > end) {
			res.add(null);
			return res;
		}

		for (int i = start; i <= end; i++) {

			List<TreeNode> left = generateBST(start, i - 1);
			List<TreeNode> right = generateBST(i + 1, end);

            // since we return list with null object, we could enter every for loop
			for (TreeNode nodel : left)
				for (TreeNode noder : right) {
					TreeNode root = new TreeNode(i);
					root.left = nodel;
					root.right = noder;
					res.add(root);
				}
		}
		return res;
	}
}