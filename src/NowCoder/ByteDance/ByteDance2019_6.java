package NowCoder.ByteDance;

import java.util.Scanner;

public class ByteDance2019_6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int left = 1024-N;
        int count=0;
        if(left>=64){
            count+=(left/64);
            left = left%64;
        }
        if(left>=16){
            count+=(left/16);
            left = left%16;
        }
        if(left>=4){
            count+=(left/4);
            left = left%4;
        }
        count+=left;
        System.out.println(count);
    }
}
