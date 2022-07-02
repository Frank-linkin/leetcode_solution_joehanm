import dataStructrue.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Solution95 {
    public List<TreeNode> generateTrees(int n) {
        return generateTreesCore(1,n);
    }

    public List<TreeNode> generateTreesCore(int start, int end) {
        List<TreeNode> resp = new ArrayList<TreeNode>();
        if(start > end){
            return resp;
        }
        if(start == end) {
            resp.add(new TreeNode(start));
            return resp;
        }

        for(int i =start ; i<=end;i++) {

            List<TreeNode> leftList = generateTreesCore(start,i-1);
            List<TreeNode> rightList = generateTreesCore(i+1,end);
            if(leftList.size()==0&&rightList.size()==0){
                TreeNode root = new TreeNode(i);
                resp.add(root);
            }
            else if (leftList.size()==0){
                for(TreeNode rightOne:rightList) {
                    TreeNode root = new TreeNode(i);
                    root.left = null;
                    root.right = rightOne;
                    resp.add(root);
                }
            }
            else if(rightList.size()==0){
                for(TreeNode leftOne:leftList) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftOne;
                    root.right = null;
                    resp.add(root);
                }
            }
            for(TreeNode leftOne:leftList){
                for(TreeNode rightOne:rightList) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftOne;
                    root.right = rightOne;
                    resp.add(root);
                }
            }
        }
        return resp;
    }

    @Test
    public void test1(){
        List<TreeNode> list = generateTrees(3);
        for(TreeNode treeNode : list) {
            System.out.println(treeNode.val);
        }
    }
}
