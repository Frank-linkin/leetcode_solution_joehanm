import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

public class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        LinkedList<List<Integer>> resp = new LinkedList<>();
        if(nums.length<4){
            return resp;
        }

        Arrays.sort(nums);
        int left=0,right=0;
        int lastJ=-1,lastI = -1;
        System.out.println(nums.length);
        for(int i = 0 ; i<nums.length-3;i++){
            if(lastI!=-1&&nums[i]==nums[lastI]){
                continue;
            }
            lastJ = -1;
            for(int j = i+1;j<nums.length -2  ; j++){
                if(lastJ!=-1&&nums[j]==nums[lastJ]){
                    continue;
                }
                left = j+1;
                right = nums.length-1;
                int sum;
                while(left<right){
                    sum = nums[i]+nums[j]+nums[left]+nums[right];

                    if(sum == target){
                        ArrayList<Integer> cur = new ArrayList<>(4);
                        cur.add(nums[i]);
                        cur.add(nums[j]);
                        cur.add(nums[left]);
                        cur.add(nums[right]);
                        resp.add(cur);

                        int lastRight = right;
                        while(left<right&&nums[right]==nums[lastRight]){
                            right--;
                        }
                        int lastLeft = left;
                        while(left<right&&nums[left]==nums[lastLeft]){
                            left++;
                        }
                    }else if(sum > target){
                        int lastRight = right;
                        while(left<right&&nums[right]==nums[lastRight]){
                            right--;
                        }
                    }else if(sum < target){
                        int lastLeft = left;
                        while(left<right&&nums[left]==nums[lastLeft]){
                            left++;
                        }
                    }
                }
                lastJ = j;
            }
            lastI = i;
        }
        return resp;
    }
    @Test
    public void test1(){
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        List<List<Integer>> result=fourSum(nums,target);
        System.out.println(result.toString());
    }
}
