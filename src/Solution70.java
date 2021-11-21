public class Solution70 {
    public int climbStairs(int n) {
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }

        int former2 = 1 ,former1 = 2;
        int num = 3;
        int res = 0;
        while(num <= n){
            res = 2*former2+former1;
            former2=former1;
            former1 = res;
            num++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution70 solution70 = new Solution70();
        solution70.climbStairs(3);
    }
}
