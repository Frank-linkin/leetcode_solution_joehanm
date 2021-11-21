public class Solution48 {
    public void rotate(int[][] matrix) {
        if(matrix==null||matrix.length ==0||matrix[0].length<=1) return;
        int limit = matrix.length/2-1;
        for(int i = 0 ; i <=limit ; i++){//m是层数
            for(int j = i;j<matrix.length-i;j++){
                int temi=i,temj=j;
                int tem = matrix[temj][matrix.length-1-temi];
                int last= matrix[temi][temj];
                for(int m = 0 ; m<4;m++){
                    tem =  matrix[temj][matrix.length-1-temi];
                    matrix[temj][matrix.length-1-temi]=last;
                    last = temj;
                    temj = matrix.length-1-temi;
                    temi = last;
                    last = tem;
                }
            }
        }
    }
}
