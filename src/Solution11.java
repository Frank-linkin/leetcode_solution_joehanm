import org.junit.Test;

public class Solution11 {
    //version1 2021/04
    public int maxArea_version1(int[] height) {
        if(height == null||height.length == 0 || height.length ==1){
            return 0;
        }

        //正式进入函数处理过程
        int b = 0,e = height.length-1;
        int maxcapacity = 0;
        int capNow =0 ;
        while(b<e){
            capNow = (height[b]>height[e]?height[e]:height[b])*(e-b);
            if(maxcapacity<capNow){
                maxcapacity = capNow;
            }
            if(height[b]<height[e]){
                b++;
            }
            else {
                e--;
            }
        }
        return maxcapacity;
    }

    public int maxArea(int[] height) {
        if(height==null||height.length<1){
            return 0;
        }
        int left = 0 ,right = height.length-1;
        int maxCapacity = 0;
        int lastLowestSide = 0;
        while(left < right ){
            int capacity = (right-left)*(height[right]>height[left]?height[left]:height[right]);
            maxCapacity = maxCapacity>capacity?maxCapacity:capacity;
            if (height[left] < height[right]) {
                lastLowestSide = left;
                while(left < right&&height[left]<=height[lastLowestSide]){
                    left++;
                }
            }
            else{
                lastLowestSide = right;
                while(left < right&&height[right]<=height[lastLowestSide]){
                    right--;
                }
            }
        }
        return maxCapacity;
    }
    @Test
    public void test1(){
        int[] data = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(data));
    }
}
