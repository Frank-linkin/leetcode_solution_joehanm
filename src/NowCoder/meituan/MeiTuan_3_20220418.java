package NowCoder.meituan;

import java.util.Scanner;
import java.util.Arrays;



public class MeiTuan_3_20220418 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        MyEntry[] entrys = new MyEntry[m];
        for(int i = 0 ; i< m ;i++){
            entrys[i] = new MyEntry();
        }
        for(int i = 0 ; i< m ; i++ ) {
            entrys[i].setLeft(in.nextInt());
        }
        for(int i = 0 ; i< m ; i++ ) {
            entrys[i].setRight(in.nextInt());
        }
//        Arrays.sort(entrys,(MyEntry a,MyEntry b)->{
//            if (a.left!=b.left) {
//                return a.left-b.left;
//            }else{
//                return a.right-b.right;
//            }
//        });

        int[] count = new int[n+1];
        for(MyEntry a:entrys){
            for(int i = a.left;i<=a.right;i++) {
                count[i]++;
            }
        }
        int countGoods=0;
        for(int i = 1;i<=n;i++){
            if(count[i]>=2){
                countGoods++;
            }
        }
        System.out.println(countGoods);
    }

    static class MyEntry{
        int left;
        int right;
        public void setLeft(int left){
            this.left= left;
        }
        public void setRight(int right) {
            this.right = right;
        }
    }
}
