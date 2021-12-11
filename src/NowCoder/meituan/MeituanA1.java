package NowCoder.meituan;

import java.util.Scanner;

public class MeituanA1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int c = in.nextInt();
        for(int n=0;n<N;n++){
            int rev = in.nextInt();
            rev-=1;
            int dadiao  = rev/c;
            int xuhao = (rev%c)+1;
            System.out.printf("%c%d\n",('A'+dadiao),xuhao);
        }
    }
}
