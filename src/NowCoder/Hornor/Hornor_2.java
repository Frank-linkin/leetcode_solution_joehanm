package NowCoder.Hornor;

import java.util.HashMap;
import java.util.Scanner;

public class Hornor_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Hornor_2 a = new Hornor_2();
        int m = in.nextInt();
        in.nextLine();
        char[] data  = null;
        HashMap<String, Integer> map = new HashMap<>();

        int val = 0;
        int tem = 0;
        boolean isNA = false;
        String str = null;


        for(int i = 0 ; i < m ; i++){
            str = in.nextLine();
            System.out.println(str.length());
            data = str.toCharArray();
            int j = 0;
            for(;j<data.length&&data[j]!='=';j++);
            String left = a.getName(data,0,j-1);

            j++;
            int last = j;
            val = 0;
            String s = null;
            while(j<data.length){
                while(j<data.length&&(data[j]==' '||data[j]=='+')) j++;
                if(j<data.length){
                    System.out.printf("data[%d]=%c",j,data[j]);
                }
                if(j<data.length&&data[j]>='0'&&data[j]<='9'){
                    tem = 0;
                    while(j<data.length&&(data[j]>='0'&&data[j]<='9')){
                        tem = tem*10+(data[j]-'0');
                        j++;
                    }
                    last = j;
                    val+=tem;
                }
                else{
                    while(j<data.length&&data[j]!=' '&&data[j]!='+') j++;
                    s = a.getName(data,last,j-1);
                    last = j;
                    System.out.println("变量s= "+s+"j="+j);
                    if(map.containsKey(s)){
                        tem = map.get(s);
                        val +=tem;
                    }
                    else{
                        isNA = true;
                        break;
                    }
                }
            }
            System.out.printf("添加%s=%d[]",left,val);
            map.put(left,val);
        }


        if(isNA){
            System.out.println("NA");
        }
        else{
            System.out.println(val);
        }
    }

    public String getName(char[] data,int left ,int right){
        int i= left;
        while(i<right&&(data[i]==' '||data[i]=='+')) i++;
        int s = i;
        while(i<=right&&(data[i]!=' '||data[i]!='+')) i++;

        return new String(data,s,i-s);
    }
}
