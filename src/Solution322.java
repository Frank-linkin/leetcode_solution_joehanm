public class Solution322 {
    public int coinChange1(int[] coins, int amount) {
        if(amount==0){
            return 0;
        }
        int[] count = new int[amount+1];



        count[0] = 0;
        int minCount;
        for(int i = 1 ; i <= amount ; i ++){

            minCount = amount +1;
            for(int j = 0 ; j < coins.length;j++){
                if(i>=coins[j]){
                    if(count[i-coins[j]]!=-1){

                        if(minCount>count[i-coins[j]]){
                            minCount = count[i-coins[j]];
                        }
                    }
                }
            }

            if(minCount != amount+1){
                count[i] = minCount+1;
            }
            else{
                count[i] = -1;
            }

        }
        return count[amount];
    }

    public int coinChange(int[] coins, int amount) {
        if(amount == 0 ){
            return 0;
        }

        int[] count = new int[amount+1];
        int maxNum = amount+1;

        for(int i = 0 ; i < count.length ; i++){
            count[i] = maxNum;
        }

        count[0] = 0;
        DFS(count,coins,0,0);

        if(count[amount ]== maxNum){
            return -1;
        }
        else{
            return count[amount];
        }
    }

    public void DFS(int[] count,int[] coins,int t,int val){
        if(count[t]>val){
            count[t] = val;
        }

        for(int i=0 ; i<coins.length;i++) {
            if (t + coins[i] < count.length&&t>=0) {
                DFS(count, coins, t + coins[i], count[t] + 1);
            }
        }
    }



    public static void main(String[] args) {
        int[] coins = {1,2147483647};
        int amount = 2;
        Solution322 solution322 = new Solution322();
        System.out.println(solution322.coinChange(coins,amount));

    }
}
