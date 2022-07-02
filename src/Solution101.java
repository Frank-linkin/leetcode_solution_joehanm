import dataStructrue.TreeNode;

public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null||(root.left==null&&root.right==null) ){
            return true;
        }
        if(root.left==null||root.right==null){
            return false;
        }
        return isSymmetricCore(root.left,root.right);
    }

    public boolean isSymmetricCore(TreeNode rootLeft,TreeNode rootRight) {
        if(rootLeft==null&&rootRight==null) {
            return true;
        }
        if(rootLeft==null||rootRight==null){
            return false;
        }
        if(rootLeft.val!=rootRight.val) {
            return false;
        }
        return isSymmetricCore(rootLeft.right,rootRight.left)&&isSymmetricCore(rootLeft.left,rootRight.right);
    }
}
