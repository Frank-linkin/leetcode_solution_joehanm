import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;

public class Solution945 {
    class Data{
        int duplicateNum;
        int num;

        public Data(int dup,int num) {
            this.duplicateNum = dup;
            this.num = num;
        }
    }
    public int minIncrementForUnique(int[] nums) {
        if(nums==null||nums.length == 0) {
            return 0;
        }

        int count = 0;
        LinkedList<Data> list = new LinkedList<>();
        for(int i = 1 ; i < nums.length; i++) {
            if(nums[i]==nums[i-1]) {
                int t= i;
                while(t<nums.length&&nums[t]==nums[t-1]){
                    t++;
                }


                list.add(new Data(t-i-1,nums[t-1]));
                i=t-1;
            }
            else if(nums[i]>nums[i-1]+1){


            }
        }
        return 0;
    }

    //start和end都是真正能用的数字
    public int enrichDiff(LinkedList<Data> list,int startValue,int endValue) {
        int count = endValue-startValue+1;//计算可用的槽的数量
        int resp=0;
        while(count>0) {
            Data first = list.getFirst();
            if(first.duplicateNum>count) {
                int diff = startValue-first.num;
                
                first.duplicateNum-=count;
            }
        }
        return 0;
    }

    public int getSum(int start,int end) {
        if(start>=end) {
            return -1;
        }

        //1,2,3,4
        return (end+start)*(end-start+1)/2;
    }
        @Test
    public void test1(){
        int[] data = {1,2,2,2,3,5};
        System.out.println(minIncrementForUnique(data));
    }
    /**
        1.数组排序
        2.使用一个链表<出现次数，nums[t]></出现次数，nums[t]>
        3.变量count=0;
     *  考虑nums[i]
     *      若Nums[i]-nums[i-1]>1
     *   若遍历到最后链表还有结点
     *   分别计算
     *      max+1 - num
     *      max+2 - num
     */

}
