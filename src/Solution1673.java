import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class Solution1673 {
    public int[] mostCompetitive1(int[] nums, int k) {
        int[] res = new int[k];
        int point = -1;
        for(int i = 0 ; i < k ; i++){
            res[i] = nums[i];
        }
        for(point = 0 ; point < res.length-1;point++){
            if(res[point]>res[point+1])
                break;
        }
        for(int i = k ; i < nums.length ; i++){
            if (point<res.length-1){
                for( int j = point ; j<res.length-1 ; j++){
                    res[j] = res[j+1];
                }
                res[res.length-1] = nums[i];
            }
            else if(res[res.length-1]>nums[i])
                res[res.length-1] = nums[i];

            //修正point的指向
            for(point = 0 ; point < res.length-1;point++){
                if(res[point]>res[point+1])
                    break;
            }
        }
        return res;
    }

    public int[] mostCompetitive(int[] nums, int k) {
        int deleteNum = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        for(int i = 0 ; i<nums.length - k ; i++){
            while(!stack.isEmpty()&&nums[i]<stack.peek()){
                stack.pop();
            }
            if(stack.size()<k)
                stack.push(nums[i]);
        }
        System.out.println(stack);
        for(int i = nums.length - k  ; i <nums.length ; i++){
            deleteNum = stack.size()-(k-(nums.length-i+1));
            while(!stack.isEmpty()&&nums[i]<stack.peek()&&deleteNum>0){
                stack.pop();
                deleteNum--;
            }
            if(stack.size()<k)
                stack.push(nums[i]);
            System.out.println(stack);
        }
        int[] res = new int[k];
        for(int i = res.length-1 ; i >= 0  ; i--){
            res[i] = stack.pop();
        }
        return res;
    }


    @Test
    public void test1(){
        int[] data = {2,4,3,3,5,4,9,6};
        int k = 4;
        int[] res = mostCompetitive(data,k);
        for(int a:res){
            System.out.printf(" %d",a);
        }
    }
}
