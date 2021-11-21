import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        TreeNode p = root;
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        //循环判断条件是栈不为空或p不为空
        while(!stack.isEmpty()||p!=null){
            //p不为空就一直向左
            if(p!=null){
                stack.push(p);
                p=p.left;
            }
            //p如果为空，就弹出一个结点，并置p为弹出结点的右节点
            else{
                p = stack.pop();
                //访问P
                res.add(p.val);
                p=p.right;
            }
        }
        return res;
    }

    //现在提供先序遍历代码
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        TreeNode p = root;
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        //循环判断条件是栈不为空或p不为空
        while(!stack.isEmpty()||p!=null){
            //p不为空就一直向左,并访问p
            if(p!=null){
                //访问P
                res.add(p.val);
                stack.push(p);
                p=p.left;
            }
            //p如果为空，就弹出一个结点，并置p为弹出结点的右节点
            else{
                p = stack.pop();
                p=p.right;
            }
        }
        return res;
    }

    //后序遍历代码

}
