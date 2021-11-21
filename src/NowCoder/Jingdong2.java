package NowCoder;

import java.util.Scanner;

public class Jingdong2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] homework = new int[n];
        for(int i = 0 ; i < n ; i++){
            homework[i] = in.nextInt();
        }
        if(n==1){
            System.out.println(homework[0]);
            return;
        }
        if(n==2){
            System.out.println(homework[0]>homework[1]?homework[0]:homework[1]);
        }
        if(n==3){
            System.out.println((homework[0]+homework[2])>homework[1]?(homework[0]+homework[2]):homework[1]);
        }
        //
        int[][] dp = new int[2][n];
        //第0行表示今天不做
        //第1行表示今天做

        dp[0][0] = 0 ;
        dp[1][0] = homework[0];
        dp[0][1] = dp[1][0];
        dp[1][1] = homework[1];
        dp[0][2] = homework[1];
        dp[1][2] = homework[2]+homework[0];
        int max = 0;
        int i = 0;
        for(i=0;i<3;i++){
            if(dp[0][i]>max){
                max = dp[0][i];
            }
            if(dp[1][i]>max){
                max = dp[1][i];
            }
        }
        for(;i<n;i++){
            dp[0][i] = Math.max(dp[1][i-1],dp[1][i-2]);
            dp[1][i] = Math.max(dp[1][i-3],dp[1][i-2]);
            dp[1][i]+=homework[i];
            if(dp[0][i]>max){
                max = dp[0][i];
            }
            if(dp[1][i]>max){
                max = dp[1][i];
            }
        }
        System.out.println(max);
    }

}
