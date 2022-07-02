import java.util.LinkedList;

public class Solution121 {
    public int maxProfit(int[] prices) {
        if ( prices == null || prices.length < 2){
            return 0;
        }

        int maxProfit = -1;
        LinkedList<Integer> monotonousStack = new LinkedList<Integer>();
        for(int a : prices) {
            if(monotonousStack.size()!=0&&monotonousStack.getLast()>=a){
                maxProfit = maxProfit<(monotonousStack.getLast()-monotonousStack.getFirst())?(monotonousStack.getLast()-monotonousStack.getFirst()):maxProfit;
                while(monotonousStack.size()!=0&&monotonousStack.getLast()>=a) {
                    monotonousStack.pollLast();
                }
            }
            monotonousStack.addLast(a);
        }
        if(monotonousStack.size()>=2) {
            maxProfit = maxProfit<(monotonousStack.getLast()-monotonousStack.getFirst())?(monotonousStack.getLast()-monotonousStack.getFirst()):maxProfit;
        }
        return maxProfit;
    }



    public static void main(String[] args) {
        int[] data = {7,1,5,3,6,4};
        Solution121 solution121 = new Solution121();
        System.out.println(solution121.maxProfit(data));
    }


}
