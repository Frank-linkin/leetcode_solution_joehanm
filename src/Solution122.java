import java.util.LinkedList;

public class Solution122 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0 ) {
            return 0;
        }

        int profit= 0;
        LinkedList<Integer> stack = new LinkedList<>();
        for(int a : prices) {
            if(stack.size()!=0&&stack.getLast()>=a) {
                if(stack.size()>1){
                    profit += stack.getLast()-stack.getFirst();
                }
                stack.clear();
            }
            stack.addLast(a);
        }

        if(stack.size()>1) {
            profit += stack.getLast()-stack.getFirst();
            stack.clear();
        }
        return profit;
    }

    public static void main(String[] args) {
        Solution122 solution122 = new Solution122();
        int[] data  = {7,1,5,3,6,4};
        System.out.println(solution122.maxProfit(data));
    }
    /**
     * 思路一：
     *  使用极值
     * 思路二：
     *  使用单调栈
     *  if stack.top() >=nums[i]
     *      if stack.size()!=1{
     *          profit += stack.top()-stack.base()
     *            清空stack
     *      }
     *
     *  遍历所有nums[i]，若stack.size()>1 {
     *      profit += stack.top()-stack.base()
     *      *            清空stack
     *  }
     *  return profit
     */
}
