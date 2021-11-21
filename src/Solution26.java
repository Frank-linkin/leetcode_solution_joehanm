import org.junit.Test;

public class Solution26 {
    public int removeDuplicates(int[] nums) {
        int overlap=0;
        for(int i = 1 ; i<nums.length ;i++){
            if(nums[i]==nums[i-1]) overlap++;
            if(i==nums.length-1||nums[i]!=nums[i+1]){
                nums[i-overlap] = nums[i];
            }
        }
//        for(int i= 0 ; i < nums.length ;i++){
//            System.out.printf("%d ",nums[i]);
//        }
//        System.out.println();
        return nums.length-overlap;
    }

    @Test
    public void test1(){
        int[] data = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(data));
    }
}
