import org.junit.Test;

import java.util.Arrays;

public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null|| nums.length <3) {
            return target;
        }

        Arrays.sort(nums);
        int pos = 0;
        int minDistance = 0x7fffffff;
        //System.out.println(minDistance);
        int sum = -1;
        while(pos< nums.length -2 ) {
            int left = pos + 1;
            int right = nums.length -1;


            while(left<right) {
                int curSum = nums[left]+nums[right]+nums[pos];
                if(curSum < target) {
                    if( minDistance > (target-curSum)) {
                        minDistance = target - curSum;
                        sum = curSum;
                    }

                    int tem = nums[left];
                    while(left<right&&nums[left]==tem){
                        left++;
                    }
                }
                else{
                    if(minDistance>(curSum- target)) {
                        minDistance = curSum - target;
                        sum = curSum;
                    }

                    int tem = nums[right];
                    while(left<right&& nums[right]==tem ) {
                        right--;
                    }
                }
            }

            int tem = nums[pos];
            while(nums[pos] == tem) {
                pos++;
            }
        }
        return sum;
    }

    @Test
    public void test1(){
        int[] data  = {-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(data,target));

    }
}
