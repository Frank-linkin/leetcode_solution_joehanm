import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        LinkedList<Integer> now = new LinkedList<Integer>();
        ArrayList<List<Integer>> resp = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return resp;
        }
        boolean[] flags = new boolean[nums.length];
        Arrays.sort(nums);
        permute(nums,flags,now,resp);
        return resp;
    }

    public void permute(int[] nums,boolean[] flags, LinkedList<Integer> now,List<List<Integer>> resp) {
        if( now.size() == nums.length ) {
            resp.add(new ArrayList(now));
            return;
        }

        for(int i = 0 ; i< nums.length ;i++ ) {
            if(flags[i] == false) {
                now.add(nums[i]);
                flags[i]=true;
                permute(nums,flags,now,resp);
                now.pollLast();
                flags[i]=false;

                int last = nums[i];
                if(i+1<nums.length && nums[i+1]==nums[i]) {
                    while(i<nums.length&&nums[i]==last){
                        i++;
                    }
                    i--;
                }
            }
        }

    }

    @Test
    public void test1(){
//        int[] nums = {1,1,2};
//        List<List<Integer>> resp = permuteUnique(nums);
//        for(List<Integer> a:resp) {
//            for(Integer b : a){
//                System.out.printf("%d ",b);
//            }
//            System.out.println();
//        }

        ArrayList<Integer> array = new ArrayList<Integer>();
        LinkedList<Integer> list = new LinkedList<Integer>();
        //向末尾插入的方法
        array.add(1);
        array.add(2);
        array.add(3);
        //向某个位置插入的方法
        array.add(1,6);//1,6,2,3
        //删除某个位置元素的方法
        array.remove(3);//1,6,2

        list.add(1);
        list.add(2);
        list.add(3);
        list.addFirst(100);
        list.addLast(1000);
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        list.pollFirst();
        list.pollLast();

        for(Integer a:list){
            System.out.printf("%d ",a);
        }

    }
}
