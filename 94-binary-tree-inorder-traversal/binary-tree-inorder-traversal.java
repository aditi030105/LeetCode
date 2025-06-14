/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        return inorder(root, list);
    }
    public List<Integer> inorder(TreeNode tree, List<Integer> list){
        if(tree.left != null) inorder(tree.left, list);
        list.add(tree.val);
        if(tree.right != null) inorder(tree.right, list);
        return list;
    }
}