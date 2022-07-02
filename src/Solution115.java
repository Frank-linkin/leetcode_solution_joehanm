import org.junit.Test;

public class Solution115 {
    public int numDistinct(String s, String t) {
        if(s==null||t==null){
            return 0;
        }
        if(s.length()==0||t.length()==0){
            return 0;
        }

        int[] dp = new int[t.length()];
        for(int i = 0 ; i< s.length();i++){
            char cur = s.charAt(i);
            for(int j = dp.length-1;j>=0;j--){
                if(t.charAt(j)==cur){
                    if(j==0){
                        dp[j]++;
                    }else{
                        dp[j]=dp[j-1]+dp[j];
                    }
                }
            }
        }
        return dp[dp.length-1];
    }

    @Test
    public void test1(){
        String s = "babgbag";
        String t  = "bag";
        System.out.println(numDistinct(s,t));
    }
}
