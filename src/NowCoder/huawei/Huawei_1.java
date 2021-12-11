package NowCoder.huawei;

import java.util.Scanner;

public class Huawei_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();
        int[][] matrix = new int[M][N];
        int[][] count = new int[M][N];
        for(int i = 0 ; i < M ; i++){
            for(int j = 0 ; j < N ; j++){
                matrix[i][j] = in.nextInt();
            }
        }
        int[][] dp = new int[M][N];

        int l = 0 ,r=0,lr = 0;
        Huawei_1 main = new Huawei_1();
        for(int i = 0 ; i< M ; i++){
            for(int j = 0 ; j< N ; j++){
                if(i==0&&j==0){
                    dp[0][0] = matrix[0][0];
                }
                else if(i==0){
                    dp[i][j] = dp[i][j-1]+matrix[i][j];
                }
                else if(j==0){
                    dp[i][j] = dp[i-1][j] + matrix[i][j];
                }
                else{
                    if(matrix[i][j]==matrix[i-1][j]&&dp[i-1][j]>0){
                        r = dp[i-1][j]-1;
                    }
                    else{
                        r = dp[i-1][j];
                    }
                    if(matrix[i][j]==matrix[i-1][j-1]&&dp[i-1][j-1]>0){
                        lr = dp[i-1][j-1]-1;
                    }
                    else{
                        lr = dp[i-1][j-1];
                    }
                    if(matrix[i][j]==matrix[i][j-1]&&dp[i][j-1]>0){
                        l = dp[i][j-1]-1;
                    }
                    else{
                        l = dp[i][j-1];
                    }
                    dp[i][j] = main.min(l,r,lr)+matrix[i][j];
                }
            }
        }


/*        for(int i = 0 ; i< M ; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf(" %d",matrix[i][j]);
            }
            System.out.println();
        }
        for(int i = 0 ; i< M ; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf(" %d",dp[i][j]);
            }
            System.out.println();
        }*/

        System.out.println(dp[M-1][N-1]);
    }
    public int min(int a,int b,int c){
        if(a<b){
            if(a<c){
                return a;
            }
            else{
                return c;
            }
        }
        else{//a>=b
            if(b<c){
                return b;
            }
            else{
                return c;
            }
        }
    }
}
