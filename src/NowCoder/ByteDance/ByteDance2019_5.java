package NowCoder.ByteDance;

import java.util.Scanner;

public class ByteDance2019_5 {
    public static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] price = new int[n][n];
//        int n = 4;
//        int[][] price = {{0,2,6,5}
//                ,{2,0,4,4}
//        ,{6,4,0,2}
//        ,{5,4,2,0}};
        boolean[] flag = new boolean[n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                price[i][j] = in.nextInt();
            //    System.out.printf("%d ",price[i][j]);
            }
          //  System.out.println();
        }
        ByteDance2019_5 main = new ByteDance2019_5();
        main.dfs(price,0,flag,0);
        System.out.println(min);
    }

    public void dfs(int[][] price,int k,boolean[] flag,int val){//现在所在的结点是k
        boolean isEnd = true;
        for(int i= 1; i<price.length ; i++){
            if(flag[i]==false){
                isEnd = false;
                flag[i] = true;
                dfs(price,i,flag,val+price[k][i]);
                flag[i] = false;
            }
        }
        if(isEnd){
            if(val+price[0][k]<min){
                min = (val+price[0][k]);
            }
        }
    }
}
