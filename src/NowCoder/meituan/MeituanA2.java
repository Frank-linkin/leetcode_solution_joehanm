package NowCoder.meituan;

import java.util.Scanner;

public class MeituanA2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] data = in.nextLine().toCharArray();
        int Q = in.nextInt();
        for(int q=0;q<Q;q++){
            int left = in.nextInt();
            int right = in.nextInt();
            int step = in.nextInt();
            left-=1;right-=1;
            step=step%26;
            for(int i = left ; i <= right ; i++){
                data[i]-=step;
                if(data[i]<'a'){
                    data[i]+=26;
                }
            }
        }
        System.out.println(new String(data));
    }
}
