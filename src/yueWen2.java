import org.junit.Test;

public class yueWen2 {
    public long sumDigits (long number) {
        // write code here
        long res = 0;
        while(number!=0){
    //        System.out.println(number%10);
            res+=(number%10);
            number/=10;
        }
        res=res<0?-res:res;
        return res;
    }

    @Test
    public void test1(){
        long number = -324;
        System.out.println(sumDigits(number));
    }
}
