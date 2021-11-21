import org.junit.Test;

public class Solution316 {

    public String removeDuplicateLetters(String s) {
        int len = s.length();
        boolean[] you = new boolean[26];
        for(int i = 0  ; i < len ; i++){
           you[(s.charAt(i) - 'a')]=true ;
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 0 ; i < 26 ; i++){
            if(you[i]){
                sb.append((char)(i+'a'));
            }
        }
        return sb.toString();
    }

    @Test
    public void test1(){
        String data = "bcdabcdef";
        System.out.println(removeDuplicateLetters(data));
    }
}
