package NowCoder;

import java.util.Scanner;

public class ByteDance2019_7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] data = new int[n];
        for(int i = 0 ; i< n ; i ++){
            data[i] = in.nextInt();
        }
        //2的n次方*p>2的n-1次方data[n-1]-2的n-2次方的data[n-2]
        double a = Math.pow(2,n);
        double jie = 2;
        double res = 0;
        for(int i = 0 ; i<n ;i++){
            res+=(data[i]/jie);
            jie*=2;
        }
//        System.out.println(res);
        res = (int)res+1;
        System.out.println((int)res);
    }
}
