package Tree;

import com.fanchen.clearmind.concept.TreeNode;

/**
 * 
 * @author connie
 *
 *
 *
 *Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
 */
public class ConstructTree {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return helper(0, 0, inorder.length - 1, preorder, inorder);
	}

	public TreeNode helper(int preS, int inS, int inE, int[] preorder, int[] inorder) {
		if (preS > preorder.length - 1 || inS > inE)
			return null;
		int index = 0;
		TreeNode root = new TreeNode(preorder[preS]);
		for (int i = inS; i <= inE; i++) {
			if (root.val == inorder[i])
				index = i;
		}
		root.left = helper(preS + 1, inS, index - 1, preorder, inorder);
		root.right = helper(preS + index - inS + 1, index + 1, inE, preorder, inorder);
		return root;
	}
}
