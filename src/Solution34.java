public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        if(nums==null||nums.length==0){
            return res;
        }
        if(target<nums[0]||target>nums[nums.length-1]){
            return res;
        }
        if(nums.length==1){
            res[0]=0;res[1]=0;
            return res;
        }

        int left = 0 ,right = nums.length-1;
        int mid = -1;
        while(left<=right){
            mid = ((right-left)>>1)+left;
          //  System.out.printf("(%d+%d)/1=%d\n",left,right,mid);
            if(nums[mid] == target){
                if(nums[left] == target&&nums[right]==target){
                    res[0]=left;res[1]=right;
                    return res;
                }
                else if(nums[left]==target){
                    right--;
                }
                else if(nums[right]==target){
                    left++;
                }
                else{
                    right--;left++;
                }
            }
            else if(nums[mid]>target){
                right = mid-1;
            }
            else {
                left = mid +1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution34 solution34 = new Solution34();

        int[] nums = {1,2,2,3,3,3,4};
        int target = 3;
        int[] res = solution34.searchRange(nums, target);
        System.out.printf("[ %d , %d ]",res[0],res[1]);
    }
}
