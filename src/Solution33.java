import com.sun.org.apache.bcel.internal.generic.LDIV;

public class Solution33 {
    //17:03
    public int search(int[] nums, int target) {
        if(nums==null||nums.length==0) {
            return -1;
        }
        return searchCore(nums,target,0,nums.length-1);
    }
    public int searchCore(int[] nums,int target,int left,int right) {
        if(left<=right) {
            int mid = ((right-left)>>1)+left;
            if(target>nums[mid]){
                return searchCore(nums,target,mid+1,right);
            }else if(target< nums[mid] ) {
                int leftRes = searchCore(nums,target,left,mid-1);
                int rightRes = searchCore(nums,target,mid+1,right);
                if(leftRes!=-1){
                    return leftRes;
                }else{
                    return rightRes;
                }
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution33 solution33 = new Solution33();

//        int[] data = {4,5,6,7,0,1,2};
        int[] data = {1,2,3,4,5,6,7};
        int target = 5;
        System.out.println(solution33.search(data, target));
    }

    /**
     * 思路：二分查找
     *  left,right
     *      mid = (right+left)/2
     *      if(target > mid ) {
     *          left = mid+1
     *      }
     *      if(targe < mid ){
     *          //分别查找左右区间
     *      }
     *
     */

}
