public class Solution236 {
    class TreeNode{
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x;}
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if( root  == null) return null;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if( right == null && left == null){
            if (root == p) return p;
            if (root == q) return q;
            return null;
        }
        if( left!=null&&right !=null){
            return root;
        }
        if( root==p||root==q){
            return root;
        }
        return left!=null?left:right;
    }
}
