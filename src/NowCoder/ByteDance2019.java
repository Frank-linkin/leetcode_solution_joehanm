package NowCoder;

import java.util.Scanner;

public class ByteDance2019 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s;
        ByteDance2019 Main = new ByteDance2019();
        for(int i = 0 ; i <n ; i++){
            s = in.next();
            System.out.println(Main.process(s.toCharArray()));
        }
    }
    public String process(char[] s){
        char one='\0',two='\0',three='\0';
        int delno=0;
        if(s.length<3)
            return new String(s);
        two = s[0];
        three = s[1];
        if(s.length==3){
            if(three==two&&s[2]==three){
                s[2]='\0';
            }
            return new String(s);
        }
        for(int i = 2; i<s.length ; i++){
            if(s[i]==three&&two==one){
                delno++;
            }
            else if(s[i]==three&&three==two){
                delno++;
            }
            else{
                s[i-delno]=s[i];
                one = two;
                two = three;
                three = s[i];
            }
        }
        char[] res = new char[s.length-delno];
        for(int i = 0 ; i<(s.length-delno);i++){
            res[i]=s[i];
        }
        return new String(res);
    }
}
