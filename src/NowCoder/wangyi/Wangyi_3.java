package NowCoder.wangyi;

public class Wangyi_3 {
    //"abc%","zxab%c%%",[%, #]
    public static void main(String[] args) {
        String s  = "0123";
        System.out.println(s.substring(0, 2));

        Wangyi_3 a = new Wangyi_3();
        String s1 = "abc%";
        String s2 = "zxab%c%%";
        char[] clist = {'%','#'};
        System.out.println(a.getMostStr(s1, s2, clist));
    }
    public String getMostStr (String s0, String s1, char[] cList) {
        // write code here
        boolean[] flag = new boolean[256];
        if(cList!=null){
            for(char c : cList){
                flag[(int)c] = true;
            }
        }

        char[] str1 = s0.toCharArray();
        char[] str2 = s1.toCharArray();
        int m=0,n=0;
        int maxstart = 0;
        int maxend = 0;
        int len = 0 ,maxLen = 0;
        boolean isFirst = true;
        for(int i = 0 ; i < str1.length ; i++){
            for(int j = 0 ; j < str2.length ; j++){
                if(str1[i]==str2[j]){
                    len =1;
                    m = i+1;n=j+1;
                    while(m<str1.length&&n<str2.length){
                        while(m<str1.length&&flag[(int)str1[m]]==true){
                            m++;
                        }
                        while(n<str2.length&&flag[(int)str2[n]]==true){
                            n++;
                        }
                        if(m<str1.length&&n<str2.length&&str1[m]==str2[n]){
                            m++;
                            n++;
                            len++;
                        }
                        else{
                            if(len>maxLen){
                                if((m-i)>(n-j)){
                                    maxstart = i;
                                    maxend = m;
                                    isFirst = true;
                                }
                                else{
                                    maxstart = j;
                                    maxend = n;
                                    isFirst= false;
                                }
                                maxLen = len;
                            }
                        }
                    }

                }
            }
        }
        if(isFirst){
            return s0.substring(maxstart,maxend);
        }
        else{
            return s1.substring(maxstart,maxend);
        }
    }
}
