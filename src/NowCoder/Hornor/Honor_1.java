package NowCoder.Hornor;

import java.util.Scanner;

public class Honor_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int[] data = new int[10];
        for(int t = 0 ; t < T; t++){
            for(int i = 0; i < 10 ; i++){
                data[i]  = in.nextInt();
            }

            int left =2048;
            int count = 0;
            int point = 1024;
            int tem = 0;
            for(int i = 9 ; i>=0 ; i--){
                if(data[i]>0){
                    if(data[i]*point>left){
                        if(left%point==0){
                            count+=left/point;
                            break;
                        }
                        tem = left/point;
                        left= left - tem * point;
                        count +=tem;
                    }
                    else if(data[i]*point==left){
                        count+=data[i];
                        break;
                    }
                    else{
                        left = left  - (data[i]*point);
                        count+=data[i];
                    }


                }
                point=point/2;
            }
            count--;
            System.out.println(count);
        }
    }
}
