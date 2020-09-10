package com.chitradip.excercises.leetcode.september2020;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class SumRootToLeaf {

    private TreeNode root;

    SumRootToLeaf(int[] arry) {
        int currIdx = 0;
        int childIdx = 1;
        root = new TreeNode(arry[currIdx]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while ( !queue.isEmpty() && childIdx < arry.length) {
            TreeNode currNode = queue.poll();

            currNode.left = new TreeNode(arry[childIdx++]);
            currNode.right = new TreeNode(arry[childIdx++]);
            queue.offer(currNode.left);
            queue.offer(currNode.right);
        }
    }
    public int sumRootToLeaf(TreeNode root) {
        return traverse(root, 0, 0) ;

    }

    private int traverse(TreeNode node, int currSum, int sum) {
        int newVal = (currSum << 1) + node.val;

        if ( node.left == null && node.right == null) {
            return sum+newVal;
        }

        if (node.left != null ) {
            sum = traverse(node.left, newVal, sum);
        }
        if (node.right != null)
        {
            sum = traverse(node.right, newVal, sum);
        }
        return sum;
    }

    public static void main(String[] args) {
        SumRootToLeaf sumRootToLeaf = new SumRootToLeaf(new int[]{1, 0,1,0,1,0,1});
        System.out.println(sumRootToLeaf.sumRootToLeaf(sumRootToLeaf.root));
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
