import org.junit.Test;

import java.util.Arrays;
import java.util.BitSet;


public class Solution128 {
    public int longestConsecutive(int[] nums) {
        if(nums== null || nums.length ==0) {
            return 0;
        }
        int max = 1<<31;
        int min = 0x7fffffff;
        for(int i = 0 ; i < nums.length ; i++ ) {
            max = nums[i]>max?nums[i]:max;
            min = nums[i]<min?nums[i]:min;
        }

        BitSet positiveBitMap = new BitSet(max);
        BitSet negativeBitMap = null;
        if(min<0){
            negativeBitMap = new BitSet(-min);
        }
        for(int i =0 ; i < nums.length ; i++ ) {
            if(nums[i]>=0) {
                positiveBitMap.set(nums[i]);
            }
            else{
                negativeBitMap.set(-nums[i]);
            }
        }

        int maxLen = 0;
        for(int i = 0 ; i< nums.length ; i++){
            int len = 0;
            if(nums[i]>=0) {
                int tem = nums[i];
                while(tem<=max&&positiveBitMap.get(tem)){
                    tem++;
                    len++;
                }
                maxLen = maxLen<len?len:maxLen;
            }
            else{
                int tem = -nums[i];
                while(tem>=1&&negativeBitMap.get(tem)){
                    tem--;
                    len++;
                }
                if(tem == 0) {
                    while(tem<=max&&positiveBitMap.get(tem)){
                        tem++;
                        len++;
                    }
                }
                maxLen = maxLen<len?len:maxLen;
            }
        }
        return maxLen;
    }

    @Test
    public void test1(){
        int[] nums = {-7,-1,3,-9,-4,7,-3,2,4,9,4,-9,8,-7,5,-1,-7};
        Arrays.sort(nums);
        for(int a : nums){
            System.out.printf("%d ",a);
        }
        System.out.println();
        System.out.println(longestConsecutive(nums));

    }
}
