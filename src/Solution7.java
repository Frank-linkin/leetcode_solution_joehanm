import org.junit.Test;

public class Solution7 {
    public int reverse(int x) {
        //-2147483648
        //
        int resp = 0;
        while( x != 0 ) {
            if( resp > -214748364&& resp < 214748364 ){
                resp *= 10;
            }
            else if( resp  == 214748364 ) {
                if(x>7){
                    return 0;
                }
                resp *=10;
            }
            else if( resp == -214748364 ) {
                if(Math.abs(x) >8 ) {
                    return 0;
                }
                resp *= 10;
            }
            else{
                return 0;
            }

            int lastNumber = x %10;
            resp +=lastNumber;
            x/=10;
        }
        return resp;
    }


    @Test
    public void test1(){
        int a = 54321;
        System.out.println(reverse(a));
    }
}
