package utils;

import dataStructrue.TreeNode;
import org.junit.Test;

public class TreeBuilder {
    /**
     * 空用-1表示
     *     3
     *  5      1
     *        2  7
     *  的序列应该是：[-1,3,5,1,-1,-1,2,7]
     *  nums[0]不使用
     * @param nums
     * @return
     */
    public static TreeNode buildTree(int[] nums){
        return buildCore(nums,1);
    }

    public static TreeNode buildCore(int[] nums,int index) {
        if(index>=nums.length||nums[index]==-2147483648) {
            return null;
        }

        TreeNode newNode = new TreeNode(nums[index]);
        newNode.left = buildCore(nums,index*2);
        newNode.right = buildCore(nums,index*2+1);
        return newNode;
    }

    /**
     * 数组按层序输入
     * -1表示该位置为空，从0开始
     * 返回一个树，根节点是Nodes[0]，
     * @param nums
     * @return
     */
    public static TreeNode[] buildTreeInArray(int[] nums) {
        if(nums == null || nums.length==0 ) {
            System.out.println("Error,传入数组为空");
            return null;
        }

        TreeNode[] nodes = new TreeNode[nums.length];
        for(int i = 0 ; i< nums.length; i++) {
            if(nums[i]!=-1) {
                nodes[i] = new TreeNode(nums[i]);
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(nodes[i]!=null) {
                int left = 2*i+1;
                int right = left+1;

                if(left<nums.length) {
                    nodes[i].left = nodes[left];
                }
                if(right<nums.length) {
                    nodes[i].right = nodes[right];
                }
            }
        }
        return nodes;
    }

    @Test
    public void test1(){
        int[] nums = {-2147483648,3,5,1,6,2,0,8,-2147483648,-2147483648,7,4};
        int a = 0x7fffffff;
        System.out.println(a);
        TreeNode root = buildTree(nums);
        System.out.printf("7=%d",root.left.right.left.val);
    }
}
