public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if ( matrix == null || matrix.length==0||matrix[0].length==0){
            return false;
        }

        int n = 0,m=matrix[0].length-1;
        while(n<matrix.length&&matrix[n][m]<target){
            n++;
        }
        if(n==matrix.length){
            return false;
        }
        while(m>0&&matrix[n][m]>target){
            m--;
        }
        return matrix[n][m]==target;
    }
    /**
     * 一定要注意边界条件的处理
     */
}
