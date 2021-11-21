import java.util.ArrayList;
import java.util.List;

public class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> cur = new ArrayList<>();
        ArrayList<List<Integer>> res = new ArrayList<>();
        boolean[] flag = new boolean[nums.length];

        combination(res,cur,flag,nums,0);
        return res;
    }

    public void combination(List<List<Integer>> list , List<Integer> cur , boolean[] flag,int[] nums,int t){
        if(t>=nums.length){
            List<Integer> newList = new ArrayList<Integer>();
            newList.addAll(cur);
            list.add(newList);
            return;
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(flag[i]==false){
                flag[i] = true;
                cur.add(nums[i]);
                combination(list,cur,flag,nums,t+1);
                cur.remove(cur.size()-1);
                flag[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        int[] nums = {1,2,3};

        Solution46 solution46 = new Solution46();
        System.out.println(solution46.permute(nums));
    }
}
