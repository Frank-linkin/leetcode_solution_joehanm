package NowCoder.Alibaba;

import java.util.Scanner;

public class Alibaba1 {
    public static int m  = 0;
    public static int n = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();

        int[][] data = new int[n][m];


    }

    public void walk(int[][] data,int p,int q,int direction){
        data[p][q]=1;
        int iniDirection = direction;
        if(direction==1){
            if(check(data,p+1,q,1)){
                walk(data,p+1,q,1);
            }
            else{
                direction++;
            }
        }
        if(direction==2){
            if(check(data,p,q+1,2)){
                walk(data,p,q+1,2);
            }
            else{
                direction++;
            }
            if(direction-iniDirection>1){
                return;
            }
        }
        if(direction==3){
            if(check(data,p-1,q,3)){
                walk(data,p-1,q,3);
            }
            else{
                direction++;
            }
            if(direction-iniDirection>1){
                return;
            }
        }
        if(direction==4){
            if(check(data,p,q-1,4)){
                walk(data,p,q-1,4);
            }
            else{
                direction++;
            }
            if(direction-iniDirection>1){
                return;
            }
        }
        if(direction==5) {
            if (check(data, p + 1, q, 1)) {

            }
        }
    }

    public boolean check(int[][] data,int p,int q,int direction){//
        if(p>=n||q>=m){
            return false;
        }
        if(direction==1){
            if(p+1>=n||(p+1<n&&data[p+1][q]==0)){//前面的前面的情况
                if(q-1>=0&&p+1<=n&&data[p][q-1]==1&&data[p+1][q-1]==1&&data[p+1][q]==1){
                    return false;
                }
                if(p+1<=n&&q+1<=m&&data[p][q+1]==1&&data[p+1][q]==1&&data[p+1][q+1]==1){
                    return false;
                }
                return true;
            }
            return false;
        }
        else if(direction==2){
            if(q+1>=m||(q+1<m&&data[p][q+1]==0)){
                if(q+1<m&&p+1<n&&data[p][q+1]==1&&data[p+1][q+1]==1&&data[p+1][q]==1){
                    return false;
                }
                if(p-1>=0&&q+1<m&&data[p-1][q]==1&&data[p-1][q+1]==1&&data[p][q+1]==1){
                    return false;
                }
                return true;
            }
            return false;
        }
        else if(direction==3){
            if(p-1<0||(p-1>=0&&data[p-1][q]==0)){
                if(p-1>=0&&q-1>=0&&data[p][q-1]==1&&data[p-1][q-1]==1&&data[p-1][q]==1){
                    return false;
                }
                if(p-1>=0&&q+1<m&&data[p-1][q]==1&&data[p-1][q+1]==1&&data[p][q+1]==1){
                    return false;
                }
                return true;
            }
            return false;
        }
        else{
            if(q-1<0||(q-1>=0&&data[p][q-1]==0)){
                if(p-1>=0&&q-1>=0&&data[p-1][q-1]==1&&data[p][q-1]==1&&data[p-1][q]==1){
                    return false;
                }
                if(p+1<n&&q-1>=0&&data[p+1][q-1]==1&&data[p+1][q]==1&&data[p][q-1]==1){
                    return false;
                }
                return true;
            }
            return false;
        }
    }
}
