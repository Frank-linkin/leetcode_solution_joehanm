package NowCoder;

import java.util.Scanner;

public class Meituan_9_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int m = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            if(a>b){
                int tem = a;
                a = b;
                b= tem;
            }//保证b为最大值，a为最小值
            int[] prepared = new int[m];
            boolean max = false;
            boolean min = false;
            boolean wrong = false;
            for(int i = 0 ; i < m ; i ++){
                prepared[i] = in.nextInt();
                if(prepared[i]==a){
                    min=true;
                }
                if(prepared[i]==b){
                    max =true;
                }
                if(prepared[i]<a||prepared[i]>b){
                    wrong = true;
                }
            }
            if(wrong){
                System.out.println(false);
            }
            else if(max&&min)
                System.out.println(true);
            else if((max||min)&&n-m>0){
                System.out.println(true);
            }
            else if((n-m)>=2){
                System.out.println(true);
            }
            else{
                System.out.println(false);
            }
        }
    }
}
