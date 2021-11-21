import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class Solution496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int i = 0;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
        while(true){
            while (i<nums2.length&&(stack.isEmpty()||stack.peek()>=nums2[i])){
                stack.push(nums2[i]);
                i++;
            }
            if ( i == nums2.length)
                break;
            while(!stack.isEmpty()&&(nums2[i]>stack.peek())){
                hashmap.put(stack.pop(),nums2[i]);
            }
        }
        while(!stack.isEmpty()){
            hashmap.put(stack.pop(),-1);
        }

        for( i = 0 ; i < nums1.length ; i++){
            nums1[i] = hashmap.get(nums1[i]);
        }
        return nums1;
    }

    @Test
    public void test1(){
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        int[] res = nextGreaterElement(nums1,nums2);
        for(int i :res){
            System.out.printf(" %d",i);
        }
    }
}
