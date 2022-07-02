import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s==null||s.length()==0) {
            return true;
        }
        boolean[] dp = new boolean[s.length()];
        //dp[0] = true;
        int i = 0;
        while(i<=dp.length) {
            if(i==0||dp[i-1]==true){
                for(String a :wordDict) {
                    int tail = i+a.length();
                    if(tail<=dp.length&&s.substring(i,tail).equals(a)){
                        dp[tail-1] = true;
                    }
                }
            }
            i++;
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        Solution139 solution139 = new Solution139();
        String s = "catsandog";
        System.out.println(s.substring(1, 3));
        List<String> Dic = new ArrayList<String>();
        Dic.add("cats");
        Dic.add("dog");
        Dic.add("sand");
        Dic.add("and");
        Dic.add("cat");
        Dic.add("og");
        System.out.println(solution139.wordBreak(s,Dic));
        System.out.println(s.substring(0,3));
    }


    /**
     * 思路一：动态规划
     * dp[i] 表示str[0-i]是可以拼起来的
     *
     */

}
