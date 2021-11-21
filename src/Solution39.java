import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if(candidates==null||candidates.length==0)  return res;
        LinkedList<Integer> now = new LinkedList<Integer>();
        Arrays.sort(candidates);
        findCombination(res,now,candidates,target,0);
        return res;
    }

    public void findCombination(List<List<Integer>> res,LinkedList<Integer> cur,int[] candidates,int target,int start){
        if(candidates[start]>target)
            return;

        for(int i = start; i<candidates.length;i++){
            cur.add(candidates[i]);
            if(target-candidates[i]<0){
               cur.removeLast();
                return;
            }

            if(target == candidates[i]){

                res.add(new LinkedList<Integer>(cur));
                cur.removeLast();
                return;
            }
            findCombination(res,cur,candidates,target-candidates[i],i);
            cur.removeLast();
        }
    }

    @Test
    public void test1(){
        int[] data = {1,2,3,4};
        List<List<Integer>> res = combinationSum(data,3);
        System.out.println(res);
    }
}
