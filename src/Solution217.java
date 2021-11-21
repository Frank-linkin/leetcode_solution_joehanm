import java.util.HashSet;

public class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        if(nums == null){
            return false;
        }

        HashSet<Integer> set = new HashSet<>();
        for(int i =0;i<nums.length;i++){
            if(set.contains(nums[i])){
                return true;
            }
            else{
                set.add(nums[i]);
            }
        }
        return false;
    }
}
