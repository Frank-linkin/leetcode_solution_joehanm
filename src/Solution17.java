import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution17 {
    public class Hash{
        char a;
        Hash next;

        public Hash(char a){
            this.a=a;
        }
    }


    public List<String> letterCombinations(String digits) {
        if(digits==null||digits.length()==0){
            return new ArrayList<String>();
        }

        ArrayList<String> res = new ArrayList<String>();
        StringBuffer buf = new StringBuffer();
        //建造一个hash表
        Hash[] table = new Hash[8];
        for(int i = 0 ; i< 8  ; i++){
            if(i>=6){
                table[i] = new Hash((char)(i*3+1+'a'));
            }
            else
                table[i]= new Hash((char)(i*3+'a'));
        }
        for(int i = 0 ; i<8 ; i++){
            Hash p = table[i];
            for(int j = 1 ; (i+1==table.length&&(table[i].a+j)<='z')||(i+1<table.length&&table[i].a+j<table[i+1].a);j++){
                p.next = new Hash((char)(table[i].a+j));
                p=p.next;
            }
        }
//        Hash p = table[7];
//        while(p!=null){
//            System.out.printf("%c ",p.a);
//            p=p.next;
//        }
        //hash表建立完毕
        findCombination(table,res,buf,digits,0);
        return res;
    }

    public void findCombination(Hash[] table,List<String> res,StringBuffer buf,String digits,int index ){
        if(index>=digits.length()){
            res.add(buf.toString());
            return;
        }
        for(Hash c = table[(digits.charAt(index)-'2')];c!=null;c=c.next){
            buf.append(c.a);
            findCombination(table,res,buf,digits,index+1);
            buf.deleteCharAt(buf.length()-1);
        }
    }

    @Test
    public void test1(){
        System.out.println(letterCombinations("23"));
    }
}
