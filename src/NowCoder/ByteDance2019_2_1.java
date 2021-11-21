package NowCoder;

import java.util.*;

public class ByteDance2019_2_1 {
    //高软作业
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Node3[] data = new Node3[n];
        for(int t= 0 ; t< n ; t++){
            data[t] = new Node3();
            data[t].val = in.nextInt();
            data[t].index = t;
        }
        Arrays.sort(data,new Comparator<Node3>(){
            @Override
            public int compare(Node3 a, Node3 b) {
                if(a.val!=b.val){
                    return a.val - b.val;
                }
                else{
                    return a.index - b.index;
                }
            }
        });
/*        for(int t= 0 ; t< n ; t++){
            System.out.printf("%d|%d ",data[t].val,data[t].index);
        }*/
        int Q = in.nextInt();
        int left =0 , right = 0 , value = 0 ;
        int l = 0,r= 0,mid = -1;
        int count = 0;
        for(int q = 0 ; q < Q ; q++){
            left = in.nextInt();
            right= in.nextInt();
            value = in.nextInt();

            right--;
            left--;

            if(n==0){
                System.out.println(0);
                continue;
            }

            //二分查找val
            l = 0;r=n-1;
            while(l<=r){
                mid = ((r-l)>>1)+l;
                if(data[mid].val<value){
                    l = mid +1;
                }
                else if(data[mid].val > value){
                    r = mid - 1;
                }
                else{
                    break;
                }
            }
            //System.out.printf("left=%d,right=%d,mid=%d\n",left,right,mid);
            count = 0;
            if(l<=r){
                l =mid;
                r= mid +1;
                while(l>=0&&data[l].val==value){
                    if(data[l].index<left){
                        break;
                    }
                    if(data[l].index>=left&&data[l].index<=right){
                        count++;
                    }
                    l--;
                }
                while(r<n&&data[r].val == value){
                    if(data[r].index>right){
                        break;
                    }
                    if(data[r].index>=left&&data[r].index<=right){
                        count++;
                    }
                    r++;
                }
            }
            System.out.println(count);
        }
    }
}

class Node3{
    int val ;
    int index;
}