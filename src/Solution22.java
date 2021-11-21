import Arrays.Solution;

import java.util.ArrayList;
import java.util.List;

public class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        calculateCombination(ans,new StringBuilder(),0,0,n);
        return ans;
    }

    //Leetcode上最原本的答案
    public void calculateCombination(List<String> ans,StringBuilder s,int cl,int cr,int n){
        if(s.length() == n*2){
            ans.add(s.toString());
            System.out.println(s);
            return;
        }

        if(cl < n){
            s.append('(');
            calculateCombination(ans,s,cl+1,cr,n);
            s.deleteCharAt(s.length()-1);
        }

        if(cr < cl){
            s.append(')');
            calculateCombination(ans,s,cl,cr+1,n);
            s.deleteCharAt(s.length()-1);
        }
    }

    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        solution22.generateParenthesis(4);
    }

}
