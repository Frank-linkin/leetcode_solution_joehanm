import org.junit.Test;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.*;

public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resp = new ArrayList<List<Integer>>();
        if ( nums == null || nums.length < 3) {
            return resp;
        }

        Arrays.sort(nums);
        ArrayList<Integer> now = new ArrayList<Integer>();
        int pos = 0;
        int left = 0,right = 0;
        while(pos < nums.length-2) {
            left = pos+1;
            right = nums.length - 1;

            while(left<right) {
                if(nums[left]+nums[right]+nums[pos]>0) {
                    int tem = nums[right];
                    while(left<right&&nums[right]==tem){
                        right--;
                    }
                }
                else if(nums[left]+nums[right]+nums[pos]<0){
                    int tem = nums[left];
                    while(left<right&&nums[left] == tem) {
                        left++;
                    }
                }else{
                    now.add(nums[left]);
                    now.add(nums[right]);
                    now.add(nums[pos]);
                    resp.add(new ArrayList<Integer>(now));
                    now.clear();

                    int tem = nums[left];
                    while(left<right&&nums[left] == tem) {
                        left++;
                    }
                    tem = nums[right];
                    while(left<right&&nums[right]==tem){
                        right--;
                    }
                }
            }
            int tem = nums[pos];
            while(pos<nums.length-2&&nums[pos]==tem) {
                pos++;
            }
        }
        return resp;
    }
    @Test
    public void test1(){
        int[] data = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(data));
    }
}
