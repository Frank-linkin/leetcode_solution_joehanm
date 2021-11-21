import org.junit.Test;

public class Solution581 {
    public int findUnsortedSubarray(int[] nums) {
        if(nums == null || nums.length ==1 ||nums.length  == 1) return 0;
        int left = -1,right = -1;
        int min=Integer.MAX_VALUE ;
        boolean asending = true;
        for(int i = 1 ; i < nums.length ; i++){
            if(asending==true&&nums[i]<nums[i-1]){
                asending =false;
                min = nums[i];
            }
            if(asending == false){
                min = min > nums[i]?nums[i]:min;
            }
        }
        if(asending==true){
            return 0;
        }
        for(int i = 0 ; i<nums.length ; i++){
            if(nums[i]>min){
                left = i;
                break;
            }
        }

        asending = true;
        int max=Integer.MIN_VALUE;
        for(int i = nums.length -2 ; i >= 0 ; i--){
            if(asending==true&&nums[i]>nums[i+1]){
                asending = false;
                max = nums[i];
            }
            if(asending==false){
                max = max<nums[i]?nums[i]:max;
            }
        }
        for(int i = nums.length-1 ; i>=0;i--){
            if( nums[i]<max ){
                right = i;
                break;
            }
        }
        return (right - left +1);
    }

    @Test
    public void test1(){
        int[] data = {3,2,1};
        System.out.println(findUnsortedSubarray(data));
    }
}
