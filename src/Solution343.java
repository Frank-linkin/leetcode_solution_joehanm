public class Solution343 {

    public int integerBreak(int n) {
        int[] res = new int[n+1];
        if(n==2){
            return 1;
        }

        res[1] = 1;
        res[2] = 1;
        int left, right;
        int max;
        int part1,part2;
        for(int i = 3; i <=n ;i ++){
            max =0;
            for(left=1,right =i-1;left<=right;left++,right--){
                part1 = res[left]>left?res[left]:left;
                part2 = res[right]>right?res[right]:right;

                int mul = part1*part2;
                if(mul>max){
                    max = part1*part2;
                }
            }

            res[i] = max;
        }
        return res[n];
    }

    public static void main(String[] args) {
        Solution343 solution343 = new Solution343();

        System.out.println(solution343.integerBreak(10));
    }
}
