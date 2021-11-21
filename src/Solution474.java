import java.sql.Array;
import java.util.Arrays;
import java.util.stream.Stream;

public class Solution474 {
    //version1 202104
    public int findMaxForm_version1(String[] strs, int m, int n) {
        if(m==0&&n==0){
            return 0;
        }
        if(strs==null||strs.length==0){
            return 0;
        }

        int[][] dp = new int[m+1][n+1];
        int cm=0,cn=0;
        for(int i = 0 ; i < strs.length ;i ++){
            //计算此字符串中0的个数cm，1的个数cn
            cm = 0 ; cn = 0;
            for(int j = 0 ; j < strs[i].length(); j ++){
                if(strs[i].charAt(j)=='1'){
                    cn++;
                }
                else{
                    cm++;
                }
            }

            //开始处理
            for(int p = m ; p >= cm ; p--){
                for(int q = n ; q >= cn ; q--){
                    dp[p][q] = dp[p][q]>(dp[p-cm][q-cn]+1)?dp[p][q]:(dp[p-cm][q-cn]+1);
                }
            }
        }
        return dp[m][n];
    }

    //version1 2021年11月21日11:10:48
    public int findMaxForm(String[] strs, int m, int n) {
        if(strs == null ) return 0;
        if( strs.length == 0 )
            return 0;//这个也可能是0

        //初始化矩阵
        int[][] dp = new int[m+1][n+1];
        for(String a : strs){
            int[] countZeroAndOne = analyseStr(a);
            for(int i = m  ; i >= 0 ; i--){
                for(int j = n ; j>=0 ; j--){
                    if(i>=countZeroAndOne[0]&&j>=countZeroAndOne[1])
                        dp[i][j] = Math.max(dp[i-countZeroAndOne[0]][j-countZeroAndOne[1]]+1,dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }
    public int[] analyseStr(String str) {
        //resp[0]代表0的个数，1代表1的个数
        int[] resp = new int[2];
        for (char c : str.toCharArray()){
            if(c=='1')
                resp[1]++;
            else if(c=='0')
                resp[0]++;
        }
        return resp;
    }

    public static void main(String[] args) {

        String[] strs = {"10","0001","111001","1","0"};
        Solution474 solution474 = new Solution474();
        int m = 5;
        int n = 3;
        System.out.println(solution474.findMaxForm(strs, m, n));
    }
}
