package NowCoder.meituan;

import java.util.Scanner;

public class Meituan9_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t = 0 ; t < T; t++) {
            int n = in.nextInt();
            int[] data = new int[n];
            for (int i = 0; i < n; i++) {
                data[i] = in.nextInt();
            }

            int[] mindp = new int[n];
            int[] maxdp = new int[n];

            if(data[0]>=0){
                maxdp[0]=data[0];
                mindp[0]=0;
            }
            else{
                maxdp[0] = 0;
                mindp[0] = data[0];
            }
            int max = 0;
            int min = 0;
            int sum = data[0];
            for(int i = 1 ; i< n ; i++){
                maxdp[i] = (maxdp[i-1]+data[i])>data[i]?(maxdp[i-1]+data[i]):data[i];
                mindp[i] = (mindp[i-1]+data[i])<data[i]?(mindp[i-1]+data[i]):data[i];
           //     System.out.printf("maxdp[i]=%d,mindp[i]=%d\n",maxdp[i],mindp[i]);
                max =maxdp[i]>max?maxdp[i]:max;
                min =mindp[i]<min?mindp[i]:min;
                sum+=data[i];
            }
            if(max<(sum-min)){
                max = (sum-min);
            }

            System.out.println(max);
        }
    }
}
