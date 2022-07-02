class Solution376 {
    public int wiggleMaxLength(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length==1) {
            return 1;
        }
        if(nums.length==2&&nums[0]!=nums[1]){
            return 2;
        }

        int[] dpUp = new int[nums.length];
        int[] dpDown = new int[nums.length];
        dpUp[0] = 1;
        dpDown[0] = 1;
        int maxLen = 1;
        for(int i = 1; i<nums.length ; i++) {

            if(nums[i]>nums[i-1]){
                dpUp[i] = Math.max(dpDown[i-1]+1,dpUp[i-1]);
                dpDown[i] = dpDown[i-1];
            }else if(nums[i]<nums[i-1]){
                dpDown[i] = Math.max(dpUp[i-1]+1,dpDown[i-1]);
                dpUp[i] = dpUp[i-1];
            }else{
                dpUp[i] = dpUp[i-1];
                dpDown[i] = dpDown[i-1];
            }

            maxLen = maxThree(dpUp[i],dpDown[i],maxLen);
        }
        return maxLen;
    }

    public int maxThree(int m,int n, int p) {
        if(m<n) {
            if(p>n){
                return p;
            }else{
                //p<=n
                return n;
            }
        }else{
            //m>=n
            if(p>m){
                return p;
            }else{
                //p<=m
                return m;
            }
        }
    }
    /**
     * nums = [1,7,4,9,2,5]
     * 6
     * 使用dpUp[],dpDow[].dpUp[i]表示以i为结尾，且上扬的摆动序列的长度；dpDown[i]表示以i为结尾，且下降的摆动序列长度
     *
     *       1 7 4 9 2 5
     *       1 2 2 4 2 6
     *       1 1 3 1 5 5
     *  dpUp[i] = max([dpDown[t])+1,nums[t]<nums[i]
     *  dpDown[i] = max(dpUp[t],0<=t<=i-1)+1,nums[t] <=i-1)+1,nums[t]> nums[i]
     *  时间复杂度O(n2)
     *  空间复杂度O(N)
     *
     *  改进：
     *     更换状态转移方程,这个状态方程的证明网上有。
     *
     *     dpUp[i] = max(dpUp[i-1],dpDown[i-1]+1) if(nums[i]>nums[i-1])
     *             = dpUp[i-1]                    if nums[i]<=nums[i-1]
     *
     *     if nums[i]<nums[i-1] dpDown[i] = max(dpUp[i-1]+1,dpDown[i-1])
     *        num[i]>=nums[i-1] dpDown[i] = dpDowm[i-1];
     *     18,13,17,12,1,4,2
     *
     * 思路二 贪心算法：
     *     在改进思路的基础上优化存储就可以了
     *
     */
}