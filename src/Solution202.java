import org.junit.Test;

public class Solution202 {
    public boolean isHappy(int n) {
        if(n == 1 ) return true;
        int fast  = nextValue(n);
        while(fast != n){
            if(fast==1||n==1){
                return true;
            }
            fast = nextValue(nextValue(fast));
            n = nextValue(n);
        }
        return false;

    }

    int nextValue(int data){
        int sum = 0;
        while(data!=0){
            int figure = data%10;
            sum += figure * figure;
            data = data/10;
        }
        return sum;
    }

    @Test
    public void test1(){
        System.out.println(nextValue(9));
    }
}
