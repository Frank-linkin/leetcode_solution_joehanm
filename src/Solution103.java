import dataStructrue.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        LinkedList<Integer> level  = new LinkedList<>();
        LinkedList<List<Integer>> resp = new LinkedList<>();
        if(root == null) {
            return resp;
        }

        TreeNode last = root;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean toRight = true;
        while(!queue.isEmpty()){
            TreeNode cur = queue.pollFirst();
            if(cur.left!=null){
                queue.addLast(cur.left);
            }
            if(cur.right!=null){
                queue.addLast(cur.right);
            }
            if(toRight){
                level.addLast(cur.val);
            }else{
                level.addFirst(cur.val);
            }

            if(!queue.isEmpty()&&cur==last){
                //使用getLast()的时候要确定queue是不是已经空了
                last = queue.getLast();
                toRight=!toRight;
                resp.addLast(level);
                level = new LinkedList<Integer>();
            }
        }
        if(!level.isEmpty()){
            resp.addLast(level);
        }
        return resp;
    }


}
