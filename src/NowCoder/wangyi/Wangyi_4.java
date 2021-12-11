package NowCoder.wangyi;

public class Wangyi_4 {
    public static void main(String[] args) {
        Wangyi_4 a = new Wangyi_4();
        int[] population = {1,2,3,4,5,6,7,8,9};
        int k = 2;
        a.GetMaxCoverage(population,k);
    }

    public int GetMaxCoverage (int[] populationDistribute, int stationCoverage) {
        // write code here
        int i = 0;
        int[] dp = new int[populationDistribute.length];
        int benefit = 0;
        for(;i<stationCoverage+1;i++){
            benefit+=populationDistribute[i];
        }
        i=1;
        dp[0] = benefit;
        for(int j = 0 ; j < stationCoverage;j++){
            benefit+=populationDistribute[j+stationCoverage+1];
            dp[i++] = benefit;
        }
        for(;i<populationDistribute.length-stationCoverage;i++){
            benefit+=populationDistribute[i+stationCoverage];
            benefit-=populationDistribute[i-stationCoverage-1];
            dp[i] = benefit;
        }

        for(;i<populationDistribute.length;i++){
            benefit-=populationDistribute[i-stationCoverage-1];
            dp[i] = benefit;
        }
        for(int p = 0 ; p<dp.length ; p++){
            System.out.println(dp[p]);
        }
        return 0;
    }
}
