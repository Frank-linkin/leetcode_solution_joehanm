import java.util.Stack;

public class Solution337 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //该题目中用到了后序遍历
    public int rob(TreeNode root) {

        

        return 0;
    }
    private int checkVal(TreeNode root){
        if(root==null){
            return 0;
        }
        else{
            return root.val;
        }
    }

    public static void main(String[] args) {

    }
}
