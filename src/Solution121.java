public class Solution121 {
    public int maxProfit(int[] prices) {
        int min = 0;
        int profit = 0;
        for(int i = 1 ; i < prices.length;i++){
            if(prices[i]>prices[i-1]){
                if(prices[i]-prices[min]>profit){
                    profit = prices[i] - prices[min];
                }
            }else if(prices[i]<prices[min]){
                min = i;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] data = {7,1,5,3,6,4};
        Solution121 solution121 = new Solution121();
        System.out.println(solution121.maxProfit(data));
    }
}
