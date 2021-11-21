package NowCoder;

import java.util.Scanner;

public class Meituan2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] data = new int[n];
        for(int i= 0 ; i<n;i++){
            data[i] = in.nextInt();
        }
        int count = 0;
        for(int i = 0 ; i < n ;i++){
            count+= data[i]>(i+1)?(data[i]-(i+1)):(i+1-data[i]);
        }
        System.out.println(count);
    }
}
