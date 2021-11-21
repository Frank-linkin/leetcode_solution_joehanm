import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        generateSet(nums,res,cur,0);
        return res;
    }

    public void generateSet(int[] nums,List<List<Integer>> res,List<Integer> cur,int index){
        if(index>=nums.length){
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        generateSet(nums,res,cur,index+1);
        cur.add(nums[index]);
        generateSet(nums,res,cur,index+1);
        cur.remove(new Integer(nums[index]));
    }

    @Test
    public void test1(){
        int[] data = {1,2,3};
        System.out.println(subsets(data));
    }

}
