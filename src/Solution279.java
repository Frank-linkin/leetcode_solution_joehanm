public class Solution279 {
    //verison
/*    public int numSquares(int n) {
        if(n==1){
            return 1;
        }
        else if(n==2){
            return 2;
        }

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        int num;
        int base= 1;
        int remain;
        for(int i = 3 ; i <=n ;i ++ ){
            num = i;
            if( i == (base+1)*(base+1) ){
                base+=1;
                dp[i] = 1;
                continue;
            }
            for(int j = base ; j >= 1 ; j--){
                remain = i - j*j;
                if(num>(dp[remain]+1)){
                    num = dp[remain]+1;
                }
            }
            dp[i] = num;
        }
        return dp[n];
    }*/

    //version2(2021年11月10日09:06:38)
    public int numSquares(int n) {
        return 0;
    }




    public static void main(String[] args) {
        Solution279 solution279 = new Solution279();
        System.out.println(" 3 = "+solution279.numSquares(3));
        System.out.println(" 4 = "+solution279.numSquares(4));
        System.out.println(" 5 = "+solution279.numSquares(5));
        System.out.println(" 6 = "+solution279.numSquares(6));
        System.out.println(" 7 = "+solution279.numSquares(7));
        System.out.println(" 8 = "+solution279.numSquares(8));
        System.out.println(" 9 = "+solution279.numSquares(9));
        System.out.println(" 10 = "+solution279.numSquares(10));
        System.out.println(" 11 = "+solution279.numSquares(11));
        System.out.println(" 12 = "+solution279.numSquares(12));
        System.out.println(" 13 = "+solution279.numSquares(13));
    }
}
