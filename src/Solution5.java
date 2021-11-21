public class Solution5 {
    public String longestPalindrome_Self(String s) {

        int i = 0;
        int maxlen = 0;
        String maxSubStr = s.substring(0,1);
        int max1=0,max2 =0;
        for(int n=0;n<s.length();n++){
            i =0;
            for(i=0;(n+i)<s.length()&&n-i>=0;i++){
                if(s.charAt(n+i)!=s.charAt(n-i)){
                    break;
                }
            }
            i--;
            max1 = i;


            int j =n;
            for(i=n+1,j=n;j>=0&&i<s.length();i++,j--){
                if(s.charAt(i)!=s.charAt(j)){
                    break;
                }
            }
            i--;j++;


            max2 = i-j+1;

            if((2*max1+1)>max2){
                if(maxlen<(2*max1+1)){
                    maxlen= (2*max1+1);
                    maxSubStr = s.substring(n-max1,n+max1+1);
                }
            }

            if(max2>(2*max1+1)){
                if(maxlen<max2){
                    maxlen = max2;
                    maxSubStr = s.substring(j,i+1);
                }
            }
        }

        return maxSubStr;
    }

    public String longestPalindrome(String s) {
        if(s==null){
            return null;
        }

        int n = s.length();

        boolean[][] flag = new boolean[n][n];
        String ans = "";

        for(int i= n-1;i>=0;i--){
            for(int j = i;j<n;j++){
                if(i==j){
                    flag[i][j] = true;
                }
                else if(j==i+1){
                    flag[i][j] = (s.charAt(i)==s.charAt(j));
                }
                else{
                    flag[i][j] = (( s.charAt(i)==s.charAt(j)) && flag[i+1][j-1] );
                    if(flag[i][j]==true){
                        if(j-i+1>ans.length()){
                            ans = s.substring(i,j+1);
                        }
                    }
                }
            }

        }
        return ans;
    }


    public static void main(String[] args) {
        String str = "01234567";
        System.out.println(str.substring(1,8));

        String data  = "cbbd";
        Solution5 solution = new Solution5();
        System.out.println(solution.longestPalindrome(data));
    }
}