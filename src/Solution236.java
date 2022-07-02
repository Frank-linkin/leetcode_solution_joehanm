import dataStructrue.ListNode;
import dataStructrue.TreeNode;
import classicAlgorithm.*;
import org.junit.Test;
import utils.TreeBuilder;

public class Solution236 {
    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //System.out.printf("  p=%d,q=%d ",p.val,q.val);
        if (root == null) {
            return null;
        }
        findCommon(root, p, q);
        return ans;
    }


    public boolean findCommon(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }

        boolean leftResult = findCommon(root.left, p, q);
        boolean rightResult = findCommon(root.right, p, q);
        if ((leftResult && rightResult) || ((root.val == p.val || root.val == q.val) && (leftResult || rightResult))) {
            this.ans = root;
        }
        if ((root.val == p.val || root.val == q.val)||(leftResult||rightResult)) {
            return true;
        }
        return false;
    }

    @Test
    public void test1() {
        int[] nums = {3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4};
        TreeNode[] nodes = TreeBuilder.buildTreeInArray(nums);
        PreOrder algorithm = new PreOrder();
        algorithm.preOrder(nodes[0]);

        TreeNode res1 = lowestCommonAncestor(nodes[0], nodes[3], nodes[9]);
        System.out.println("res1=" + res1.val);
    }
    /**
     * 有以下两种情况
     *  1.p,q之一本身就是最近公共祖先
     *  2.其他结点是他们的公共祖先
     *  bool findCommon(TreeNode root ,TreeNode p,TreeNode q)
     *      if left&&right || (this.val = p||this.val=q)&&(left||right)
     *
     */

}
