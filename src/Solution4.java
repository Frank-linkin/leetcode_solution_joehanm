import org.junit.Test;

public class Solution4 {
    /**
     * [Enlightening]
     * 做题的时候，一定要考虑好细节，再coding，比如这个题，我知道大体的方法，但是没有去考虑边界条件。比如当其中一个nums的长度只剩两个的时候，
     * 它就没有可以排除的元素了，这时候要怎么办，这都是应该在开始coding之间就要想明白的。
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1==null||nums2==null||nums1.length==0||nums2.length==0){
            return 0;
        }
        if(nums1.length==0){
            if((nums2.length&1)==1) {
                return nums2[(nums2.length>>1)];
            }else{
                return ((double)nums2[nums2.length>>1]+(double)nums2[(nums2.length>>1) -1])/2;
            }
        }
        if(nums2.length==0){
            int mid = nums1.length>>1;
            if((nums1.length&1)==1){
                return nums1[mid];
            }else{
                return ((float)(nums1[mid]+nums1[mid-1]))/2;
            }
        }

        if(nums1.length+nums2.length<=4){

        }
        int start1 = 0,start2 = 0;//下标
        int mid = (nums1.length+nums2.length)>>1;//序数
        boolean isOdds = ((nums1.length+nums2.length)&1) == 1?true:false;
        int mid1 = (nums1.length-1)>>1,mid2=(nums2.length-1)>>1;//下标
        while(mid>2){
            int step = 0;
            if(nums1[mid1]>nums2[mid2]){
                step = mid2-start2;
                start2= mid2-1;
            }else{
                step = mid1 - start1;
                start1 = mid1-1;
            }

            mid-=step;
            mid1 = start1 + ((nums1.length-1 - start1)>>1);
            mid2 = start2 + ((nums2.length-1 - start2)>>1);
        }
        if(mid == 2) {
            if(nums1[start1]<nums2[start2]){
                start1++;
            }else{
                start2++;
            }
            mid--;
        }


        if(isOdds){
            return Math.min(nums1[start1],nums2[start2]);
        }else{
            int op1 = 0;
            if(nums1[start1]<nums2[start2]){
                op1 = nums1[start1];
                start1++;
            }else{
                op1 = nums2[start2];
                start2++;
            }

            int op2 = 0;
            if(nums1[start1]<nums2[start2]){
                op2 = nums1[start1];
                start1++;
            }else{
                op2 = nums2[start2];
                start2++;
            }
            return (double)(op1+op2)/2;
        }
    }



    @Test
    public void test1(){
        int[] num1 = {1};
        int[] num2 = {2,3,4,5,6,7};
        //System.out.println(findMedianSortedArrays(num1,num2));
    }
}


