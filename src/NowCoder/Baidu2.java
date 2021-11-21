package NowCoder;

import java.util.Scanner;

public class Baidu2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//参赛选手数目
        int m = in.nextInt();//比赛场数
        int p = in.nextInt();//牛牛编号
        boolean[][] defeat=new boolean[n][n];
        for(int s= 0 ; s <m ;s++){
            int a = in.nextInt();
            int b= in.nextInt();
            //下面开始处理a,b
            defeat[a-1][b-1] = true;
        }

        //从牛牛的编号开始深度优先搜索
        Baidu2 baidu2 = new Baidu2();
        baidu2.dfs(defeat,p,p);
        int count=0;
        for(int i = 0 ; i<n;i++){
            if(defeat[p-1][i]==true){
                count++;
            }
        }
        int possibility = n-count+1;
        for(int i= 0 ; i<possibility;i++){
            
        }
    }

    public void dfs(boolean[][] matrix,int num,int origin){
        for(int j= 0 ; j <matrix.length;j++){
            if(matrix[num][j]==true){
                matrix[origin][j]=true;
                dfs(matrix,j,origin);
            }
        }
    }
}
