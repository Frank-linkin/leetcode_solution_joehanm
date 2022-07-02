import dataStructrue.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        TreeNode preVisited = null;
        TreeNode p = root;
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        while(!stack.isEmpty()||p!=null){
            while( p != null){
                stack.push(p);
                p= p.left;
            }
            p = stack.peek();
            if(p.right == null||p.right==preVisited){
                //访问p
                res.add(p.val);
                preVisited = p;
                stack.pop();
                p = null;
            }
            else
                p = p.right;
        }
        return res;
    }
}
