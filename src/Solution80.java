public class Solution80 {
    /**
     *
     */
    public int removeDuplicates(int[] nums) {
        if( nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return 1;
        }
        if( nums.length ==2 ) {
            return 2;
        }

        int count = 0,pos = 0 ,deleteNum = 0;
        while(pos<nums.length) {
            count = 0;
            int tem = nums[pos];

            while(pos<nums.length&& nums[pos] == tem) {
                count++;

                if(count>2){
                    deleteNum++;
                }
                pos++;
                if(pos<nums.length) {
                    nums[pos-deleteNum] = nums[pos];
                }

            }
        }
        return nums.length - deleteNum;
    }
}
