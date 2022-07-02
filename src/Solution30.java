import org.junit.Test;

import java.util.*;

public class Solution30 {
    public List<Integer> findSubstring2(String s, String[] words) {
        LinkedList<Integer> resp = new LinkedList<>();
        if(s==null||s.length()==0){
            return resp;
        }

        for(int i = 0 ; i<s.length()-words[0].length()*words.length;i++){
            int judgeNumber=isCombination(s,i,words);
            if(judgeNumber==0){
                resp.add(i);
            }else if(judgeNumber==2){
                i=i+words[0].length();
                i--;
            }
        }
        return resp;
    }

    public int isCombination(String s,int index,String[] words){
        String curChar = s.substring(index,index+words[0].length());
        boolean[] flag = new boolean[words.length];
        boolean have = false;
        for(int i = 0 ; i<words.length;i++){
            if(words[i].equals(curChar)){
                have=true;
                if(judgeIndex(s,index,words,flag,words[0].length(),0)){
                    return 0;
                }
            }
        }
        if(have){
            return 1;
        }
        return 2;
    }
    public boolean judgeIndex(String s,int index,String[] words,boolean[] flag,int len,int count){
        if(count==words.length){
            //System.out.printf("%d ",index);
            return true;
        }
        if(index+len>=s.length()){
            return false;
        }
        String curSubStr = s.substring(index,index+len);
        for(int i = 0 ; i< words.length;i++){
            if(flag[i]==false&&words[i].equals(curSubStr)){
                flag[i]=true;
                count++;
                if(judgeIndex(s,index+len,words,flag,len,count)){
                    count--;
                    flag[i]=false;
                    return true;
                }
                count--;
                flag[i]=false;
            }
        }
        return false;
    }


    //使用滑动窗口的解法
    public List<Integer> findSubstring(String s, String[] words) {
        LinkedList<Integer> resp = new LinkedList<>();
        if(s==null||s.length()==0||words==null||words.length==0){
            return resp;
        }

        int wordLen = words[0].length(),wordCount=words.length;
        if(s.length()<wordLen*wordCount){
            return resp;
        }
        HashMap<String,Integer> wordsCount= new HashMap<>();
        for(String str:words){
            wordsCount.put(str,wordsCount.getOrDefault(str,0)+1);
        }
        HashSet<Integer> resultSet = new HashSet<>();
        int left = 0 ,right = wordLen*wordCount;
        while(right<=s.length()){
            if(!resultSet.contains(left)){
                canBuild(s,left,wordLen,wordCount,wordsCount,resultSet);
            }
            left++;
            right++;
        }
        return new ArrayList<Integer>(resultSet);
    }

    public boolean canBuild(String s,int start,int wordLen,int wordCount,HashMap<String,Integer> wordsCount ,HashSet<Integer> resultSet)  {
        HashMap<String,Integer> subStringCount = new HashMap<>();
        int count = 0;
        while(count<wordCount){
            String subStr = s.substring(start+count*wordLen,start+(count+1)*wordLen);
            //System.out.printf("%s ",subStr);
            if(!wordsCount.containsKey(subStr)){
                return false;
            }
            subStringCount.put(subStr,subStringCount.getOrDefault(subStr,0)+1);
            count++;
        }
        while(subStringCount.equals(wordsCount)){
            //向后移动wordLen个窗口，减少计算量
            resultSet.add(start);
            start += wordLen;
            if(start+wordLen<=s.length()&&start+(wordCount+1)*wordLen<=s.length()&&!s.substring(start,start+wordLen).equals(s.substring(start+wordCount*wordLen,start+(wordCount+1)*wordLen))){
                return true;
            }else{
                break;
            }
        }
        return false;
    }

    @Test
    public void test1(){
        String s = "barfoofoofoobarman";
        String[] str = {"foo","bar","foo"};
        System.out.println(findSubstring(s,str));
    }
    /**
     * 使用滑动窗口
     */
}
