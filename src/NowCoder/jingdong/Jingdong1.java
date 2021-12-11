package NowCoder.jingdong;

import java.lang.reflect.ParameterizedType;
import java.util.Scanner;

public class Jingdong1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        long n = in.nextInt();
        char[] str = s.toCharArray();
        long left = n%(str.length);
        long div = n/str.length;
        long[] count  = new long[26];
        if(n<=str.length){
            for(int i = 0 ; i<n ; i++){
                count[str[i]-'a']++;
            }
        }
        else{
            for(int i = 0 ; i< str.length ; i++){
                count[str[i]-'a']++;
            }
            if(div>1){
                for(int i = 0; i < 26 ; i++){
                    count[i] = count[i]*div;
                }
            }
            for(int i = 0 ; i< left ; i++){
                count[str[i]-'a']++;
            }
        }

        long max = Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        for(int i = 0 ; i< 26 ; i ++){
            max = count[i]>max?count[i]:max;
            if(count[i]!=0){
                min = count[i]<min?count[i]:min;
            }
        }

        //System.out.prlongf("max=%d min = %d\n ",max,min);
        //判断是不是质数
        long a = max - min;
        for(long i =2;i*i<=a;i++){
            if(a%i==0){
                System.out.println("No");
                System.out.println(a);
                return;
            }
        }
        System.out.println("Yes");
        System.out.println(a);
    }
}
