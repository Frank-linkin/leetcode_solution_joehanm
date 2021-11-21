package NowCoder;

import java.util.HashMap;
import java.util.TreeMap;

public class Wangyi_2 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(3);
        Wangyi_2 a = new Wangyi_2();
        int[] res = a.getColMax(node2);
        for(int p :res){
            System.out.println(p);
        }
    }

    public int[] getColMax (TreeNode root) {
        // write code here
        if(root==null)
            return null;
        TreeMap<Integer,Integer> maxOne = new TreeMap<Integer,Integer>();
        calculateMax(maxOne,root,0);
        int[] res = new int[maxOne.size()];
        int i = 0 ;
        for(Integer c : maxOne.keySet()){
            res[i++] = maxOne.get(c) ;
        }
        return res;
    }

    //被Treemap加x轴信息，并更新maxOne;
    public void calculateMax(TreeMap<Integer,Integer> maxOne,TreeNode root,int x){
        if(root==null){
            return;
        }
        if(!maxOne.containsKey(x)){
            maxOne.put(x,root.val);
        }
        else if(maxOne.get(x)<root.val){
            maxOne.put(x,root.val);
        }

        calculateMax(maxOne,root.left,x-1);
        calculateMax(maxOne,root.right,x+1);
    }
}
