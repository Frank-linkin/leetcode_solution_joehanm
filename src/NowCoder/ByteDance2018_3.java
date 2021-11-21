package NowCoder;

import java.util.Scanner;

public class ByteDance2018_3 {
    /**
     * 1 2 3 4 5
     * 2 1 3 4 5
     * 2 3 1 4 5
     * 遍历一遍，记录ch[i]的最大连续序列长度，最大连续序列的首部，尾部
     * 遍历序列前后，元素，经过几次交换后，可以得到最大序列
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int m = in.nextInt();
        Node2[] tail = new Node2[26];
        Node2[] list = new Node2[26];

        int[] maxLen = new int[26];
        int[] maxIndex = new int[26];
        int  lastC = -1;
        int cl = 0;
        for(int i = 0 ; i< s.length(); i++ ) {
            int c = s.charAt(i)-'a';
            if(c==lastC){
                cl++;
            }
            else{
                if(lastC!=-1&&maxLen[lastC]<cl){
                    maxLen[lastC] = cl;
                    maxIndex[lastC] = i-1;
                }
                cl = 1;
                lastC = c;
            }

            if(list[c] == null){
                tail[c]=list[c] = new Node2(i);
            }
            else{
                tail[c].next = new Node2(i);
                tail[c].next.pre = tail[c];
                tail[c] = tail[c].next;
            }
        }
        if(lastC!=-1&&maxLen[lastC]<cl){
            maxLen[lastC] = cl;
            maxIndex[lastC] = s.length()-1;
        }

        /*for(int i=  0 ; i< 26 ; i ++){
            Node2 tem  = list[i];
            while(tem!=null){
                tem = tem.next;
            }

            System.out.println();
        }*/
        for(int i=  0 ; i< 26 ; i++){
            if(maxLen[i]!=0){
                int left = maxIndex[i]-maxLen[i]+1;
                int right = maxIndex[i];
                Node2 lindex =null;
                for(lindex = list[i];lindex.index!=left;lindex=lindex.next);
                Node2 rindex = null;
                for(rindex = lindex;lindex.index!=right;rindex=rindex.next);

            }
        }


    }
}

class Node2{
    int index;
    Node2 pre;
    Node2 next;

    public Node2(int val){
        this.index = val;
        this.pre = null;
        this.next = null;
    }
    public Node2(int val ,Node2 pre,Node2 next){
        this.index = val;
        this.pre = pre;
        this.next = next;
    }
}