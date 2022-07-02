import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

public class Solution90 {
    /**
     * [Enlightening] [Remove duplication]
     * 提供了一种好用的去重的方法。比如[1,2,2]中，我们选择若干个数添加入集合。而我们去掉重复的集合，比如[1,2],[1,2]
     * 可以采取的规则是 判断nums[index]与nums[index-1]。如果nums[index-1]没有加入集合，那么nums[index]也不
     * 用加入集合。
     * 因为当nums[index-1]加入集合之后，nums[index]可以加入集合，也可以不加入集合。而如果nums[index-1]没有加入集合
     * ，则不论nums[index]加入不加入都与前面所述的情况重复。
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        LinkedList<Integer> cur = new LinkedList<>();
        LinkedList<List<Integer>> result = new LinkedList<>();
        if(nums==null||nums.length==0){
            return result;
        }
        Arrays.sort(nums);
        searchSubSet(result,cur,nums,0,false);
        return result;
    }

    public void searchSubSet(LinkedList<List<Integer>> result,LinkedList<Integer> cur,int[] nums,int index,boolean select){
        if (index==nums.length){
            result.add(new LinkedList<Integer>(cur));
            return;
        }

        if(index>0&&nums[index]==nums[index-1]&&!select){
            searchSubSet(result,cur,nums,index+1,false);
            return;
        }


        searchSubSet(result,cur,nums,index+1,false);

        cur.addLast(nums[index]);
        searchSubSet(result,cur,nums,index+1,true);
        cur.pollLast();
    }

    @Test
    public void test1(){
        int[] data ={1,2,2};

    }
}
