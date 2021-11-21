import org.junit.Test;

public class Solution42 {
    public int trap(int[] height) {
        if (height == null||height.length==1||height.length==2){
            return 0;
        }
        int left = 0;
        int capacity = 0,partCapacity = 0;
        for(int i = left ; i < height.length ; i++){
            if(height[i]<height[left]){
                partCapacity+=(height[left]-height[i]);
            }
            else{
                left = i;
                capacity+=partCapacity;
                partCapacity=0;
            }
        }
        if(left!=height.length){
            partCapacity = 0;
            int right =  height.length -1;
            for(int i = height.length-1;i>=left;i--){
                if(height[i]<height[right])
                    partCapacity +=(height[right]-height[i]);
                else {
                    right = i;
                    capacity+=partCapacity;
                    partCapacity=0;
                }
            }
        }
        return capacity;
    }

    @Test
    public void test1(){
        int[] data = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(data));
    }
}
