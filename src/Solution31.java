import java.util.*;

public class Solution31 {
    public void nextPermutation(int[] nums) {
        if(nums==null || nums.length <= 1) {
            return;
        }

        int i = nums.length-2;
        for(;i>=0&&nums[i]>=nums[i+1];i--) {
        }
        if(i==-1){
            Arrays.sort(nums);
        }

        int p=nums.length-1;
        while(nums[p]<=nums[i]){
            p--;
        }
        //交换p和i;
        int tem = nums[p];
        nums[p] = nums[i];
        nums[i] = tem;

        Arrays.sort(nums,i+1,nums.length-1);
    }
    /**
     * 思路：
     *      给定一个数组3,5,9,4,7
     *          找到从后往前的最长递增数列，这里为7
     *      换一个
     *          4,9,6,8,5,5
     *
     *      极端情况
     *          5,5,5,5,5
     */
}
