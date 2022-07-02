import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Sulution662 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution622 {
        public int widthOfBinaryTree(TreeNode root) {
            if(root == null){
                return 0;
            }

            Queue<PosNode> q = new LinkedList<PosNode>();
            q.offer(new PosNode(root,1,1));
            PosNode p;
            int currDepth=1;
            int maxLength=0;
            int leftposition=1;
            while(!q.isEmpty()){
                p=q.poll();
                if(p.node!=null){
                    if(p.d>currDepth){
                        currDepth = p.d;
                        leftposition=p.p;
                    }

                    //System.out.println(p.node.val);
                    q.offer(new PosNode(p.node.left,currDepth+1,2*p.p));
                    q.offer(new PosNode(p.node.right,currDepth+1,2*p.p+1));
                    maxLength=maxLength>(p.p-leftposition)?maxLength:(p.p-leftposition);
                }
            }
            return maxLength+1;
        }
    }

    class PosNode{
        TreeNode node;
        int d;
        int p;
        PosNode(TreeNode node,int depth,int position){
            this.node = node;
            this.d = depth;
            this.p = position;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    @Test
    public void test1(){
        TreeNode eight = new TreeNode(8,null,null);
        TreeNode six = new TreeNode(6,null,null);
        TreeNode seven = new TreeNode(7,null,null);
        TreeNode four = new TreeNode(4,eight,null);
        TreeNode five = new TreeNode(5,six,seven);
        TreeNode two = new TreeNode(2,four,five);
        TreeNode three = new TreeNode(3,null,null);
        TreeNode one = new TreeNode(1,two,three);

        Solution622 s = new Solution622();
        System.out.println(s.widthOfBinaryTree(one));
    }
}
