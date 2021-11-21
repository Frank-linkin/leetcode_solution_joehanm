package NowCoder;

import java.util.Scanner;

public class ByteDance2019_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[] building = new int[n];
        for(int i = 0 ; i< n ; i++){
            building[i]=in.nextInt();
        }
        if(n<3){
            System.out.println(0);
            return;
        }
        int count = 0;

        for(int i = 0 ; i < building.length-2;i++){
            int end = i +2;
            if(building[end]-building[i]<=d){
                while(end<building.length&&building[end]-building[i]<=d) end++;

                int result = 0;
                if(((end-i-2)&1)!=0){
                    result = (((end-i-2)>>1)+1)*(end-i-2);
                }
                else
                    result=((end-i-1))*((end-i-2)/2);



                count+=result;
                count= count%99997867;
            }
        }
        System.out.println(count);
    }
}
