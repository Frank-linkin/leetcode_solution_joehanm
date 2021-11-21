import org.junit.Test;

import java.util.Arrays;

public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        //边界条件处理
        //if( nums == null ) return 0; //这个不同了，因为每组输入都只有唯一正确答案
        Arrays.sort(nums);


        int res = 0;
        int res1 =0;
        int result;
        for(int i = 0 ; i < nums.length-2 ; i++){
            int left = i+1,right = nums.length -1;
            res = (nums[i]+nums[right]+nums[right])>target?(nums[i]+nums[right]+nums[left]-target):(target-(nums[i]+nums[right]+nums[left]));
            System.out.printf("%d + %d +%d - %d = %d\n",nums[i],nums[left],nums[right],target,res);
            while(true){
                if(left>=right) break;
                result = nums[i]+nums[left]+nums[right];
                if( result > target){
                    res = res<(result-target)?res:(result-target);
                    System.out.printf("%d + %d +%d - %d = %d\n",nums[i],nums[left],nums[right],target,res);
                    right--;
                }
                if( result < target){
                    res = res<(target-result)?res:(target-result);
                    System.out.printf("%d + %d +%d - %d = %d\n",nums[i],nums[left],nums[right],target,res);

                    left++;
                }
                if(result ==target)
                    return 0;
            }
        }
        return res;
    }

    @Test
    public void test1(){
        int[] data  = {-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(data,target));

    }
}
