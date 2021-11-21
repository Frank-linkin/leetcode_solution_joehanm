public class Solution91 {

    //20210103
    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len];

        char last,now;
        last = s.charAt(0);

        if(last == '0' ){
            return 0;
        }
        if(len == 1){
            return 1;
        }
        dp[0] = 1;

        now = s.charAt(1);
        int val = (last-'0')*10+(now-'0');
        //此时val肯定>=10
        if(last>'0'&&last<='9'&&now == '0'){
            if(last == '1' ||last == '2'){
                dp[1]=1;
            }
            else{
                return 0;
            }
        }
        else if( 11<=val && val <= 26){
            dp[ 1 ] = 2;
        }
        else{
            dp[ 1 ] = 1 ;
        }

        for(int i = 2 ; i<len ;i ++){
            last = s.charAt(i-1);
            now = s.charAt(i);
            val = (last-'0')*10 + (now-'0');

            if( last == '0' && now == '0' ){
                return 0;
            }
            else if(last>='1'&&last<='9'&&now == '0'){
                if(last == '1' ||last == '2'){
                    dp[i] = dp[i-2];
                }
                else{
                    return 0;
                }
            }
            else if( last == '0' && now>='1'&&now<='9'){
                dp[ i ] = dp[ i-1 ];
            }
            else if( 11<=val && val <= 26){
                dp[ i ] = dp[ i-2 ]+dp[ i-1 ];
            }
            else{
                dp[ i ] = dp[ i-1 ];
            }
        }
        return dp[len-1];
    }


    public static void main(String[] args) {
        String s = "1201234";
        Solution91 solution91 = new Solution91();

        System.out.println(solution91.numDecodings(s));
    }
}
