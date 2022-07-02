package NowCoder.meituan;

import java.util.Scanner;

public class MeiTuan_4_20220418 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();

        System.out.println(count(m,n,0));
    }

    public static int count(int m ,int n,int k) {
        if(n>m) {
            int tem = n;
            n = m ;
            m = tem;
        }
        int halfm = m>>1;
        if(m==n) {
            return k;
        }else if(m==n+1){
            return k+1;
        }else if(n<=halfm){
            return count(halfm,n,k+1);
        }else{
            if(m-n>=4){
                int halfn = n>>1;
                return count(halfm,halfn,k+2);
            }else{
                return (k+m-n);
            }
        }
    }
}
