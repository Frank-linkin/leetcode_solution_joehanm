public class Solution309 {
    public int maxProfit(int[] prices) {
        if(prices == null){
            return 0;
        }
        else if(prices.length == 0||prices.length == 1){
            return 0;
        }
        else if(prices.length == 2){
            return (prices[1] - prices[0])>0?(prices[1] - prices[0]):0;
        }
        else{
            int con1 = -prices[0],con2 = 0 ,con3 = 0;
            int newcon1,newcon2,newcon3;
            for(int i= 1 ;i<prices.length;i++){
                newcon1 = con1>(con3-prices[i])?con1:(con3-prices[i]);
                newcon2 = con1+prices[i];
                newcon3 = con2>con3?con2:con3;
                con1 = newcon1;
                con2 = newcon2;
                con3 = newcon3;
            }
            return con2>con3?con2:con3;
        }
    }


    public static void main(String[] args) {

    }
}
