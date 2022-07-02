import dataStructrue.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        LinkedList<List<Integer>> resp =new LinkedList<>();
        LinkedList<Integer> cur = new LinkedList();
        addPath(cur,resp,root,0,targetSum);
        return resp;
    }

    public void addPath(LinkedList<Integer> cur,LinkedList<List<Integer>> resp,TreeNode root,int curSum,int targetSum){
        if(root==null){
            return;
        }
        curSum+=root.val;
        cur.addLast(root.val);
        if(root.left==null&&root.right==null){
            if(curSum==targetSum) {
                resp.add(new LinkedList<Integer>(cur));
            }
            cur.pollLast();
            curSum-=root.val;
            return;
        }
        if(root.left!=null){
            addPath(cur,resp,root.left,curSum,targetSum);
        }
        if(root.right!=null){
            addPath(cur,resp,root.right,curSum,targetSum);
        }
        cur.pollLast();
        curSum-=root.val;
    }
}
