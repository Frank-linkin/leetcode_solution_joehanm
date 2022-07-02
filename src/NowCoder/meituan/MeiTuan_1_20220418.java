package NowCoder.meituan;

import java.util.Scanner;

public class MeiTuan_1_20220418 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        String s = in.nextLine();
        MeiTuan_1_20220418 main = new MeiTuan_1_20220418();
        System.out.println(main.countSpace(s));
    }

    public int countSpace(String s) {
        int count = 0;
        if (s==null||s.length()==0){
            return count;
        }
        for(int i = 0 ; i<s.length();i++) {
            if(s.charAt(i)==' ') {
                count++;
            }
        }
        return count;
    }
}
