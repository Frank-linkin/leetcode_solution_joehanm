package Arrays;

import java.util.Map;

public class Solution128 {
    public int missingNumber(int[] nums) {
        int i = 0;
        int max  = 0;
        for(i=0;i<nums.length;i++){
            if(nums[i]>max){
                max = nums[i];
            }
        }

        boolean[] flag = new boolean[max];
        for(i=0;i<nums.length;i++){
            flag[nums[i]]=true;
        }

        for(i=0;i<flag.length;i++){
            if(flag[i]==false){
                return i;
            }
        }
        return 0;
    }
}
