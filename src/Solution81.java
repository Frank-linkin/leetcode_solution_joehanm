import org.junit.Test;

public class Solution81 {
    /**
     * [Enlightening] [Binary Search]
     * 1.注意>>符号的优先级非常低，int mid = start + ((end -start)>>1)才可以，int mid = start + (end -start)>>1是不可以的。
     * 2.我在第一次写的时候,观察到会对1-46直接进行BinarySearch，Num[1]=6,nums[46]=-5,而我明明设置了if(nums[start] < nums[end])
     * 才进行二分查找的限制。我很困惑为什么会出这个错误。其实答案显而易见，肯定是在别的地方误用了。而我的第一反应是有点烦躁，有点不相信自己，相信
     * 玄学。这显然是不可靠的。所以要相信电脑是理性的，要相信科学。
     */
    public boolean search(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return false;
        }
        return searchCore(nums,target,0,nums.length-1);
    }

    public boolean searchCore(int[] nums,int target,int start, int end){
        if(start>end){
            return false;
        }
        if(nums[start] < nums[end]) {
            System.out.printf("start=%d end=%d",start,end);
            return binarySearch(nums,target,start,end);
        }
        if(nums[start]==target){
            return true;
        }
        if(nums[end] == target){
            return true;
        }

        if(nums[start] == nums[end]){
            start++;
            end--;
            return searchCore(nums,target,start,end);
        }

        int mid = start + ((end -start)>>1);
         System.out.printf("mid=%d start=%d end=%d\n",mid,start,end);
        if(target == nums[mid]){
            return true;
        }
        //return binarySearch(nums,target,start+1,mid-1)||binarySearch(nums, target, mid+1, end-1);
        return searchCore(nums,target,start+1,mid-1)||searchCore(nums, target, mid+1, end-1);
    }

    public boolean binarySearch(int[] nums,int target,int start,int end){
        System.out.printf("binary start=%d end=%d\n",start,end);
        while(start<=end){
            int mid = start+ ((end - start)>>1);
            if (target > nums[mid]) {
                start = mid+1;
            }else if(target < nums[mid]) {
                end = mid -1;
            }else{
                return true;
            }
        }
        return false;
    }


    @Test
    public void test1(){
        int[] data = {6,6,6,6,7, 7,7,7,7,8, 8,8,8,9,9, 9,9,10,10,10, -10,-10,-10,-10,-10, -9,-9,-9,-9,-8 ,-8,-8,-7,-7,-7, -6,-6,-5,-5,-5, -5,-5,-4,-4,-4, -4,-4,-4,-4,-4,-4,-4,-4,-3,-3,-3,-3,-3,-2,-2,-2,-1,-1,-1,-1,0,0,0,0,0,1,1,1,1,2,2,3,3,3,3,3,3,3,3,3,4,4,4,4,4,4,5,5,5,5,5};
        System.out.println(search(data, 8));

//        int a = -1;
//        System.out.println(a%4);
    }
}
