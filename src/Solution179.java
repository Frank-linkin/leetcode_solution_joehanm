import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution179 {
    public String largestNumber(int[] nums) {
        if(nums==null){
            return "";
        }
        quickSortDesc(nums,0,nums.length-1);

        return Arrays.toString(nums);
    }

    public void quickSortDesc(int[] nums,int left,int right){
        if(left>=right){
            return;
        }

        int start = left,end = right;
        int sentinel = nums[left];
        while(left<right){
            while(left<right&&nums[right]<=sentinel){
                right--;
            }
            swap(nums,left,right);
            while(left<right&&nums[left]>=sentinel){
                left++;
            }
            swap(nums,left,right);
        }
        nums[left] = sentinel;
        quickSortDesc(nums,start,left-1);
        quickSortDesc(nums,left+1,end);
    }

    public void swap(int[] nums,int a,int b){
        int tem = nums[a];
        nums[a] = nums[b];
        nums[b] = tem;
    }

//    public int compare(int a,int b){
//        //记录一下
//        String s1=Integer.toString(a);
//        String s2=Integer.toString(b);
//
//        for(int)
//    }

    @Test
    public void test1(){
        int[] data = {2,2,3,2,2};
        quickSortDesc(data,0,data.length-1);

        for(int a: data){
            System.out.printf("%d ",a);
        }
        System.out.println();


    }


    @Test
    public void test2(){
        String[] data = {"aaa","bbb","ccc"};
        List<String> strsList=Arrays.asList(data);
        strsList.set(2,"zzz");
        System.out.println(strsList.toString());
        for(String a:strsList){
            System.out.printf("%s ",a);
        }
        System.out.println();
        //strsList.add("ddd");//这里会报错
        //[aaa, bbb, zzz]
        //aaa bbb zzz

        //2.将Arrays.asList()返回的java.utilArrays.ArrayList转化为java.util.ArrayList
        ArrayList<String> strArrayList = new ArrayList<String>(Arrays.asList(data));
        strArrayList.add("ggg");
        for(String a:strArrayList){
            System.out.printf("%s ",a);
        }
        System.out.println();
        //aaa bbb zzz ggg

        //3.Collections.addAll()方法
        ArrayList<String> arrayList3 = new ArrayList<String>();
        Collections.addAll(arrayList3,data);
        System.out.println(arrayList3.toString());
        //[aaa, bbb, zzz]

        //4.使用stream流将数组转化为List
        List<String> list4=Arrays.stream(data).collect(Collectors.toList());
        list4.add("qqq");
        System.out.println(list4.toString());
        //[aaa, bbb, zzz, qqq]


        //将list转化为array
        String[] array=list4.toArray(new String[list4.size()]);
        for(String a:array){
            System.out.printf("%s ",a);
        }
        System.out.println();
        //aaa bbb zzz qqq
    }
}
