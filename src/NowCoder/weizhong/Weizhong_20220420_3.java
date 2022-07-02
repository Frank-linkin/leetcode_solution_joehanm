package NowCoder.weizhong;

import java.util.LinkedList;
import java.util.Scanner;

public class Weizhong_20220420_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String str = in.next();
        char c = str.charAt(0);

        in.nextLine();
        String s = in.nextLine();

//        System.out.println(c);
//        System.out.println(s);

        LinkedList<Integer> indexC = new LinkedList<>();
        for(int i = 0 ; i< s.length();i++){
            if(s.charAt(i)==c){
                indexC.addLast(i);
            }
        }
        int length = indexC.size();
        if(length<k){
            System.out.println(0);
            return;
        }
        indexC.addLast(n);
        indexC.addFirst(-1);
        int totalCount = 0;
        for(int i = 0 ; indexC.get(k+i)!=n;i++){
            int kLeft = indexC.get(1+i);
            int kRight  = indexC.get(k+i);
 //           System.out.printf("kLeft=%d,kRight=%d\n",kLeft,kRight);
            int leftCount = kLeft-indexC.get(i);
            int rightCount = indexC.get(k+i+1)-kRight;
 //           System.out.printf("leftCount=%d,rightCount=%d\n",leftCount,rightCount);
            if(kLeft==kRight){
                totalCount +=(leftCount*rightCount);

            }else{
                totalCount +=(leftCount*rightCount);
            }
        }
        System.out.println(totalCount);
    }
}
