import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if(matrix == null ) return res;

        int top = 0,bottom  = matrix.length-1,right=matrix[0].length-1,left=0;
        int i = 0 , j = 0;
        res.add(matrix[i][j]);
        if(right == 0) {
            while(i<bottom){ i++;res.add(matrix[i][j]);}
            return res;
        }
        while(true){

            while(j<right){ j++;res.add(matrix[i][j]);}
            top++;
            if(i==bottom) return res;


            while(i<bottom){ i++;res.add(matrix[i][j]);}
            right--;
            if(j==left) return res;

            while(j>left){ j--;res.add(matrix[i][j]);}
            bottom--;
            if(i==top) return res;

            while(i>top){ i--;res.add(matrix[i][j]);}
            left++;
            if(j==right) return res;
        }
    }

    @Test
    public void test1(){
        int[][] data = {{2,3,4},{5,6,7},{8,9,10},{11,12,13},{14,15,16}};
        System.out.println(spiralOrder(data));
    }
}
