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
    List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        levelOrder(root, 0);
        return result;
    }
    void levelOrder(TreeNode node, int level){
        if(node == null) return;
        if(result.size() == level) result.add(node.val);

        levelOrder(node.right, level + 1);
        levelOrder(node.left, level + 1);
    }
}