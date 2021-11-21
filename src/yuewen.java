import org.junit.Test;

public class yuewen {
    public int characterReplacement (String str, int k) {
        if(str==null) return 0;
        if(str.length()<k) return str.length();
        // write code here
        int max = k;
        for(int i = 0 ; i < str.length()-k;i++){
            int maxLen = checkMax(str,k,i+1,str.charAt(i));
            if(maxLen>max)
                max = maxLen;
        }
        return max;
    }
    public int checkMax(String str,int k , int start,char target){
        int i = start;
        for(;i<str.length();i++){
            if(str.charAt(i)!=target){
                k--;
                if(k==-1)
                    break;
            }
        }
        return i-start+1;//加上start之前的那一个
    }

    @Test
    public void test(){
        String s = "ABCC";
        int k = 10;
        System.out.println(characterReplacement(s,k));
    }
}
