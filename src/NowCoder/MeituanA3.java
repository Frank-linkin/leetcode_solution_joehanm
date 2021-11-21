package NowCoder;

import java.util.Scanner;

public class MeituanA3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int n = 0;
        for(int t = 0 ; t < T ; t++){
            n = in.nextInt();
            int[] data = new int[n+1];
            //使用的是1-n
            for(int i = 1 ; i <= n ; i ++){
                data[i] = in.nextInt();
            }
            int left = 1;
            int right = n;
            while(left<=n&&data[left]==left){
                left++;
            }
            if(left==n+1){
                System.out.println(0);
                continue;
            }
            while(right>=0&&data[right]==right){
                right--;
            }
            int initialLeft = left;
            while(left<=right){
                if(data[left]==initialLeft){
                    break;
                }
                left++;
            }
            if(left>right){
                System.out.println(-1);
                continue;
            }
            //System.out.printf("right=%d,left=%d,initailLeft=%d\n",right,left,initialLeft);
            int index=0,pre=0;
            boolean flag = true;
            for(int i = 1 ; i< (right-initialLeft+1);i++){
                index = left+i;
                pre = index -1;
                if(index>right){
                    index = (index-right)+initialLeft-1;
                }
                if(pre<initialLeft){
                    pre = pre-initialLeft+right+1;
                }
                else if(pre>right){
                    pre = (pre-right)+initialLeft-1;
                }
                if(data[index]!=data[pre]+1){
                    flag = false;
                    break;
                }
            }
            if(!flag){
                System.out.println(-1);
            }
            else{
                System.out.printf("%d %d %d\n",initialLeft,right,left-initialLeft);
            }
        }

    }
}
