import java.util.Scanner;

public class AcWing3 {
    public int getMaxValue_goodsFirst(int[] weight,int[] value,int n,int capacity){
        if(capacity == 0){
            return 0;
        }
        else if(n == 0){
            return 0;
        }

        int[][] dp = new int[n][capacity+1];
        //外层遍历物品，内层遍历重量
        dp[0][0] = 0;
        for(int i = 0 ;i < n ; i ++){
            for(int j = 0 ; j <= capacity ;j++){
                if(j<weight[i]){
                    if(i==0){
                        dp[i][j] = 0;
                    }
                    else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
                else{
                    if(i==0){
                        dp[i][j] = dp[i][j-weight[i]]+value[i];
                    }
                    else{
                        dp[i][j] = dp[i-1][j]>(dp[i][j-weight[i]]+value[i])?dp[i-1][j]:(dp[i][j-weight[i]]+value[i]);
                    }
                }
            }
        }

        //显示dp数组
        for(int i = 0 ; i < n ;i ++){
            for(int j = 0 ; j <= capacity ; j++){
                System.out.printf("%d ",dp[i][j]);
            }
            System.out.println();
        }
        return dp[n-1][capacity];
    }

    public int getMaxValue_weightFirst(int[] weight,int[] value,int n,int capacity){
        if(capacity == 0){
            return 0;
        }
        else if(n == 0){
            return 0;
        }

        int[][] dp = new int[n][capacity+1];
        //外层遍历物品，内层遍历重量
        dp[0][0] = 0;
        for(int j = 0 ; j <= capacity ;j++){
            for(int i = 0 ;i < n ; i ++){
                if(j<weight[i]){
                    if(i==0){
                        dp[i][j] = 0;
                    }
                    else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
                else{
                    if(i==0){
                        dp[i][j] = dp[i][j-weight[i]]+value[i];
                    }
                    else{
                        dp[i][j] = dp[i-1][j]>(dp[i][j-weight[i]]+value[i])?dp[i-1][j]:(dp[i][j-weight[i]]+value[i]);
                    }
                }
            }
        }

        //显示dp数组
        for(int i = 0 ; i < n ;i ++){
            for(int j = 0 ; j <= capacity ; j++){
                System.out.printf("%d ",dp[i][j]);
            }
            System.out.println();
        }
        return dp[n-1][capacity];
    }

    public static void main(String[] args) {
/*
        int n,capacity;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        capacity = sc.nextInt();
        int[] weight = new int[n];
        int[] value = new int[n];
        for(int i = 0 ; i < n ;i++){
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
//            System.out.print(weight[i]+" ");
//            System.out.println(value[i]);
        }
*/


        int[] weight = {1,3,4};
        int[] value = {15,20,30};
        int n = 3;
        int capacity = 4;
        AcWing3 acWing3 = new AcWing3();
        acWing3.getMaxValue_goodsFirst(weight,value,n,capacity);
        acWing3.getMaxValue_weightFirst(weight,value,n,capacity);

    }

}
