import org.junit.Test;

public class Solution75 {

    public void sortColors(int[] nums) {
        if( nums == null || nums.length ==  0 ) {
            return;
        }
        int left = -1,right = nums.length;
        for(int i = 0 ; i < right ; i++ ) {
            while(left<i&&i<right&&(nums[i] == 2||nums[i]==0)) {
                if(nums[i]==2){
                    right--;
                    swap(nums,right,i);
                }
                if(nums[i] == 0 ) {
                    left++;
                    swap(nums,left,i);
                }
            }
        }
    }

    public void swap(int[] nums,int m,int n) {
        if(nums[m]!=nums[n]){
            nums[m] = nums[m]^nums[n];
            nums[n] = nums[m]^nums[n];
            nums[m] = nums[m]^nums[n];
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
    /**
     * 将解法写在Test函数下面，实在写不出来再看。
     * 特殊情况：
     *  ①只有两种或一种颜色
     *
     * 方法一：
     *      第一次遍历把0放在最前面
     *      第二次遍历把1放在0的后面
     *  时间复杂度O(2n)
     *  空间复杂度O(1)
     *  方法二：
     *          两个指针left和right，left表示0的边界，right表示2的边界
     *          left = -1 right = nums.length
     *          这里还用了swap的一个Trick
     */

}
