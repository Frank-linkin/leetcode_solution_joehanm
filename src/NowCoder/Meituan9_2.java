package NowCoder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Meituan9_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        Integer[] data = new Integer[n];
        for(int i = 0 ; i < n ; i++){
            data[i] = in.nextInt();
        }

        int res = 0;
        Arrays.sort(data);
        int base = data[n - x];
        for(int i = 0; i < n; i++){
            if(data[i] == 0) continue;
            else if(data[i] == base) {
                res =n - i;
                break;
            }
        }
        System.out.println(res);
/*
        Arrays.sort(data,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o2-o1);
            }
        });
        int p = x-1;
        if(data[p]==0){
            while(p>=0&&data[p]==0){
                p--;
            }
            if(p<0)
                System.out.println(0);
            else
                System.out.println(p+1);
        }
        else{
            while(p<n&&data[p]==data[x-1]){
                p++;
            }
            System.out.println(p);
        }
*/
    }
}
