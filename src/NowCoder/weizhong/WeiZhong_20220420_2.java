package NowCoder.weizhong;

import java.util.Scanner;

public class WeiZhong_20220420_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i = 0 ; i< n ;i++) {
            nums[i] = in.nextInt();
        }

        int[] dp =new int[n];
        int total = 0;
        for(int i = 0 ; i < nums.length ;i++) {
            for(int j = i-1;j>=0;j--){
                if(nums[i]>nums[j]){
                    dp[i] +=dp[j];
                }
            }
            dp[i]++;
            total+=dp[i];
        }
        System.out.println(total);
    }
}
