import org.junit.Test;

public class Solution4 {
    public double findMedianSortedArrays ( int[] nums1, int[] nums2){
            if ((nums1 == null || nums1.length == 0) && nums2 != null) {
                if ((nums2.length & 1) == 1) {
                    return nums2[(nums2.length) >> 1];
                } else {
                    return ((double) nums2[(nums2.length - 1) >> 1] + nums2[((nums2.length - 1) >> 1) + 1]) / 2;
                }
            }
            if ((nums2 == null || nums2.length == 0) && nums1 != null) {
                if ((nums1.length & 1) == 1) {
                    return nums1[(nums1.length) >> 1];
                } else {
                    return ((double) nums1[(nums1.length - 1) >> 1] + nums1[((nums1.length - 1) >> 1) + 1]) / 2;
                }
            }
            int target = (((nums1.length + nums2.length) >> 1)+1);
            int bound1 = -1, bound2 = -1, nextBound1 = 0, nextBound2 = 0;
            int lastNum = 0;
            while (target != 1) {
                int deleteNum = target / 2;
                System.out.printf(" fdeletenum=%d ",deleteNum);
                if (bound1 != nums1.length-1 && bound2 != nums2.length-1) {
                    nextBound1 = (bound1 + deleteNum >= nums1.length) ? (nums1.length - 1) : (bound1 + deleteNum);
                    nextBound2 = (bound2 + deleteNum >= nums2.length) ? (nums2.length - 1) : (bound2 + deleteNum);
                    //System.out.printf("111");
                    deleteNum = Math.min(nextBound1-bound1,nextBound2-bound2);
                    nextBound1 = bound1+deleteNum;
                    nextBound2 = bound2+deleteNum;
                    if (nums1[nextBound1] > nums2[nextBound2]) {
                        //就把<=nextBounds2的元素删除
                        System.out.printf("deletenum=%d ",deleteNum);
                        target -= deleteNum;
                        bound2 = nextBound2;
                    } else {
                        System.out.printf("deletenum=%d ",deleteNum);
                        target -= deleteNum;
                        bound1 = nextBound1;
                    }

                    if(deleteNum == 1) {
                        if(bound1!=nextBound1) {
                            lastNum = nums2[nextBound2];
                        }
                        else {
                            lastNum = nums1[nextBound1];
                        }
                    }
                }
                else if (bound1 == nums1.length-1) {
                    if(deleteNum==1) {
                        lastNum = nums2[bound2+1];
                    }
                    bound2 = bound2 + deleteNum;
                    target -= deleteNum;
                }
                else {//(bound2==nums2.length)
                    if(deleteNum==1) {
                        lastNum = nums1[bound1+1];
                    }
                    bound1 = bound1 + deleteNum;
                    target -= deleteNum;
                }
                //System.out.printf("target = %d\n",target);
            }
       //     System.out.printf("lastnum=%d",lastNum);
            if( ((nums1.length+nums2.length)&1) == 0) {//是奇数
                int nowNum;
                if(bound1 == nums1.length-1){
                    nowNum = nums2[bound2+1];
                }
                else if(bound2 == nums2.length-1){
                    nowNum = nums1[bound1+1];
                }
                else{
                    nowNum = nums1[bound1+1]>nums2[bound2+1]?nums2[bound2+1]:nums1[bound1+1];
                }
                return ((double)nowNum+lastNum)/2;
            }
            else{
                return lastNum;
            }
    }

    @Test
    public void test1(){
        int[] num1 = {0,0,0,0,0};
        int[] num2 = {-1,0,0,0,0,0,1};
        System.out.println(findMedianSortedArrays(num1,num2));
    }



}


