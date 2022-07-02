public class Solution279 {
    public int numSquares(int n) {
        int[] count =new int[n+1];
        return numSquaresCore(n,count);
    }

    public int numSquaresCore(int n,int[] count) {
        if(n==0) {
            count[0]=1;
            return 1;
        }
        if(n==1) {
            count[1] = 1;
            return 1;
        }

        if(count[n]!=0) {
            return count[n];
        }
        int min = 0x7fffffff;
        int i = 1;
        int square = 1;
        while(square<=n) {
            int left = n-square;
            if(left==0) {
                count[n]=1;
                return 1;
            }
            if(count[left]==0){
                count[left]=numSquaresCore(left,count);
            }
            if(count[left]<min-1){
                min = count[left]+1;
            }

            i++;
            square = i*i;
        }
        count[n]=min;
        return count[n];
    }




    public static void main(String[] args) {
        Solution279 solution279 = new Solution279();
        System.out.println(" 3 = "+solution279.numSquares(3));
        System.out.println(" 4 = "+solution279.numSquares(4));
        System.out.println(" 5 = "+solution279.numSquares(5));
        System.out.println(" 6 = "+solution279.numSquares(6));
        System.out.println(" 7 = "+solution279.numSquares(7));
        System.out.println(" 8 = "+solution279.numSquares(8));
        System.out.println(" 9 = "+solution279.numSquares(9));
        System.out.println(" 10 = "+solution279.numSquares(10));
        System.out.println(" 11 = "+solution279.numSquares(11));
        System.out.println(" 12 = "+solution279.numSquares(12));
        System.out.println(" 13 = "+solution279.numSquares(13));
    }
    /**
     * 思路一：
     *      5 = 1 +4
     *      6 = 1 + 1 + 4
     *      7 = 1+ 1 +1 +4
     *      8 = 4 + 4
     *      给定一个数字n，设p<=n的最大完全平方数，最那么它最少的完全平方数的数量
     *        count[n] = 1 + count[n-p]
     *  这个思路不对，举个例子
     *      12 = 4 + 4 +4而不是9+1+1+1
     *  改：
     *      给定n，假设p*p为<=n的最大完全平方数，那么它最少的完全平方数量
     *      resp = min( calculate(n-i*i)+1.
     *      其中1<=i<=p
     *      记录每个n的完全平方的最小数量为count[n]
     *      这种比较慢，可能是因为Math.Sqrt()开平方比较耗费CPU
     *  思路二 - 动态规划：
     *      count[n]表示的含义一定要明确，千万不能重复计算。
     *
     */
}
