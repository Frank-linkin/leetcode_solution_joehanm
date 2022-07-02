import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

public class Solution76 {
    public String minWindow(String s, String t) {
        if(s==null || s.length()==0){
            return "";
        }

        int[] countT = new int[52];
        boolean[] exist = new boolean[52];

        for(char c : t.toCharArray()){
            int index = getIndex(c);
            countT[index]++;
        }
        for(int i = 0 ; i<52;i++){
            if(countT[i]!=0){
                exist[i]=true;
            }
        }

        int left = 0,right = 0;
        while(!isContain(countT,exist,s.charAt(right))){
            right++;
            if(right==s.length()){
                return "";
            }
        }
        while(!exist[left]||countT[getIndex(s.charAt(left))]<0){
            int index = getIndex(s.charAt(left));
            if(exist[index]){
                countT[index]++;
            }
            left++;
        }
        int index;
        System.out.printf("%d,%d right",left,right);
        int minLeft =left,minRight=right;
        while(right<s.length()){
            right++;
            while(right<s.length()&&s.charAt(right)!=s.charAt(left)){
                index = getIndex(s.charAt(right));
                if(exist[index]){
                    countT[index]--;
                }

                right++;
            }
            if(right==s.length()){
                break;
            }
            index = getIndex(s.charAt(right));
            if(exist[index]){
                countT[index]--;
            }


            while(!exist[left]||countT[getIndex(s.charAt(left))]<0){
                index = getIndex(s.charAt(left));
                if(exist[index]){
                    countT[index]++;
                }
                System.out.printf("%d,%d rightpp\n",left,right);
                left++;
            }

            System.out.printf("%d,%d right",left,right);
            if(right-left<minRight-minLeft){
                minRight = right;
                minLeft = left;
            }
        }
        return s.substring(minLeft,minRight+1);
    }

    public int getIndex(char c){
        if(c>='A'&&c<='Z'){
            return c-'A';
        }
        return c-'a'+26;

    }

    public boolean isContain(int[] count,boolean[] exist,char c){
        int index = getIndex(c);
        if(!exist[index]){
            return false;
        }

        if(exist[index]){
            count[index]--;
            if(count[index]==0){
                for(int a :count){
                    if(a>0){
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Test
    public void test1(){
        char a = 'A';
        while(a<128){
            System.out.println(a++);
        }
    }
}
