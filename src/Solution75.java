import org.junit.Test;

public class Solution75 {
    public void sortColors(int[] nums) {
        if(nums==null||nums.length<=1) return ;
        //调整0
        int left = 0,right = nums.length-1;
        while(left<right){
            while(left<right&&nums[right]!=0) right--;
            while(left<right&&nums[left]==0) left++;
            int tem = nums[right];
            nums[right] = nums[left];
            nums[left] = tem;
        }
        right=nums.length-1;
        if(nums[left]==0)
            left++;
        while(left<right){
            while(left<right&&nums[right]!=1) right--;
            while(left<right&&nums[left]==1) left++;
            int tem = nums[right];
            nums[right] = nums[left];
            nums[left] = tem;
        }
    }

    @Test
    public void test1(){
        int[] nums = {2,1};
        sortColors(nums);
        for(int i = 0 ; i< nums.length; i ++){
            System.out.printf("%d ", nums[i]);
        }
    }
}
