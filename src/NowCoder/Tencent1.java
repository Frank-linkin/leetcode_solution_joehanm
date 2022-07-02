package NowCoder;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Tencent1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int[][] data = new int[len][2];
        for(int i = 0 ; i< len ; i++){
            data[i][0]= in.nextInt();
        }
        for(int i = 0 ; i< len ; i++){
            data[i][1]= in.nextInt();
        }
        //输入完毕
//        int[][] data = {{1,1},{1,1},{1,1},{2,1},{3,1}};
//        int len =5;
        Comparator<int[]> com =new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o2[1] - o1[1];
                else
                    return o1[0] - o2[0];
            }
        };
       Arrays.sort(data,com);
        int now = data[0][0];
        int cost = 0;
        for(int i = 0 ; i<len ; i++){
            now = data[i][0];
            int j = i+1;
            for(j=i+1;j<len&&data[j][0]==now;j++);
            Arrays.sort(data,i,j,com);
            for(j = i+1;j<len&&data[j][0]==now;j++){
                data[j][0]++;
                cost+=data[j][1];
            }
            for(j = 0 ; j < len ; j++){
                System.out.printf("%d",data[j][0]);
            }
            System.out.println();
            for(j = 0 ; j < len ; j++){
                System.out.printf("%d",data[j][1]);
            }
            System.out.println();
            System.out.println();
        }
        System.out.println(cost);
    }
}

