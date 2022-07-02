package NowCoder.Tencent;

import dataStructrue.TreeNode;
import org.junit.Test;
import utils.TreeBuilder;

import java.util.*;

/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 *   public TreeNode(int val) {
 *     this.val = val;
 *   }
 * }
 */
public class Tencent_20220429_1 {
    public int max = 0;
    public ArrayList<TreeNode> rootList = new ArrayList<>();
    //java不支持下面这种格式的ArrayList数组的声明，会报generic array creation错误
    //public ArrayList<TreeNode>[] subRootList=new ArrayList<TreeNode>[1000];
    //必须使用下面这种方式，先用通配符创造一个ArrayList<?>[]然后强转成ArrayList<TreeNode>
    //public ArrayList<TreeNode>[] subRootList=(ArrayList<TreeNode>[])new ArrayList<?>[1000];
    public ArrayList<TreeNode>[] subRootList;

    public ArrayList<TreeNode> deleteLevel (TreeNode root, ArrayList<Integer> a) {
        // write code here
        boolean[] toDelete = new boolean[30];

        for(Integer p:a){
            toDelete[p]=true;
            max = max<p?p:max;
        }
        subRootList =(ArrayList<TreeNode>[])new ArrayList<?>[max+1];
        preOrder(root,1,toDelete);
        if (toDelete[1]!=true){
            subRootList[1] = new ArrayList<TreeNode>();
            subRootList[1].add(root);
        }

        a.sort((Integer p,Integer q)->(p-q));

        ArrayList<TreeNode> resp = new ArrayList<>();
        if (toDelete[1]!=true){
            resp.add(root);
        }
        for(Integer m :a){
            resp.addAll(subRootList[m]);
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
            if (subRootList[depth] == null) {
                subRootList[depth] = new ArrayList<>();
            }
            if(root.left!=null){
                subRootList[depth].add(root.left);
            }
            if(root.right!=null){
                subRootList[depth].add(root.right);
            }
            return null;
        }
        return root;
    }

    @Test
    public void test1(){
        int[] data = new int[3];
        int[] treeData = {1,2,-1,3,4,-1,-1,5,6,7,8,-1,-1,-1,-1,9,10};
        TreeNode[] tree=TreeBuilder.buildTreeInArray(treeData);
        ArrayList<Integer> deleteLevel = new ArrayList<>();
        deleteLevel.add(2);
        deleteLevel.add(4);
        ArrayList<TreeNode> resp = deleteLevel(tree[0],deleteLevel);
        for(TreeNode a: resp){
            System.out.printf("%d ",a.val);
        }
    }

    @Test
    public void test2(){
        //普通的[]数组需要使用arrays.sort(targetArray,comparator)进行排序
        //list数组使用.sort(comparator)方法排序
        int[] data = {1,5,2,3,4};
        TreeNode[] nodes = new TreeNode[5];
        for(int i = 0 ; i< data.length ; i++) {
            nodes[i] = new TreeNode(data[i]);
        }
        System.out.printf("排序前:");
        for(TreeNode a : nodes){
            System.out.printf("%d ",a.val);
        }
        System.out.println();
        //排序
        Arrays.sort(nodes,(TreeNode m,TreeNode n)-> {
            return n.val-m.val;
        });
        System.out.printf("排序后:");
        for(TreeNode a : nodes){
            System.out.printf("%d ",a.val);
        }
        System.out.println();

        //LinkedList,ArrayList本身带有sort(comparator函数)
        LinkedList<TreeNode> list = new LinkedList<>();
        for(int p:data){
            list.addLast(new TreeNode(p));
        }
        System.out.printf("排序前:");
        for(TreeNode a : list){
            System.out.printf("%d ",a.val);
        }
        System.out.println();
        //排序
        list.sort((TreeNode m,TreeNode n)->{
            return n.val-m.val;
        });
        System.out.printf("排序后:");
        for(TreeNode a : list){
            System.out.printf("%d ",a.val);
        }
        System.out.println();

//        排序前:1 5 2 3 4
//        排序后:5 4 3 2 1
//        排序前:1 5 2 3 4
//        排序后:5 4 3 2 1
    }
}
