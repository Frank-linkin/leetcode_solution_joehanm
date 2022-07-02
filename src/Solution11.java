import org.junit.Test;

public class Solution11 {
    /**
     * 使用双指针
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if( height == null || height.length < 2 ) {
            return 0;
        }

        int left=0,right = height.length-1;
        int maxCapacity = -1;
        while(left<right) {
            int curCapacity = -1;
            if(height[left] < height[right]) {
                curCapacity = height[left]*(right - left);
                int tem = height[left];
                while(left<right&&height[left]<=tem) {
                    left++;
                }
            }
            else{
                curCapacity = height[right]*(right - left);
                int tem = height[right];
                while(left<right&&height[right]<=tem) {
                    right--;
                }
            }

            maxCapacity = maxCapacity<curCapacity?curCapacity:maxCapacity;
        }
        return maxCapacity;
    }


    @Test
    public void test1(){
        int[] data = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(data));
    }
}
