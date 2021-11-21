package NowCoder;

import java.util.Scanner;

public class weizhong2 {
    static int px ,py,m,n,K;
    int max=0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        K = in.nextInt();
        px = in.nextInt();
        py = in.nextInt();
        int[][] data = new int[n][m];
        for(int i = 0; i < n ; i++){
            for(int j = 0 ; j < m ;j++){
                data[i][j]=in.nextInt();
            }
        }
        boolean[][] flag = new boolean[n][m];
    }

    public int search(int x,int y,boolean[][] flag,int[][] data,int step,int sum){
        if(step==0){
            if(x==px&&y==py){
                if(max<sum)
                    max = sum;
                return sum;
            }
            else{
                return -1;
            }
        }

        int tem = 0,mmax=0;
        boolean deadend=true;
        if(x-1>0&&!flag[x-1][y]&&data[x-1][y]!=-1){
            flag[x-1][y] = true;
            tem= search(x-1,y,flag,data,step-1, sum+data[x][y]);
            if(tem!=-1){
                deadend=false;
            }
            if(mmax<tem){
                mmax = tem;
            }
            flag[x-1][y] = false;
        }
        if(x+1<n&&!flag[x+1][y]&&data[x+1][y]!=-1){
            flag[x+1][y] = true;
            tem = search(x+1,y,flag,data,step-1, sum+data[x][y]);
            if(tem!=-1){
                deadend=false;
            }
            if(mmax<tem){
                mmax = tem;
            }
            flag[x+1][y] = false;
        }
        if(y-1>0&&!flag[x][y-1]&&data[x][y-1]!=-1){
            flag[x][y-1] = true;
            tem = search(x,y-1,flag,data,step-1, sum+data[x][y]);
            flag[x][y-1] = false;
            if(tem!=-1){
                deadend=false;
            }
            if(mmax<tem){
                mmax = tem;
            }
        }
        if(y+1<m&&!flag[x][y+1]&&data[x][y+1]!=-1){
            flag[x][y+1] = true;
            tem = search(x,y+1,flag,data,step-1, sum+data[x][y]);
            if(tem!=-1){
                deadend=false;
            }
            if(mmax<tem){
                mmax = tem;
            }
            flag[x][y+1] = false;
        }
        if(deadend){
            return -1;
        }
        else{
            return mmax;
        }
    }
}
