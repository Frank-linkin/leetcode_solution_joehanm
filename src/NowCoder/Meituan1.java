package NowCoder;

import java.util.Arrays;
import java.util.Scanner;

public class Meituan1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        //int n = 7;
        int x = in.nextInt();
        int y = in.nextInt();
        int[] data = new int[n];
   //     int[] data = {1,2,3,3,4,5,7};
        for(int i = 0 ; i<n;i++){
            data[i] = in.nextInt();
        }
        Arrays.sort(data);
        for(int i = 0 ; i< n ; i++){
            while(i+1<n&&data[i+1]==data[i]){
                i++;
            }
            if((i+1)>=x&&(i+1)<=y&&(n-i)>=x&&(n-i)<=y){
                System.out.println(data[i]);
                return;
            }
        }
        System.out.println(-1);
        return ;
    }
}
