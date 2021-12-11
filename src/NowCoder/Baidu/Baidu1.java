package NowCoder.Baidu;

import org.junit.Test;

import java.util.Scanner;

public class Baidu1 {


    public int findLen(int a,int b){
        //永远保持a<b
        if(a>b){
            int tem = a;
            a = b;
            b = tem;
        }
        //计算a的层数
        int la =0 ,tema= a;
        while(tema!=0){
            tema=tema>>1;
            la++;
        }
        //计算b的层数
        int lb =0 ,temb= b;
        while(temb!=0){
            temb=temb>>1;
            lb++;
        }
        //lc表示共同祖先所在的层数
        int lc =0;
        tema=a;temb=b;
        while(tema!=0){
            while(temb>tema){
                temb=temb>>1;
            }
            if(temb==tema){
                while(temb!=0){
                    temb=temb>>1;
                    lc++;
                }
                break;
            }
            tema=tema>>1;
        }
        int res = ((lb-lc)+(la-lc));
        return (lb-lc)+(la-lc);
    }

    @Test
    public void test1(){
        System.out.println(findLen(4,6));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 1;
        for(int i = 0 ; i < n ; i++){
            int a = 4;
            int b = 10;
            //永远保持a<b
            if(a>b){
                int tem = a;
                a = b;
                b = tem;
            }
            //计算a的层数
            int la =0 ,tema= a;
            while(tema!=0){
                tema=tema>>1;
                la++;
            }
            //计算b的层数
            int lb =0 ,temb= b;
            while(temb!=0){
                temb=temb>>1;
                lb++;
            }
            //lc表示共同祖先所在的层数
            int lc =0;
            tema=a;temb=b;
            tema= (tema<<(lb-la));
            tema=(tema^b);
            while(tema!=0){
                tema=tema>>1;
                lc++;
            }
            lc=lb-lc;
            System.out.println(((lb - lc) + (la - lc)));
        }
    }

}
