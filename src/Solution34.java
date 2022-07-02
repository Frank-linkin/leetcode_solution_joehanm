public class Solution34 {
    //17:40 18:05
    public int[] searchRange(int[] nums, int target) {
        int[] resp = {-1,-1};
        if(nums==null||nums.length==0) {
            return resp;
        }
        //查找target
        int left = 0 ,right = nums.length-1;
        int mid=left+((right-left)>>1);
        while(left<=right) {
            mid = left+((right-left)>>1);
            if(nums[mid]>target) {
                right = mid-1;
            }else if(nums[mid]<target){
                left =mid+1;
            }else{
                break;
            }
        }
        if(nums[mid]!=target){
            return resp;
        }
        //查找比target小的最后一个数
        left= 0;
        right = nums.length-1;
        while(left<right) {
            mid = left+((right-left+1)>>1);
            if(nums[mid]>=target) {
                right = mid-1;
            }else if(nums[mid]<target){
                left =mid;
            }
        }
        System.out.printf("left=%d,right= %d",left,right);
        if(nums[0]!=target){
            resp[0] = right+1;
        }else{
            resp[0] = 0;
        }


        //
        left= 0;
        right = nums.length-1;
        while(left<right) {
            mid = left+((right-left)>>1);
            if(nums[mid]>target) {
                right = mid;
            }else if(nums[mid]<=target){
                left =mid+1;
            }
        }
        if(nums[nums.length-1]==target){
            resp[1] =nums.length-1;
        }else{
            resp[1] =left-1;
        }
        return resp;
    }

    public static void main(String[] args) {
        Solution34 solution34 = new Solution34();

        int[] nums = {1,2,2,3,3,3,4};
        int target = 4;
        int[] res = solution34.searchRange(nums, target);
        System.out.printf("[ %d , %d ]",res[0],res[1]);
    }
    /**
     * 思路：
     *    left ,right mid
     *    先找target看看有没有
     *    有的话 找小于它的最后一个数和大于它的第一个数
     *    小于它的最后一个数
     *    mid=(left+right+1)>>1
     *    if( nums[mid] < target ){
     *        left=mid
     *    }else if(nums[mid]>target){
     *        right = mid-1;
     *    }else{
     *
     *    }
     */
}
