import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

public class Solution647 {
    public int countSubstrings1(String s) {
        //看看s.toCharArray()快，还是s.charAt快

        //处理边界条件
        if(s==null||s.length()==0) return 0;
        if(s.length()==1){
            return 1;
        }

        //进行处理过程
        boolean[][] dp = new boolean[2][s.length()];
        int count=0;
        for(int m = s.length()-1;m>=0;m--){
            for(int n = m ;n<s.length();n++){
                dp[m&1][n]=false;
                if(m==n){
                    dp[m&1][n]=true;
                    count++;
                }
                else if(m+1==n&&s.charAt(m)==s.charAt(n)){
                    dp[m&1][n] = true;
                    count++;
                }
                else if(dp[1-(m&1)][n-1] == true&&s.charAt(m)==s.charAt(n)){
                    dp[m&1][n] = true;
                    count++;
                }
            }
        }
        return count;
    }

    //中心扩展法
    public int countSubstrings(String s){
        //处理边界条件
        if(s==null||s.length()==0) return 0;
        if(s.length()==1){
            return 1;
        }

        //进行处理过程
        int count = 0;
        for(int n = 0 ; n < (s.length()*2-1);n++){
            int left = n/2;
            int right = n/2+(n&1);
            while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
                count++;
                left--;
                right++;
            }
        }
        return count;
    }

    @Test
    public void test1(){
        String s = "abb";
        System.out.println(countSubstrings(s));
    }
}
