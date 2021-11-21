import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution703 {


    @Test
    public void test1(){
        int k = 1;
        int nums[];
        KthLargest a = new KthLargest(k,null);
        System.out.println(a.add(-3));
        System.out.println(a.add(-2));
        System.out.println(a.add(-4));
        System.out.println(a.add(0));
        System.out.println(a.add(4));
        System.out.println(a.add(13));
    }

    class KthLargest {

        PriorityQueue<Integer> q;
        int k;
        public KthLargest(int k, int[] nums) {
            q = new PriorityQueue<Integer>();

            if(nums != null){
                for(int a:nums){
                    q.offer(a);
                }
            }
            this.k = k;

            while(q.size()>k)
                q.remove();
        }

        public int add(int val) {
            q.offer(val);
            while(q.size()>k)
                q.remove();
            return q.peek();
        }
    }

    class KthLargest2 {
        int k;
        int[] nums;
        int length;
        public KthLargest2(int k, int[] nums) {
            if(nums == null){
                this.nums = new int[16];
                this.length = 0;
            }
            else{
                this.nums = nums;
                Arrays.sort(nums);
                this.length = nums.length;
            }
            this.k = k;
        }

        public int add(int val) {
            int i;

            if(length == 0){
                nums[0] = val;
                length++;
                return nums[0];
            }

            if(length==nums.length){
                int[] newArray = new int[length*2];
                for(i=0;i<nums.length;i++){
                    newArray[i]= nums[i];
                }
                nums = newArray;
            }
            for(i=length-1;i>=0;i--){
                if(nums[i]>val){
                    nums[i+1]=nums[i];
                }
                else{
                    break;
                }
            }
            nums[i+1] = val;
            length++;

//            System.out.print("nums:");
//            for(i=0;i<length;i++){
//                System.out.print(nums[i]);
//            }
//            System.out.println();

            return nums[length-k];
        }
    }
}
