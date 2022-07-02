import org.junit.Test;

public class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        if ( nums == null || nums.length ==0 ) {
            return 0;
        }

        int left = 0,right = 0;
        int curSum = 0;
        int minLen = 0x7fffffff ;
        while(right<nums.length ) {
            curSum += nums[right];
            if(curSum >= target) {
                while(left<=right&&curSum >= target) {
                    curSum -= nums[left];
                    left++;
                }
                left--;
                curSum+=nums[left];
                int curLen = right - left +1 ;
                minLen = minLen < curLen?minLen:curLen;
            }

            right++;
        }
        if(minLen == 0x7fffffff){
            return 0;
        }
        return minLen;
    }


    @Test
    public void test1(){
        int[] nums = {2,2,3};
        int target = 6;
        System.out.println(minSubArrayLen(target,nums));
    }
}
