import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution648 {

    //
    public String replaceWords(List<String> dictionary, String sentence) {
        //边界条件的处理
        if(dictionary == null||dictionary.size()==0){
                return null;
        }
        if(sentence==null){
            return null;
        }

        //字典树的构建
        Tries root = new Tries();
        for(String s : dictionary){
            root.insert(s);
        }

        //开始处理
        String[] data = sentence.split(" ");
        String str = null;
        for(int i = 0 ; i <data.length ; i++){
            str = null;
            str = root.findMinPrefix(data[i]);
            if(str!=null){
                data[i] = str;
            }
        }
        StringBuffer sb = new StringBuffer();
        sb.append(data[0]);
        for(int i = 1 ; i < data.length ; i++){
            sb.append(" ");
            sb.append(data[i]);
        }

        return sb.toString();
    }


    class Tries{
        public char data;
        public boolean isEnd;
        public Tries[] next;
        public boolean haveSon;
        int count = 0;//有几个前缀经过这个点

        public Tries(){
            data = ' ';
            isEnd = false;
            next = new Tries[26];
            haveSon = false;
            count = 0;
        }

        public Tries(char data){
            this.data = data;
            isEnd = false;
            next = new Tries[26];
            haveSon = false;
            count = 1;
        }

        public void insert( String s  ){
            if( s==null||s.length()==0){
                return;
            }

            char[] data = s.toCharArray();
            Tries cur = this;
            for(int i = 0 , len = s.length(); i<len ;i++){
                int pos = data[i]-'a';
                if( cur.next[pos] == null ){
                    cur.haveSon=true;
                    cur.next[pos] = new Tries(data[i]);
                    cur.next[pos].count=1;
                    if(i==len-1){
                        cur.next[pos].isEnd=true;
                    }
                }
                else{
                    cur.next[pos].count++;
                    if(i==len-1){
                        cur.next[pos].isEnd=true;
                    }
                }
                cur = cur.next[pos];
            }
            return ;
        }

        public String findMinPrefix(String s){
            if(this.haveSon == false){
                return null;
            }
            if(s == null || s.length()==0){
                return null;
            }

            char[] data = s.toCharArray();
            StringBuffer sb = new StringBuffer();
            Tries cur = this;
            for(int i = 0 ; i < s.length() ; i++){
                if( cur.haveSon == false ){
                    return null;
                }
                int pos = data[i] - 'a';
                if(cur.next[pos] == null){
                    return null;
                }
                else{
                    cur = cur.next[pos];
                    sb.append(cur.data);
                    if(cur.isEnd == true){
                        return sb.toString();
                    }
                }
            }
            return null;
        }

    }

    @Test
    public void test1(){
/*        Tries root = new Tries();
        root.insert("tom");;
        root.insert("cat");
        root.insert("tomand");
        root.insert("tomandcat");
        System.out.println(root.findMinPrefix("tomandcat"));*/

        List<String> dictionary = new ArrayList<String>();
        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("rat");

        String sentence = "the cattle was rattled by the battery";

        Solution648 solution648 = new Solution648();
        System.out.println(solution648.replaceWords(dictionary,sentence));
    }
}
