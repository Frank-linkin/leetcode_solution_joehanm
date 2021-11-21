public class Solution213 {
    public int rob(int[] nums) {
        //处理n=0,1,2,3的情况
        //这几种情况下都是取所有数据中的最大值
        if(nums==null||nums.length==0){
            return 0;
        }
        else if(nums.length==1){
            return nums[0];
        }
        else if(nums.length == 2){
            return nums[0]>nums[1]?nums[0]:nums[1];
        }
        else if(nums.length == 3){
            int max = nums[0];
            for(int i = 0 ; i < nums.length ;i++){
                if(nums[i]>max){
                    max = nums[i];
                }
            }
            return max;
        }

        int max=0;
        int n = nums.length;

        boolean former1,former2;
        int f1,f2;
        f1 = nums[0];
        former1 = true;
        if(nums[0]>=nums[1]){
            former2 = true;
            f2 = f1;
        }else{
            former2 = false;
            f2 = nums[1];
        }
        int val;
        boolean used;
        for(int i = 2 ; i<n ; i++){
            //在这一部分得到当前nums[i]的val，和是否使用队首的标记used
            val = nums[i] + f1;
            if(val>=f2){
                used = former1;
            }
            else{
                used = former2;
                val = f2;
            }

            //当队尾的时候，需要处理特殊情况
            if(i == n-1&&used==true){
                val = f2;
                used = false;
            }

            //循环的后处理
            if(val > max){
                max = val;
            }
            former1 = former2;
            f1 = f2;
            former2 = used;
            f2 = val;
        }

        boolean last1,last2;
        int l1,l2;
        l2 = nums[n - 1];
        last2  = true;
        if(nums[n-1]>=nums[n-2]){
            last1 = true;
            l1 = l2;
        }else{
            last1 = false;
            l1 = nums[n-2];
        }

        for(int i = n-3 ; i>=0 ; i--){
            //在这一部分得到当前nums[i]的val，和是否使用队首的标记used
            val = nums[i] + l2;
            if(val>=l1){
                used = last2;
            }
            else{
                used = last1;
                val = l1;
            }

            //当队尾的时候，需要处理特殊情况
            if(i == 0&&used==true){
                val = l1;
                used = false;
            }

            //循环的后处理
            if(val > max){
                max = val;
            }
            l2 = l1;
            last2 = last1;
            last1 = used;
            l1 = val;
        }


        return max;
    }

    public static void main(String[] args) {
        Solution213 solution213 = new Solution213();

        int[] data = {100,1,2,3,200};
        System.out.println(solution213.rob(data));
    }
}
