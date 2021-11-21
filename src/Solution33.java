import com.sun.org.apache.bcel.internal.generic.LDIV;

public class Solution33 {
    public int search(int[] nums, int target) {
        //对边界条件进行处理
        if(nums==null || nums.length==0){
            return -1;
        }
        if(nums.length==1){
            if(target == nums[0]){
                return 0;
            }
            return -1;
        }

        //实现算法主体
        return divideAndConquer(nums,target,0,nums.length-1);
    }
    public int divideAndConquer(int[] nums,int target,int left , int right){
        if(left>right){
            return -1;
        }


        int mid = (right-left)/2+left;
        if(nums[mid] == target){
            return mid;
        }

        if(mid==left){//相当于把问题的最小子规划划为2
            if(nums[left]==target){
                return left;
            }
            else if(nums[right] == target){
                return right;
            }
            else{
                return -1;
            }
        }


        if( nums[mid]>=nums[left] && nums[mid]<nums[right] ){//第一种情况
            if(target<nums[mid]){
                return divideAndConquer(nums,target,left,mid-1);
            }
            else{
                return divideAndConquer(nums,target,mid+1,right);
            }

        }
        else if(nums[mid]>nums[left]){ //第二种情况
            if( target <nums[mid]&&target>=nums[left] ){
                return divideAndConquer(nums,target,left,mid-1);
            }
            else{
                return divideAndConquer(nums,target,mid+1,right);
            }
        }
        else{
            if(target<=nums[right]&&target>nums[mid]){
                return divideAndConquer(nums,target,mid+1,right);
            }
            else{
                return divideAndConquer(nums,target,left,mid-1);
            }
        }
    }

    public static void main(String[] args) {
        Solution33 solution33 = new Solution33();

        int[] data = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(solution33.search(data, target));
    }
}
