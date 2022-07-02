import org.junit.Test;

import java.util.LinkedList;

public class Solution84 {
    /**
     * 考虑单调递减栈
     *  ①入栈后左边第一个元素是一个比它大的数。
     *    考虑10,5,6
     *      假设存在这样一个数x
     *      若x>10，那它把10也去掉了
     *      所以x<10
     *      又x>6
     *      所以 6<x<10
     *      又x被另一个数y去掉了。
     *      所以y>x
     *      而Y又符合第一个比6大的数。
     *  解法：
     *  考虑height[x]
     *  leftIndex记录x左边第一个小于x的数的index,若没有，置为-1
     *  rightIndex记录y右边第一个小于y的数的index，若没有，置为height.length
     *  从左往右遍历的时候
     *      ①考虑一个递增单调栈
     *          conclusion1:对于每一个出栈元素，x都是其右边第一个小于此元素的元素
     *          conclusion2:入栈后，x左边第一个元素就是x左边第一个小于x的元素
     *      ②考虑一个递减单调栈
     *          对于每一个出栈元素，x都是其右边第一个大于此元素的元素
     *          入站后，x左边第一个元素就是x左边第一个大于x的元素。
     *
     *   打算利用Conclusion1来写一个题解：
     *   首先从左往右遍历，考虑height[x]
     *      对于每个出栈元素peek
     *          leftIndex[peek.index] = i;
     */
    public int largestRectangleArea(int[] heights) {
        //边界条件处理
        if ( heights == null || heights.length == 0) {
            return 0;
        }

        if(heights.length == 1) {
            return heights[0];
        }

        LinkedList<Data> monotonousStack = new LinkedList<Data>();
        int[] leftIndex = new int[heights.length];
        int[] rightIndex = new int[heights.length];
        for(int i = 0; i < leftIndex.length; i ++ ) {
            leftIndex[i] = -1;
            rightIndex[i] = heights.length;
        }
        for(int i = 0 ; i < heights.length ; i++) {
            while(monotonousStack.size()>0&&monotonousStack.getLast().height>heights[i]) {
                Data peek = monotonousStack.pollLast();
                rightIndex[peek.index]= i;
            }
            monotonousStack.addLast(new Data(i,heights[i]));
        }
        monotonousStack.clear();
        for(int i = heights.length-1; i >= 0 ; i++ ) {
            while(monotonousStack.size()>0&&monotonousStack.getFirst().height>heights[i]) {
                Data poll = monotonousStack.pollFirst();
                leftIndex[poll.index] = i;
            }
            monotonousStack.addFirst(new Data(i,heights[i]));
        }
        int maxAcreage = -1;
        for(int i = 0 ; i< heights.length; i ++) {
            int acreage = (rightIndex[i] - leftIndex[i]-1)*heights[i];
            maxAcreage = maxAcreage<acreage?acreage:maxAcreage;
        }
        return maxAcreage;
    }
    class Data{
        int index;
        int height;

        public Data(int index,int height) {
            this.index = index;
            this.height = height;
        }
    }

    @Test
    public void test1(){
        int[] data = {2,4};
        System.out.println(largestRectangleArea(data));
    }

    @Test
    public void test2(){
        //测试LinkedList（）
        //LinkedList当Stack使用push的时候，使用的是头插法
        LinkedList<Integer> stack = new LinkedList<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.printf("::");
        showStack(stack);
        System.out.println("peek : "+stack.peek());


        stack.addLast(9);
        System.out.println(stack.peek());
        System.out.println(stack.getFirst());
        showStack(stack);
    }

    public void showStack(LinkedList<Integer> stack) {
        for(Integer a : stack) {
            System.out.printf("%d ",a);
        }
        System.out.println();
    }
}
