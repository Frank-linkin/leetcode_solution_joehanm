import Arrays.Solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution22 {
    //21:16
    public List<String> generateParenthesis(int n) {
        LinkedList<String> list = new LinkedList<>();
        if(n==0) {
            return list;
        }
        if(n==1){
            list.add("()");
            return list;
        }

        int[] nums = new int[n<<1];
        generateSequence(nums,0,0,list);
        return list;
    }

    public void generateSequence(int[] nums,int index,int sum,LinkedList<String> list) {
        if(sum<0) {
            return;
        }
        if(index>=nums.length){
            if(sum==0){
                list.add(generateString(nums));
            }
            return;
        }

        nums[index]=1;
        generateSequence(nums,index+1,sum+1,list);
        nums[index]=-1;
        generateSequence(nums,index+1,sum-1,list);
    }

    public String generateString(int[] nums) {
        StringBuilder builder = new StringBuilder();
        for(int a : nums) {
            if(a==1) {
                builder.append('(');
            }else if(a==-1){
                builder.append(')');
            }else{
                System.out.printf("Wrong input in generateSequence");
            }
        }
        return builder.toString();
    }
    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        System.out.println(solution22.generateParenthesis(3));
    }

    /**
     * 思路一：
     * 做完之后想想回溯法这个题目怎么做
     * （用1表示，)用-1表示
     *  一个sum表示已放置的符号的和。，如果是负的就不用往下走了
     *
     */
}
