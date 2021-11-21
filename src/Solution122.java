public class Solution122 {
    public int maxProfit(int[] prices) {
        int min = 0;
        int profit = 0;
        for(int i = 1 ; i < prices.length-1;i++){
            if(prices[i]>prices[i-1]&&prices[i]>=prices[i+1]){
                profit += prices[i]-prices[min];
                min=i;
            }else if(prices[i-1]>prices[i]&&prices[i]<=prices[i+1]){
                min = i;
            }
        }
        if(prices[prices.length-1]>prices[min]){
            profit+=prices[prices.length-1]-prices[min];
        }
        return profit;
    }

    public static void main(String[] args) {
        Solution122 solution122 = new Solution122();
        int[] data  = {7,1,5,3,6,4};
        System.out.println(solution122.maxProfit(data));
    }
}
