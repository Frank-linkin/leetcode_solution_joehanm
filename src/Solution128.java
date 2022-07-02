import org.junit.Test;

import java.util.Arrays;
import java.util.BitSet;


public class Solution128 {
    /**
     * 这种在nums=9 9999 9999的情况下，会创建9 9999 9999*2长度的数组会超过空间复杂度。所以，显然是不合适的
     * @param nums
     * @return
     */
    public int longestConsecutive_SpaceComplexityOverweight(int[] nums) {
       if(nums==null||nums.length==0){
           return 0;
       }
       int maxLen = 1;
       int maxValue = 1<<31;
       int minValue = 0x7fffffff;
       // System.out.println(maxValue);
       for(int a : nums){
           maxValue = maxValue>a?maxValue:a;
           minValue = minValue<a?minValue:a;
       }
       int[] dp;
       int offset = 0;
       if (maxValue>-minValue){
           offset = maxValue+1;
           dp= new int[(maxValue+1)<<1];
       }else{
           dp= new int[((-minValue)+1)<<1];
           offset = (-minValue)+1;
       }
       // System.out.printf("minValue=%d,offset=%d",minValue,offset);
       for(int a:nums){
           if(dp[a+offset]==0){
               //
               if(a==maxValue){
                   dp[a+offset] = 1;
               }else{
                   dp[a+offset] = dp[a+offset+1]+1;
               }

               if(a+offset-1!=0){
                   int p = a+offset-1;
                   while(p>=0&&dp[p]!=0){
                       dp[p] = dp[a+offset]+(a+offset-p);
                       maxLen = maxLen<dp[p]?dp[p]:maxLen;
                       p--;
                   }
               }
               maxLen = maxLen<dp[a+offset]?dp[a+offset]:maxLen;
           }
       }
       return maxLen;
    }

    /**
     * 这道题最值得注意的就是，题目给的数组可能我们经过去重处理后会更好做，并且使用了HashSet数据结构。
     */

    @Test
    public void test1(){
        int[] nums = {0,1,2,4,8,5,6,7,9,3,55,88,77,99,999999999};
        System.out.println(longestConsecutive_SpaceComplexityOverweight(nums));

    }
}
