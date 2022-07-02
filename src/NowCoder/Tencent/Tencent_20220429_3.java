package NowCoder.Tencent;

public class Tencent_20220429_3 {
    public int howMany (String S, int k) {
        // write code here
        int[] count = new int[26];
        for(char a: S.toCharArray()){
            count[a-'a']++;
        }
        int resp = 0;
        for(int i = 0; i< count.length;i++){
            if(count[i]>=k){
                resp++;
            }
        }
        return resp;
    }
}
