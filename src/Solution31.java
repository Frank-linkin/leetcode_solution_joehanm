public class Solution31 {
    public void nextPermutation(int[] nums) {
        if(nums==null||nums.length==0) return;
        int start ;
        for(start = nums.length-1 ;start>=1 && nums[start]<=nums[start-1];start--);
        if(start!=0){
            int t = nums.length-1;
            for(;nums[t]<nums[start-1];t--);
            t++;
            int tem = nums[t];
            nums[t] = nums[start-1];
            nums[start-1] = tem;
        }
        sortNums(nums,start,nums.length-1);//将start开始的元素排序
    }
    public void sortNums(int[] nums,int start,int end){
        if(start<end){
            int key = nums[start];
            int left = start,right = end;
            while(start<end){
                while(start<end&&nums[end]>=key) end--;
                while(start<end&&nums[start]<=key) start++;
                int tem =nums[left];
                nums[left] = nums[start];
                nums[start] = tem;
                sortNums(nums,left,start-1);
                sortNums(nums,start+1,right);
            }
        }
    }
}
