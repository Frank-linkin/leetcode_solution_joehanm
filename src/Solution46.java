import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> cur = new LinkedList<Integer>();
        LinkedList<List<Integer>> resp = new LinkedList<>();
        if(nums == null || nums.length == 0) {
            return resp;
        }
        boolean[] flag = new boolean[nums.length];
        generateSequence(cur,resp,flag,nums);
        return resp;
    }

    public void generateSequence(LinkedList<Integer> cur,LinkedList<List<Integer>> resp,boolean[] flag,int[] nums){
        if(cur.size()==nums.length) {
            resp.add(new LinkedList<>(cur));
            return;
        }

        for(int i = 0 ; i< nums.length; i++) {
            if(flag[i]==false) {
                flag[i] = true;
                cur.addLast(nums[i]);
                generateSequence(cur,resp,flag,nums);
                cur.pollLast();
                flag[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        int[] nums = {1};

        Solution46 solution46 = new Solution46();
        System.out.println(solution46.permute(nums));
    }
    /**
     * 建议一个flag数组，标志数组已经被添加到cur里
     *
     */
}
