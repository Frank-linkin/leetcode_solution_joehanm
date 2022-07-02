package NowCoder.weizhong;

import java.util.Scanner;

public class Weizhong_20220420_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] myDamage = new int [n];
        int[] hisDamage = new int [n];
        for(int i = 0 ; i< myDamage.length;i++){
            myDamage[i] = in.nextInt();
        }
        for(int i = 0 ; i< hisDamage.length;i++){
            hisDamage[i] = in.nextInt();
        }

        int max = 0,count = 0;
        int mytotal = 0,hisTotal = 0;
        boolean isEqual = true;
        for(int i = 0 ; i< myDamage.length ;i++) {
            mytotal += myDamage[i];
            hisTotal += hisDamage[i];
            if (hisDamage[i]!=myDamage[i]){
                isEqual=false;
            }
            int dif = hisTotal - mytotal;
            if(dif>0){
                int countCur = 0;
                if (dif%(i+1) ==0){
                   countCur  = dif/(i+1);
                }else{
                    countCur = (dif/(i+1))+1;
                }
                max = max<countCur?countCur:max;
            }else if (dif ==0){
                    max = max<1?1:max;

            }
        }
        System.out.println(max);
    }
}
