import org.junit.Test;

import java.util.LinkedList;

public class Solution581 {
    class Data{
        int num;
        int index;
        public Data(int num,int index) {
            this.num = num;
            this.index = index;
        }
    }
    public int findUnsortedSubarray(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return 0;
        }

        int left = 0x7fffffff,right = 0x7fffffff;
        int min  = 0x7fffffff,max=-1;
        LinkedList<Data> monotonousStack = new LinkedList<>();
        for(int i = 0 ; i < nums.length ; i++ ) {
            int newLeft = -1;
            while(monotonousStack.size()>0&&monotonousStack.getLast().num>nums[i]) {
                Data last = monotonousStack.pollLast();
                newLeft = last.index;
            }
            if(newLeft!=-1) {
                if(newLeft < left) {
                    left = newLeft;
                }
                right = i;
            }
            monotonousStack.addLast(new Data(nums[i],i));
            if(right<nums.length&&nums[i]==nums[right]){
                right = i;
            }
            if(nums[i]>=min&&nums[i]<=max) {
                right = i;
            }
        }
        if(left == 0x7fffffff) {
            return 0;
        }
        return (right-left+1);
    }

    @Test
    public void test1(){
        int[] data = {1,2,5,3,4};
        System.out.println(findUnsortedSubarray(data));
    }
    /**
     *  思路一：
     *      将数据加入一个堆中，不停地输出最小元素并比较
     *  思路二：
     *      考虑nums[i]，使用一个从左到右单调递增的单调栈
     *      此时应该更换的区间是 [换出的最后一个元素的index,i],记这个为newLeft
     *      if NewLeft<left
     *          区间变更为[newLeft,right]
     *      right = i
     *
     *      思路有问题：
     *          若[1,6,3,4,5]应该交换的是[6,3,4,5],但是因为6已经被3挤出去了，所以这里只会显示[6,3]，最后结果为2
     *
     *  思路三：
     *      一个left，right记录截止nums[i]的最短无序子数组
     *      考虑nums[i]
     *
     */
}
