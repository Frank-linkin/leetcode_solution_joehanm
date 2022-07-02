import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class Solution1673 {
    public int[] mostCompetitive(int[] nums, int k) {
        if(nums==null||nums.length==0) {
            return null;
        }

        int[] data = new int[k];
        int i = 0;
        LinkedList<Integer> index =new LinkedList<>();

        return data;
    }


    @Test
    public void test1(){
        int[] data = {2,4,3,3,5,4,1,2};
        int k = 4;
        int[] res = mostCompetitive(data,k);
        for(int a:res){
            System.out.printf(" %d",a);
        }
        //2,7,3,2
        // 5,1,2
    }
    /**
     * 建立一个数组，data[]
     * 首先用nums的前k个数填充这个数组
     * 然后向后遍历nums
            对于每个nums[i]
                遍历data,对于每个data[j]
                    检查data[j]是不是小于data[j-1],是的话，
                        把data[j-1]清除掉，并在末尾补上nums[i]
                如果data已经单调递增
                    比较data[len-1]和nums[i]
                    if   nums[i]<data[len-1]
                        就替换掉

     *
     */
}
