import org.junit.Test;

public class Solution8 {
    public int myAtoi(String s) {
        if(s.length()==0){
            return 0;
        }

        int point=0;
        char[] array = s.toCharArray();
        //消除空格
        while(point<array.length&&array[point] == ' '){
            point++;
        }

        boolean positive = true;
        if(point<array.length&&array[point]=='+'){
            point++;
        }
        else if(point<array.length&&array[point] == '-'){
            positive = false;
            point++;
        }

        int countNum = 0 ;
        int value = 0;
        while(point<array.length){
            if(array[point]>='0'&&array[point]<='9'){//进入正式处理流程
                if(countNum>=9) {
                    if (value > 214748364) {
                        return 2147483647;
                    }
                    if (value < -214748364) {
                        return -2147483648;
                    }
                    if(value == 214748364){
                        if(array[point]-'0'>7||array.length-point>1){
                            return 2147483647;
                        }
                    }
                    if(value == -214748364){
                        if(array[point]-'0'>8||array.length-point>1){
                            return -2147483648;
                        }
                    }
                }
                value *= 10;
                if(positive==true) {
                    value = value + (array[point] - '0');
                }
                else{
                    value = value - (array[point] - '0');
                }
                point++;
                countNum++;
                if(value<10&&value>0&&positive==false){
                    value=0-value;
                }
            }
            //不是数字，返回此时的value;
            else
                break;
        }
        return value;
    }

    @Test
    public void test1(){
        String data = " 2000000000000000 ";
        System.out.println(myAtoi(data));
        int a = 2147483647;
        System.out.println(a);
    }
}
