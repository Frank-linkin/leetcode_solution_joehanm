package NowCoder;

import java.util.*;

public class NowCoderWinner {
    public static void main(String[] args) {
        int n = 0;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int res = 0;
        boolean same = false;
        NowCoderWinner nowcoder = new NowCoderWinner();
        int[] result  = new int[3];
        for(int i = 0; i < 3 ; i++){
            result[i] = nowcoder.maxGrades(in.nextLine(),n);
            if(result[res] < result[i]){
                res = i;
            }
            else if(result[res] == result[i]){
                same = true;
            }
        }
        if(same){
            System.out.println("draw");
            return;
        }
        if(res==0){
            System.out.println("xiaoming");
        }
        if(res==1){
            System.out.println("xiaowang");
        }
        if(res==2){
            System.out.println("xiaoli");
        }
    }
    public int maxGrades(String s,int times){
        int[] ch = new int[26];
        for(char c:s.toCharArray()){
            ch[c-'a']++;
        }
        int res = 0;
        for(int i = 0 ; i < ch.length ; i ++){
            int dif = (ch[i]+times) - s.length();
            if(dif==0){
                return s.length();
            }
            else if(dif>0){
                if((dif&1)!=0){
                    res = s.length()-1;
                }
                else{
                    return s.length();
                }
            }
            else{
                if(res<(dif+s.length())){
                    res = dif+s.length();
                }
            }
        }
        return res;
    }
}
