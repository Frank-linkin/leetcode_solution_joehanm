import org.junit.Test;

public class Solution258 {
    public int addDigits(int num) {
        int n = 0;
        while(true){
            while( num !=0){
                n+=num%10;
                num/=10;
            }
            if(n<10) return n;
            num=0;
            while( n!=0){
                num +=n%10;
                n/=10;
            }
            if(num<10) return num;
        }
    }

    @Test
    public void test1(){
        int data = 38;
        System.out.println(addDigits(data));
    }
}
