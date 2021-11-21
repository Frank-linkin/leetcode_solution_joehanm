import org.junit.Test;

public class Solution224 {
    int maxRight=0;
    public int calculate(String s) {
        return cal(s,0);
    }
    public int cal(String s, int start){
        int sum = 0;
        boolean add = true;
        char now = s.charAt(start);
        while(start<s.length()){
            if(now=='('){
                sum =add?(sum+cal(s,start+1)):(sum-cal(s,start+1));
                start = maxRight;
            }
            if (now=='+'){
                add=true;start++;
            }
            if (now=='-'){
                add=false;start++;
            }
            if (now>='0'&&now<='9'){
                int num = now-'0';
                start++;
                if(start == s.length()){
                    now = 'a';
                }
                else{
                    now = s.charAt(start);
                }
                while(now>='0'&&now<='9'){
                    num=num*10+(now-'0');
                    start++;
                    if(start>=s.length())
                        now = 'a';
                    else{
                        now=s.charAt(start);
                    }
                }
                sum =add?(sum+num):(sum-num);
            }
            if(now == ' '){
                start++;
            }
            if (now == ')'){
                maxRight = start+1;
                return sum;
            }


            if(start<s.length()){
                now = s.charAt(start);
            }
            else{
                return sum;
            }
        }
        return sum;
    }

    @Test
    public void test1(){
        String s = " 1 + 1";
        System.out.println(calculate(s));
    }
}
