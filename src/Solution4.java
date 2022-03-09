import org.junit.Test;

public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null&&nums2==null ){
            return 0;
        }
        else if(nums1 == null||nums1.length==0) {
            if((nums2.length & 1)==1) {
                return nums2[(nums2.length-1)/2];
            }
            else{
                return (nums2[(nums2.length-1)/2]+nums2[(nums2.length+1)/2])/2.0;
            }
        }
        else if (nums2 ==null||nums2.length==0) {
            if((nums1.length & 1)==1) {
                return nums1[(nums1.length-1)/2];
            }
            else{
                return (nums1[(nums1.length-1)/2]+nums1[(nums1.length+1)/2])/2.0;
            }
        }

        int totalLen = nums1.length + nums2.length;
        boolean isOdd=false;
        if((totalLen & 1 )== 1 ) {
            isOdd = true;
        }

        int k = (totalLen+1)/2;
        int p1 = 0,p2 = 0;
        while(k>3){
            int step = k/2-1;
            if(p1+step>=nums1.length||p2+step>=nums2.length){
                break;
            }
            if(nums1[p1+step]<nums2[p2+step]){
                p1 = p1+step;
            }else{
                p2 = p2+step;
            }
            k=k-step;
        }
        int last=0,lastlast=0;
        while(k>=0){
            lastlast = last;
            if(p1>=nums1.length){
                last=nums2[p2];
                p2++;
            }
            else if(p2>=nums2.length) {
                last=nums1[p1];
                p1++;
            }
            else if(nums1[p1]<nums2[p2]) {
                last=nums1[p1];
                p1++;
            }
            else{
                last=nums2[p2];
                p2++;
            }
            k--;
        }
        System.out.println(lastlast);
        System.out.println(last);
        if (isOdd) {
            return lastlast;
        }
        else{
            return (last+lastlast)/2.0;
        }
    }


    @Test
    public void test1(){
        int[] num1 = {1};
        int[] num2 = {2,3,4,5,6,7};
        System.out.println(findMedianSortedArrays(num1,num2));
    }
}


