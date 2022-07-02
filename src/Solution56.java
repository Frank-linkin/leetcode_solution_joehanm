import org.junit.Test;

import java.util.*;

public class Solution56 {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0 ) {
            return null;
        }

        Arrays.sort(intervals,new Comparator<int[]>(){
            @Override
           public int compare(int[] a,int[] b) {
                return a[0]-b[0];
            }
        });
//        for(int[] a :intervals) {
//            System.out.printf("%d ",a[0]);
//        }


        int left = intervals[0][0] ,right = intervals[0][1];
        LinkedList<int[]> list = new LinkedList<int[]>();
        for(int i = 1; i<intervals.length ; i++) {
            int[] a = intervals[i];
            if(a[0]>right){
                //一个新的区间
                int[] newInterval = new int[2];
                newInterval[0] =left;
                newInterval[1] = right;
                list.add(newInterval);
                left = a[0];
                right = a[1];
            }
            else{
                right = right<a[1]?a[1]:right;
            }
        }
        //一个新的区间
        int[] newInterval = new int[2];
        newInterval[0] =left;
        newInterval[1] = right;
        list.add(newInterval);
        return list.toArray(new int[list.size()][2]);
    }
    @Test
    public void test1(){
        int[][] data = new int[4][2];
        data[0][0]=1;data[0][1]=3;
        data[1][0]=8;data[1][1]=10;
        data[2][0]=7;data[2][1]=9;
        data[3][0]=8;data[3][1]=9;


        int[][] res = merge(data);
        for(int i = 0 ; i < res.length ; i++){
            System.out.printf("%d %d\n",res[i][0],res[i][1]);
        }
    }

}
