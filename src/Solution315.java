import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//16:57
public class Solution315 {
    class Data {
        int index;
        int val;

        public Data(){
            this.index = -1;
            this.val = 0;
        }
        public Data(int val,int index){
            this.val = val;
            this.index= index;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        int[] smallerIndex = new int[nums.length];
        for(int i = 0 ; i<smallerIndex.length;i++){
            smallerIndex[i] = -1;
        }
        Data[] monotonousStack = new Data[nums.length];
        int pos  = -1;

        for(int i = 0; i< nums.length ;i++){
            Data cur = new Data(nums[i],i);
            if(pos==-1){
                monotonousStack[++pos] =cur;
                continue;
            }
            if(monotonousStack[pos].val<=nums[i]){
                monotonousStack[++pos] = cur;
            }else{
                while(pos>=0&&monotonousStack[pos].val>nums[i]){
                    smallerIndex[monotonousStack[pos].index]=i;
                    pos--;
                }
                monotonousStack[++pos] = cur;
            }
        }
        for(int a:smallerIndex){
            System.out.printf("%d ",a);
        }
        System.out.println();
        Integer[] res = new Integer[nums.length];
        for(int i = nums.length-1;i>=0;i--){
            if(smallerIndex[i]==-1){
                res[i] =0;
            }else{
                res[i] = res[smallerIndex[i]]+1;
            }
        }
        return new LinkedList<>(Arrays.asList(res));
    }


    @Test
    public void test1(){
        int[] nums = {5,2,6,1};
        System.out.println(countSmaller(nums));
    }
}
