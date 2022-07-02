import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class Solution503 {
    class Data{
        int num;
        int index;

        public Data(int num,int index) {
            this.num = num;
            this.index = index;
        }
    }
    public int[] nextGreaterElements(int[] nums) {
        if(nums==null||nums.length==0) {
            return null;
        }
        int[] nextLarger = new int[nums.length];
        for(int i = 0 ; i<nums.length ;i++){
            nextLarger[i]=-1;
        }
        LinkedList<Data> monotonousStack = new LinkedList<>();
        for(int i = 0 ; i < nums.length ;i++) {
            while(monotonousStack.size()>0&&monotonousStack.getLast().num<nums[i]){
                Data last = monotonousStack.pollLast();
                nextLarger[last.index]=nums[i];
            }
            monotonousStack.addLast(new Data(nums[i],i));
        }

        for(int i = 0 ; i < nums.length ;i++) {
            while(monotonousStack.size()>0&&monotonousStack.getLast().num<nums[i]){
                Data last = monotonousStack.pollLast();
                nextLarger[last.index]=nums[i];
            }
            monotonousStack.addLast(new Data(nums[i],i));
        }

        return nextLarger;
    }

    @Test
    public void test1(){
        int[] data = {1,2,1};
        int[] resp;
        resp=nextGreaterElements(data);
        for(int i = 0 ; i< resp.length ; i++) {
            System.out.printf("%d ",resp[i]);
        }
        System.out.println();
    }
    /**
     * 思路一
     *  每个元素挨个找
     *  时间复杂度O(n2）
     * 思路二
     *  使用一个递减的单调栈，遍历两遍
     *  1,9,2,5,3
     *
     */
}
