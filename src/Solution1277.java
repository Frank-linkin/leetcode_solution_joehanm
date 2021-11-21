public class Solution1277 {
    public int countSquares1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int sum = 0;
        for(int i = 0 ;i < m ; i++){
            for(int j=0 ; j < n ; j ++){
                sum +=countPointSquares(matrix,i,j);
            }
        }


        return sum;
    }
    public int countPointSquares(int[][] matrix,int x, int y){
        int count = 0;
        int maxl = Math.min(matrix.length-x,matrix[0].length-y);

        while(count < maxl){
            for(int i = 0 ; i <=count;i++){
                if(matrix[x+count][y+i] == 0){
                    return count;
                }
            }
            for(int i = 0 ; i <count;i++){
                if(matrix[x+i][y+count] == 0){
                    return count;
                }
            }
            count++;
        }

        return count;
    }

    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] count = new int[m][n];


        int sum = 0;
        for(int i = 0 ; i < m ; i ++){
            for(int j = 0 ; j < n ; j++){
                if( i == 0 || j == 0 ){
                    count[i][j] = matrix[i][j];
                }
                else if( matrix[i][j] == 0 ){
                    count[i][j] = 0;
                }
                else {
                    count[i][j] = Math.min(count[i-1][j],Math.min(count[i-1][j-1],count[i][j-1]))+1;
                }
                //System.out.println("count["+i+"]["+j+"] = "+count[i][j]);
                sum+=count[i][j];
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        int[][] data = {{0,1,1,1},{1,1,1,1},{0,1,1,1}};
        Solution1277 solution1277 = new Solution1277();

        System.out.println(solution1277.countSquares(data));
    }
}
