import org.junit.Test;

import java.util.*;

public class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resp =new ArrayList<List<Integer>>();
        if(nums==null||nums.length==0) {
            return resp;
        }
        LinkedList<Integer> now = new LinkedList<>();
        Arrays.sort(nums);
        generateSubsets(nums,0,resp,now);
        return resp;
    }

    private void generateSubsets(int[] nums,int index,List<List<Integer>> resp,LinkedList<Integer> now) {
        if(index == nums.length) {
            resp.add(new LinkedList(now));
            return;
        }
        int nextIndex = index+1;
        while(nextIndex<nums.length&&nums[nextIndex]==nums[index]){
            nextIndex++;
        }

        generateSubsets(nums,nextIndex,resp,now);
        now.addLast(nums[index]);
        generateSubsets(nums,nextIndex,resp,now);
        now.pollLast();
    }

    @Test
    public void test1(){
        int[] data = {1,2,3,2,3};
        System.out.println(subsets(data));
    }
    /**
     * 思路：
     *      对于一个集合nums，先排序。
     *      对于一个新的nums[i]
     *          考虑，加进集合里，然后寻找下一个字母j
     *          考虑，不加到集合里，然后寻找下一个字母j
     *
     */

}
