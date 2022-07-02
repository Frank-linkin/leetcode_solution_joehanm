public class Solution718 {
    //10:39 - 开始
    public int findLength(int[] nums1, int[] nums2) {
        if(nums1==null||nums1.length==0||nums2==null||nums2.length==0) {
            return 0;
        }

        //总会让nums1.length<=nums2.length
        if(nums1.length>nums2.length) {
            int[] tem = nums2;
            nums2 = nums1;
            nums1 = tem;
        }

        int max = 0;
        for(int i = 0 ; i<nums1.length+nums2.length;i++){
            int p = Math.max(0,nums1.length-i);
            int q = Math.max(0,i-nums1.length);
            int curMax= 0;
            while(p<nums1.length&&q<nums2.length){
                if(nums1[p]!=nums2[q]){
                    max = curMax>max?curMax:max;
                    curMax = 0;
                }else{
                    curMax++;
                }
                p++;
                q++;
            }
            max = curMax>max?curMax:max;
        }
        return max;
    }


    public static void main(String[] args) {
        Solution718 solution718 = new Solution718();

        int[] A = {1,1,0,0,1};
        int[] B = {1,1,0,0,0};
        System.out.println(solution718.findLength(A,B));
    }
    /**
     * 输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
     * 输出：3
     * 解释：长度最长的公共子数组是 [3,2,1] 。
     *
     * 思路一 动态规划：
     *      dp[i][j]表示以i，j为结尾的公共前缀的长度
     *      if nums[i]!=nums[j]
     *          dp[i][j]=0
     *      if nums[i]==nums[j]
     *          dp[i-1][j-1]+1;
     *          if i==0 || j==0
     *          dp[i][j]==1
     *      然后优化空间复杂度，改为O(n)
     *      时间复杂度O(nums.length*nums2.length)
     * 思路二 滑动窗口
     *      5,4,3,2,1,4,7 nums2
     *      1,3,2,1,6 num1
     *      时间复杂度O(num1.length*nums2.length)
     *      空间复杂度O(1)
     *
     *      for(int i = Math.max(0,
     *
     */
}
