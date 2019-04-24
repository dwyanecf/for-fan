package com.fanchen.clearmind.lianjia;

import com.fanchen.clearmind.concept.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.Stack;

public class BSTIterator {

    public Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        pushNode(root);

    }

    private void pushNode(TreeNode root) {
        while(root!=null){
            stack.push(root);
            root=root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        pushNode(node.right);
        return node.val;
    }

}
