/*
 * Copyright (C) 2019 Copart, Inc. All rights reserved.
 */
package Tree;

import com.fanchen.clearmind.concept.TreeNode;

/**
 * @author fachen
 *
 */
public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p == null || q == null)
			return false;
		if (p.val != q.val)
			return false;
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
}
