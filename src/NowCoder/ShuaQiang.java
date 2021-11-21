package NowCoder;

import org.junit.Test;

import java.util.Scanner;

public class ShuaQiang {
    public static void main(String[] args) {
        int n = 0;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        char[] data = in.next().toCharArray();
  //      n = 3;
        //char[] data = {'0','0','1'};
        int blue = 0;
        for(int i = 0 ; i<data.length ; i++){
            if(data[i]=='1'){
                blue++;
            }
        }
        int cb = 0;//
        //全为0的情况，将blue全部消灭
        int res = blue;
        for(int i = 0;i<data.length;i++){
            if(data[i]=='1'){
                cb++;
            }
            if(((i+1)-cb)+(blue-cb)<res){
                res = ((i+1)-cb)+(blue-cb);
            }
        }
        System.out.println(res);
    }

    @Test
    public void test1(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.nextLine();
        System.out.println(n);
        System.out.println(s);
        System.out.println("end");
    }
}
