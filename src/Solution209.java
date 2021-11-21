import org.junit.Test;

public class Solution209 {
    public int minSubArrayLen1(int target, int[] nums) {
        if(nums==null) return 0;
        if(nums.length == 0) return 0;
        if(nums.length == 1){
            return nums[0]>target?1:0;
        }

        int left=0, right = 0;
        int sum = nums[0];
        int min_interval = nums.length+1;
        while(true){
            while(sum<target&&right<nums.length){
                right++;
                if(right>=nums.length) break;
                sum+=nums[right];
            }
            if(right>=nums.length) break;

            while(left<=right&&sum>=target){
                sum-=nums[left];
                left++;
            }

            if(left>right) return 1;
            if(right-left+2<min_interval){
                min_interval=right-left+2;
            }
        }
        if(min_interval==nums.length+1) return 0;//全部加起来都不够
        return min_interval;
    }

    public int minSubArrayLen(int target, int[] nums) {
        if(nums==null) return 0;
        if(nums.length == 0) return 0;
        if(nums.length == 1){
            return nums[0]>target?1:0;
        }

        if(nums[0]>=target){
            return 1;
        }
        int min = nums.length+1;
        int dp1[] = new int[nums.length];
        int dp2[] = new int[nums.length];
        int sum = nums[0];
        dp1[0] = nums[0];
        dp2[0] = (nums[0]>=target?nums[0]:0);
        for(int i = 1 ; i < nums.length ; i++){
            dp1[i] = dp1[i-1]+nums[i];
            if(dp1[i]>=target){
                dp2[i]=dp2[i-1]+1;
                if(dp2[i-1]==0){
                    for(int j = i-1;j>=0&&dp2[j]==0;j--){
                        dp2[i]++;
                    }
                }
            }

            //对dp1和dp2处理
            for(int j=i-dp2[i]+1;j<i;j++){
                if(dp1[i]-nums[j]>=target){
                    dp1[i] = dp1[i]-nums[j];
                    dp2[i]--;
                }
                else
                    break;
            }

            if(dp2[i] == 1){
                return 1;
            }
            if(dp2[i]>0&&dp2[i]<min){
                min = dp2[i];
            }
        }

        for(int i = 0 ; i<dp1.length;i++){
            System.out.printf("%d ",dp1[i]);
        }
        System.out.println();
        for(int i = 0 ; i<dp2.length;i++){
            System.out.printf("%d ",dp2[i]);
        }
        System.out.println();

        if(min == nums.length+1) return 0;
        return min;
    }

    @Test
    public void test1(){
        int[] nums = {10,2,3};
        int target = 6;
        System.out.println(minSubArrayLen(target,nums));
    }
}
