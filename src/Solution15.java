import org.junit.Test;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.*;

public class Solution15 {
    //version1 2021/04
    public List<List<Integer>> threeSum_version1(int[] nums) {
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

    /**
     * version2 2021年12月11日10:57:41
     *
     * 将数组元素装入hash表中，然后从n个元素中抽取两个a,b，将a,b去掉一次，看他们和的相反数在不在hash表里
     * 还有一个关键问题是去重：
     *    第一种方法：将数组先排序，重复的数组略过
     *    第二种方法：如果这个数字处理过，就不考虑这个数字了，count[a]=0
     * @param nums
     * @return
     */
    final int MOVE = 10000;
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> resp = new ArrayList<>();
        if(nums == null || nums.length < 2 ){
            return resp;
        }


        ArrayList<Integer> group = new ArrayList<>();
        ArrayList<int[]> clearNums = new ArrayList<>();
        int[] kv = new int[2];
        int max = -1;
        int min = 1;
        for (int i = 0 ; i < nums.length ; i ++ ){
            max = max>nums[i]?max:nums[i];
            min = min<nums[i]?min:nums[i];
        }
        int[] count = new int[(max>(-min)?max:-min) + MOVE+1];
        for (int i = 0; i < nums.length ; i++){
            count[nums[i] + MOVE]++;
        }
        for(int i = 0 ;i < nums.length ;i++){
            for(int j = i+1 ; j<nums.length;j++){
                if(count[nums[i]+MOVE]>0&&count[nums[j]+MOVE]>0) {
                    count[nums[i] + MOVE]--;
                    count[nums[j] + MOVE]--;

                    int target = -(nums[i] + nums[j]);
                    if (target >= min && target <= max) {
                        if (count[target + MOVE] > 0) {
                            group.add(nums[i]);
                            group.add(nums[j]);
                            group.add(target);
                            resp.add(new ArrayList<Integer>(group));
                            group.clear();
                        }
                    }
                    count[nums[i] + MOVE]++;
                    count[nums[j]+MOVE] = 0;
                }
            }
            clearNums.clear();
            count[nums[i]+MOVE]=0;
        }
        return resp;
    }

    @Test
    public void test1(){
        int[] data = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(data));
    }
}
