package NowCoder.ByteDance;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 输入： 第1行为n代表用户的个数 第2行为n个整数，第i个代表用户标号为i的用户对某类文章的喜好度 第3行为一个正整数q代表查询的组数  第4行到第（3+q）行，每行包含3个整数l,r,k代表一组查询，
 * 即标号为l<=i<=r的用户中对这类文章喜好值为k的用户的个数。 数据范围n <= 300000,q<=300000 k是整型
 *
 * 5
 * 1 2 3 3 5
 * 3
 * 1 2 1
 * 2 4 5
 * 3 5 3
 * 输出：
 * 1
 * 0
 * 2
 */


class Node{
    int val;
    int index;

    public Node(int val,int index){
        this.val = val;
        this.index = index;
    }
}

public class ByteDance2018 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Node[] data = new Node[n];
        for(int i = 0 ; i< n ; i++){
            data[i] = new Node(in.nextInt(),i);
        }
        Arrays.sort(data, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.val-o2.val;
            }
        });
        int Q = in.nextInt();
        int l=0,r=0,k=0;
        int count = 0;
        int left = 0,right = 0;
        int mid =  0;
        for(int q = 0 ; q < Q ; q++){
            l = in.nextInt();
            r = in.nextInt();
            k = in.nextInt();
            //找到k
            left = 0;right = n-1;
            while(left<=right){
                mid = ((right-left)>>1)+left;
                if(data[mid].val ==k){
                    break;
                }
                if(data[mid].val<k){
                    left = mid +1;
                }
                else{
                    right = mid-1;
                }
            }
            if(left>right){
                System.out.println(0);
                continue;
            }
            l--;
            r--;
            count = 0;
            for(right = mid+1;right<n&&data[right].val==k;right++){
                if(data[right].index>=l&&data[right].index<=r){
                    count++;
                }
            }
            for(left = mid;left>=0&&data[left].val==k;left--){
                if(data[left].index>=l&&data[left].index<=r){
                    count++;
                }
            }
            System.out.println(count);
        }
    }


}
