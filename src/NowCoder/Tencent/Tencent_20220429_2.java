package NowCoder.Tencent;

import dataStructrue.TreeNode;
import org.junit.Test;

import java.util.ArrayList;

public class Tencent_20220429_2 {

    public ArrayList<TreeNode> rootList = new ArrayList<>();
    public int max = 0;
    public ArrayList<TreeNode> deleteLevel (TreeNode root, ArrayList<Integer> a) {

        // write code here
        boolean[] toDelete = new boolean[30];
        for(Integer p:a){
            toDelete[p]=true;
            max = max<p?p:max;
        }

        preOrder(root,1,toDelete);
        if (toDelete[1]==false){
            rootList.add(root);
        }
        ArrayList<TreeNode> resp = new ArrayList<>();
        for(int i = rootList.size()-1; i>=0;i--){
            resp.add(rootList.get(i));
        }
        return resp;
    }
    public TreeNode preOrder(TreeNode root,int depth,boolean[] toDelete){
        if (depth>max){
            return root;
        }

        if(root.left!=null){
            root.left=preOrder(root.left,depth+1,toDelete);
        }
        if(root.right!=null){
            root.right=preOrder(root.right,depth+1,toDelete);
        }
        if(toDelete[depth]){
            if(root.left!=null){
                rootList.add(root.left);
            }
            if(root.right!=null){
                rootList.add(root.right);
            }
            return null;
        }
        return root;
    }
}
