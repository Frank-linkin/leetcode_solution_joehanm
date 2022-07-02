import dataStructrue.TreeNode;

public class Solution1325 {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        removeCore(root,target);
        return root;
    }

    public TreeNode removeCore(TreeNode root,int target) {
        if(root==null) {
            return null;
        }
        root.left = removeCore(root.left,target);
        root.right = removeCore(root.right,target);
        if(root.val!=target) {
            return root;
        }else{
            if(root.left == null && root.right == null) {
                return null;
            }
            return root;
        }
    }
}
