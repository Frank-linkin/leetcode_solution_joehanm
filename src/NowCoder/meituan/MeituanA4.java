package NowCoder.meituan;

import java.util.Scanner;

public class MeituanA4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char[][] data = new char[n][n];
        for(int N = 0 ; N <n ; N++){
            data[N] = in.next().toCharArray();
        }


        //创建一个dp数组
        int[][] dp = new int[n][n];
        dp[0][0] = 0;
        long sum = 0;
        for(int i=  0 ; i < n ; i++){
            for(int j = 0 ; j<n;j++){
                if(data[i][j]=='#'){
                    dp[i][j]=0;
                }
                else{
                    if(i==0&&j==0){
                        dp[i][j] = 1;
                    }
                    else if(i==0){
                        dp[i][j] = dp[i][j-1]+1;
                    }
                    else if(j==0){
                        dp[i][j] = dp[i-1][j]+1;
                    }
                    else{//i!=0,j!=0
                        dp[i][j] = dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]+1;
                    }
                    sum+=dp[i][j];

                }
            }
        }
        System.out.println(sum);
    }
}
