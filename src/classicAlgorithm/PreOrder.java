package classicAlgorithm;

import dataStructrue.TreeNode;
import utils.TreeBuilder;
import org.junit.Test;

import java.util.LinkedList;

public class PreOrder {
    public static void preOrder(TreeNode root){
        if(root == null) {
            return;
        }
        LinkedList<TreeNode> stack =new LinkedList<>();
        TreeNode p = root;
        while(!stack.isEmpty()||p!=null) {
            if(p!=null) {
                System.out.printf("%d ",p.val);
                stack.push(p);
                p = p.left;
            }else {
                p = stack.pop();
                p = p.right;
            }
        }
    }

    @Test
    public void test(){
        int[] nums={-1,3,5,1,6,2,0,8,-2147483648,-2147483648,7,4};
        preOrder(TreeBuilder.buildTree(nums));
    }
}
