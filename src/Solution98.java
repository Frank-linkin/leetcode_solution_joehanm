import dataStructrue.TreeNode;
import org.omg.PortableInterceptor.INACTIVE;

public class Solution98 {
    public boolean isValidBST(TreeNode root) {
        return isValid(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public boolean isValid(TreeNode root,int bottom,int top){//bottom存放下限,top存储上限
        if(root==null) return true;
        System.out.printf("%d ",root.val);
        if(root.val== Integer.MAX_VALUE&&root.right!=null) return false;
        if(root.val== Integer.MIN_VALUE&&root.left!=null) return true;
        if(root.val<bottom||root.val>top)
            return false;
        boolean valid = true;
        if(root.left!=null&&!isValid(root.left,bottom,root.val-1)){
            valid=false;
        }
        if(root.right!=null&&!isValid(root.right,root.val+1,top)){
            valid=false;
        }
        return valid;
    }
}
