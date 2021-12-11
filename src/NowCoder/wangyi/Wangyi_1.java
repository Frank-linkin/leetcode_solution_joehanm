package NowCoder.wangyi;

public class Wangyi_1 {
    public static void main(String[] args) {
        Wangyi_1 a = new Wangyi_1();
        String s = "abba";
        char[] clist = {'a'};
        System.out.println(a.specialStr(s,clist));
    }

    public int specialStr (String inputStr, char[] cList) {
        // write code here
        char[] str = inputStr.toCharArray();
        boolean[] flag = new boolean[256];

        if(cList!=null){
            for(char c:cList){
                flag[(int)c] = true;
            }
        }


        int max = 0;
        int[] dp = new int[str.length];
        for(int j = 0 ; j <str.length ; j++){
            for(int i = 0 ; i<=j;i++){
                if(i==j){
                    if(flag[(int)str[i]]==false){
                        dp[i] = 1;
                    }
                    else{
                        dp[i] = 0;
                    }
                }
                else if(i+1==j){
                    if(flag[(int)str[i]]==false&&flag[(int)str[j]]==false&&str[i]==str[j]){
                        dp[i] = 2;
                    }
                    else{
                        dp[i] = 0;
                    }
                }
                else {
                    if (flag[(int) str[i]] == false && flag[(int) str[j]] == false && str[i] == str[j] && dp[i + 1] != 0) {
                        dp[i] = dp[i + 1] + 2;
                    } else {
                        dp[i] = 0;
                    }
                }
                max = dp[i]>max?dp[i]:max;
            }
            /*for(int p=0;p<=j;p++){
                System.out.printf("%d ",dp[p]);
            }
            System.out.println();*/
        }
        return max;
    }
}
