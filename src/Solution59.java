import org.junit.Test;

public class Solution59 {
    public int[][] generateMatrix_1(int n) {
        int[][] matrix = new int[n][n];
        int number = 1;
        matrix[0][0] = number;

        int[] bounds = new int[4];
        bounds[0] = n-1;
        bounds[1] = n-1;
        bounds[2] = 0;
        bounds[3] = 0;
        int count = 4;
        int p=0,q=0;
        while(true){
            while(q!=bounds[count&3]){
                q++;
                matrix[p][q] = ++number;
            }
            if((count&3)==0||(count&3)==3){
                bounds[(count-1)&3]++;
            }else{
                bounds[(count-1)&3]--;
            }
            count++;
            if(p==bounds[count&3]){
                break;
            }

            while(p!=bounds[count&3]){
                p++;
                matrix[p][q] = ++number;
            }
            if((count&3)==0||(count&3)==3){
                bounds[(count-1)&3]++;
            }else{
                bounds[(count-1)&3]--;
            }
            count++;
            if(q==bounds[count&3]){
                break;
            }
        }
        return matrix;
    }


    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int left = 0,right=n-1,up=0,down=n-1;
        int p=0,q=0;
        int num = 2;
        matrix[0][0]=1;
        while(true){
            while(q+1<=right){
                q++;
                matrix[p][q] = num;
                num++;
            }
            up++;
            if(down==p){
                break;
            }

            while(p+1<=down){
                p++;
                matrix[p][q] = num;
                num++;
            }
            right--;
            if(left==q){
                break;
            }

            while(q-1>=left){
                q--;
                matrix[p][q] = num;
                num++;
            }
            down--;
            if(up==p){
                break;
            }
            while(p-1>=up){
                p--;
                matrix[p][q] = num;
                num++;
            }
            left++;
            if(right==q){
                break;
            }
        }
        return matrix;
    }
    @Test
    public void test1(){
        int n = 3;
        int[][] matrix = generateMatrix(n);
        for(int i = 0 ; i < n; i++) {
            for(int j = 0;j<n;j++){
                System.out.printf("%d ",matrix[i][j]);
            }
            System.out.println();
        }
    }
    /**
     * 使用题解中分层的思维。
     * left,right,up,down来表示当前层的边界，
     * 当遍历完up这一行后，up--,
     *
     */
}
