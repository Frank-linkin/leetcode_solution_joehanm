public class Solution73 {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length ==0) {
            return;
        }

        boolean[] isZero_i = new boolean[matrix.length];
        boolean[] isZero_j = new boolean[matrix[0].length];
        for(int i = 0 ; i < matrix.length ; i++ ) {
            for(int j = 0 ; j< matrix[0].length ; j++) {
                if(matrix[i][j]==0) {
                    isZero_i[i]=true;
                    isZero_j[j]=true;
                }
            }
        }

        for(int i = 0 ; i < matrix.length ; i++ ) {
            for(int j = 0 ; j< matrix[0].length ; j++) {
                if(isZero_i[i]||isZero_j[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
    /**
     * 使用两次遍历的方法：
     *      第一次遍历：记下为0的行和列
     *      第二次遍历：将标记过的行和列清零
     */
}
