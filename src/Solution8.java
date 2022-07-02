import org.junit.Test;

public class Solution8 {
    public int myAtoi(String s) {
        if(s==null||s.length()==0) {
            return 0;
        }
        char[] charStr = s.toCharArray();
        int i = 0 ;
        int resp = 0;
        //去除空格
        while(i<charStr.length&&charStr[i]==' '){
            i++;
        }
        if(i==charStr.length) {
            return 0;
        }

        boolean isPositive = true;
        if(charStr[i]=='+'||charStr[i]=='-') {
            if(charStr[i] == '-'){
                isPositive = false;
            }
            i++;
        }

        //开始处理数值，最好不要溢出
        for(;i<charStr.length ; i++) {
            if(charStr[i]<='9'&&charStr[i]>='0'){
                if(resp > 214748364){
                    resp = isPositive?2147483647:-2147483648;
                    return resp;
                }
                else if(resp== 214748364){
                    if(isPositive){
                        if(charStr[i]-'0'>7){
                            return 2147483647;
                        }
                    }else{
                        if(charStr[i]-'0'>=8){
                            return -2147483648;
                        }
                    }

                }
                resp = resp*10 + (charStr[i]-'0');
            }
            else{
                return resp;
            }
        }
        return isPositive?resp:-resp;
    }

    @Test
    public void test1(){
        String data = "   +2434 ";
        System.out.println(myAtoi(data));
        int a = 2147483647;
        System.out.println(a);
    }
}
