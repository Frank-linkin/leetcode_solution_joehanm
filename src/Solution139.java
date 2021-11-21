import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution139 {
    public static void main(String[] args) {
        Solution139 solution139 = new Solution139();
        String s = "applepenapple";
        List<String> Dic = new ArrayList<String>();
        Dic.add("apple");
        Dic.add("pen");
//        Dic.add("sand");
//        Dic.add("and");
//        Dic.add("cat");
        System.out.println(solution139.wordBreak_version1(s,Dic));
        System.out.println(s.substring(0,3));
    }

    //version1 202104
    public boolean wordBreak_version1(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 1 ; i<= s.length();i++){
            for(int j = 0 ; j < i ;j++){
                if(dp[j]&&wordDictSet.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


}
