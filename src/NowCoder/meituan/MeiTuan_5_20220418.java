package NowCoder.meituan;

import org.junit.Test;

import java.util.Scanner;

public class MeiTuan_5_20220418 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n = in.nextInt();
        int[] father = new int[n+1];
        for(int i =2; i<=n; i++) {
            father[i] = in.nextInt();
        }
        int[] weight = new int[n+1];
        for(int i = 1 ; i< weight.length;i++) {
            weight[i]=in.nextInt();
        }

        int m = in.nextInt();
        int[] up = new int[m];
        int[] down = new int[m];
        for(int i = 0 ; i < m ;i++) {
            up[i] = in.nextInt();
        }
        for(int i = 0 ; i < m ;i++) {
            down[i] = in.nextInt();
        }

        //将查询改成小的在up，大的在down
        for(int i = 0;i<m;i++) {
            if (up[i]>down[i]){
                int tem = up[i];
                up[i] = down[i];
                down[i] = tem;
            }
        }

        //
    }

    public static int enquiry(int[] weight,int start,int end){
        if(start==end){
            return 0;
        }
        int commonEnd = findMinTree(start,end);

        int startVal = weight[start];
        if(start!=commonEnd){
            int target = start/2;
            while(target!=commonEnd){
                startVal = startVal^weight[target];
                target = target/2;
            }
        }

        int endVal = weight[end];
        if(end!=commonEnd){
            int target = end/2;
            while(target!=commonEnd){
                endVal = endVal^weight[target];
                target = target/2;
            }
        }
        if(start==commonEnd){
            return endVal^weight[commonEnd];
        }
        if(end==commonEnd){
            return startVal^weight[commonEnd];
        }
        return startVal^endVal^commonEnd;
    }

    public static int findMinTree(int node1,int node2) {
        //node1恒大于等于node2
        if(node1<node2){
            int tem = node1;
            node1=node2;
            node2=tem;
        }
        int level1 = calcuLevel(node1);
        int level2 = calcuLevel(node2);
        while(level1>level2){
            node1=node1/2;
            level1--;
        }
        while(node1!=node2){
            node1 = node1/2;
            node2 = node2/2;
        }
        return node1;
    }

    public static int calcuLevel(int p) {
        int level = 1;
        int startNum = 1;
        int endNum = 1;
        while(true){
            if(startNum<=p&&p<=endNum) {
                return level;
            }

            startNum = level*2;
            endNum = (startNum*2)-1;
            System.out.printf("（%d,%d）",startNum,endNum);
            level++;
        }
    }

    @Test
    public  void test(){
        MeiTuan_5_20220418 solution = new MeiTuan_5_20220418();
        //System.out.println(solution.calcuLevel(9));

        System.out.println(solution.findMinTree(9,7));
        System.out.println(solution.findMinTree(9,5));
        System.out.println(solution.findMinTree(5,11));

    }
}
