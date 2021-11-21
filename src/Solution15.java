import org.junit.Test;

import java.util.*;

public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        //处理边界条件
        ArrayList<Integer> now = new ArrayList<>();
        ArrayList<List<Integer>> res = new ArrayList<>();
        if(nums == null){
            return res;
        }
        if(nums.length < 3){
            return res;
        }

        //进入函数处理过程
        int start = 0,end=0;
        int result=0;
        Arrays.sort(nums);
        for(int i = 0 ; i<nums.length-2;i++){
            while(i-1>=0&&i<nums.length&&nums[i]==nums[i-1]){
                i++;
            }
            if(i==nums.length)
                break;

            start = i+1;end=nums.length-1;
            while(start<end){
                result = nums[i]+nums[start]+nums[end];
                if(result>0){
                    end--;
                    while(nums[end]==nums[end+1]&&end>0){
                        end--;
                    }
                }

                else if(result<0){
                    start++;
                    while(nums[start]==nums[start-1]&&start<nums.length-1){
                        start++;
                    }
                }
                else{
                    now.add(nums[i]);
                    now.add(nums[start]);
                    now.add(nums[end]);
                  //  System.out.printf("%d %d %d\n",i,start,end);
                    //测试下面哪组语句效率比较高
                    //res.add(new ArrayList<Integer>(now));
                    //now.clear();


                    res.add(now);
                    now = new ArrayList<Integer>();


                    end--;
                    while(nums[end]==nums[end+1]&&end>0){
                        end--;
                    }

                    start++;
                    while(nums[start]==nums[start-1]&&start<nums.length-1){
                        start++;
                    }
                }
            }
        }
        return res;
    }



    @Test
    public void test1(){
        int[] data = {0,0,0,0};
        System.out.println(threeSum(data));
    }
}
