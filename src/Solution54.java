import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution54 {
    /**
     * [Enlightening]
     * 当进行这种训话控制的之后，需要考虑到，每一步，会发生什么事情，每个变量怎么变化。
     * 比如在这个题目中，一个方法走到了尽头。那么这时候，需要做的事情是：①转变方向 ②调整边界
     * 这两个都要在设计变量的时候就考虑到的，在这个题目中：转变方向，即将count++，调整边界，即
     * bound[(count-1)%4]+deltaY
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> resp = new LinkedList<Integer>();
        if(matrix==null||matrix.length==0||matrix[0].length==0) {
            return resp;
        }
        int[] bounds = new int[4];
        bounds[0] = matrix[0].length-1;
        bounds[1] = matrix.length-1;
        bounds[2] = 0;
        bounds[3] = 0;

        int deltaX = 1,deltaY = 1;
        int p = 0,q=0;
        int count = 4;
        resp.add(matrix[p][q]);
        while(true){
            while(q!=bounds[count%4]){
                q = q + deltaY;
                resp.add(matrix[p][q]);
                //System.out.printf("%d ",matrix[p][q]);
            }
            bounds[(count-1)%4]=bounds[(count-1)%4]+deltaY;
            count++;
            if(p==bounds[count%4]){
                break;
            }

            while(p!=bounds[count%4]){
                p = p + deltaX;
                resp.add(matrix[p][q]);
                //System.out.printf("%d ",matrix[p][q]);
            }
            bounds[(count-1)%4]=bounds[(count-1)%4]-deltaX;
            count++;
            if(q==bounds[count%4]){
                break;
            }
            deltaX = -deltaX;
            deltaY = -deltaY;
        }
        return resp;
    }

    @Test
    public void test1(){
        int[][] data = {{2,3,4},{5,6,7},{8,9,10},{11,12,13},{14,15,16}};
        System.out.println(spiralOrder(data));
    }
    /**
     * 使用题解中的分层的方法
     */
}
