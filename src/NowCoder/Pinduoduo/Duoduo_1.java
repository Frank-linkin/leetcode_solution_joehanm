package NowCoder.Pinduoduo;

import java.util.Scanner;

public class Duoduo_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        if(N>45){
            System.out.println(-1);
            return;
        }
        //使用贪心算法
        boolean[] num = new boolean[10];
        for(int i = 9;i>=0;i--){
            if(N>i){
                N = N - i;
                num[i] = true;
            }
            else if(N==i){
                num[i] = true;
                break;
            }
            else{
                num[N] = true;
            }
        }
/*
        for(int i =0  ; i  < 10 ; i++){
            if(num[i])
                System.out.printf("%d ",i);
        }*/
        int res = 0;
        for(int i = 0 ; i< 10; i++){
            if(num[i])
                res = res *10+i;
        }
        System.out.println(res);
    }
}
