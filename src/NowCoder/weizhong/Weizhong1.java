package NowCoder.weizhong;

import java.util.Scanner;

public class Weizhong1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] data = new int[n];
        for(int i = 0 ; i < n ; i++){
            data[i] = in.nextInt();
        }
        //数据接收完毕
        int deleteNum = 0;
        int lastMax = data[0];
        for(int i = 0 ; i < n ; i++){
            if(data[i]>lastMax){
                int count = 0;
                for(int j = 0 ;  j < (i-deleteNum) ; j++){
                    if(data[j]<data[i]){
                        count++;
                    }
                }
                deleteNum+=count;
                lastMax=data[i];
            }
            if(data[i]<lastMax){
                lastMax=data[i];
            }
            data[i-deleteNum] = data[i];
        }
        System.out.println(n-deleteNum);
        System.out.printf("%d",data[0]);
        for(int i = 1 ; i <(n-deleteNum);i++){
            System.out.printf(" %d",data[i]);
        }
    }
}
