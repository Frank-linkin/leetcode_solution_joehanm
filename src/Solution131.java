import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution131 {
    public List<List<String>> partition(String s) {
        ArrayList<List<String>> resp = new ArrayList<>();
        if(s==null||s.length()==0){
            return resp;
        }

        boolean[][] isRe = new boolean[s.length()][s.length()];
        buildMatrix(s,isRe);
        for(int i =0; i<s.length();i++){
            if(isRe[0][i]){
                LinkedList<String> cur = new LinkedList<>();
                cur.add(s.substring(0,i+1));
                splitRe(cur,resp,i+1,isRe,s);
            }
        }
        return resp;
    }

    public void buildMatrix(String s,boolean[][] isRe){
        for(int i = s.length()-1;i>=0;i--){
            for(int j = s.length() -1 ;j>=i;j--){
                if(i==j){
                    isRe[i][j] = true;
                }else if(j==i+1){
                    isRe[i][j] = (s.charAt(i)==s.charAt(j));
                }else{
                    if(isRe[i+1][j-1]&&s.charAt(i)==s.charAt(j)){
                        isRe[i][j]=true;
                    }
                }
            }
        }
    }
    //if left==right true
    //if left+1==right if(相同) true else false
    //else
    //   if matrix[left+1][right-1]  true
    //     else false

    public void splitRe(LinkedList<String> cur, ArrayList<List<String>> resp, int initIndex, boolean[][] matrix, String s){
        if(initIndex==matrix.length){
            resp.add(new ArrayList<>(cur));
            return;
        }

        for(int i = initIndex;i<matrix.length;i++){
            if(matrix[initIndex][i]){
                cur.addLast(s.substring(initIndex,i+1));
                splitRe(cur,resp,i+1,matrix,s);
                cur.pollLast();
            }
        }
    }

    @Test
    public void test1(){
        String s = "aab";
        List<List<String>> resp=partition(s);
        for(List<String> a:resp){
            System.out.println(a);
        }
    }
}
