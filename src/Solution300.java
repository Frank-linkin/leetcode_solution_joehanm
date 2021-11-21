public class Solution300 {
    //version1 202104
    public int lengthOfLIS1(int[] nums) {
        if(nums.length == 1){
            return 1;
        }
        int[] maxLength = new int[nums.length];
        maxLength[0] = 1;
        for(int i = 1;i<nums.length;i++){
            maxLength[i] = 1;
            for(int j = i-1;j>=0;j--){
                if(nums[i]>nums[j]&&maxLength[i]<(maxLength[j]+1)){
                    maxLength[i] = maxLength[j] + 1;
                }
            }
        }


        int max = 0;
        for(int i = 0; i<nums.length;i++){
         //   System.out.println(i+" = "+maxLength[i]);
            if(maxLength[i] > max){
                max = maxLength[i];
            }
        }

        return max;
    }

    //version2 202105
    public int lengthOfLIS(int[] nums) {
       if(nums.length == 1){
           return 1;
       }

       int[] d = new int[nums.length+1];
       int len = 1;
       for(int i = 0 ; i < nums.length ; i++){
           if(nums[i]>d[len]){
               len++;
               d[len] = nums[i];
           }
           else{
               //查找满足d[t-1]<nums[i]<d[t]的t
               int  l = 1,r=len,pos = 0;//如果找不到说明素有的数都比nums[i]大

               while(l <= r){
                   int mid = (l+r)>>1;
                   if(d[mid]<nums[i]){
                       pos = mid;
                       l = mid +1;
                   }
                   else{
                       r = mid -1;
                   }
               }
               d[pos + 1] = nums[i];
           }
       }
       return len;
    }


    public static void main(String[] args) {
        int[] data  = {10,9,2,5,3,7,101,18};
        Solution300 solution300 = new Solution300();
        System.out.println(solution300.lengthOfLIS(data));
    }
}
