import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class Solution496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        return null;
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
