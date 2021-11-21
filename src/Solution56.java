import org.junit.Test;

import java.util.*;

public class Solution56 {
    public int[][] merge(int[][] intervals) {
        if(intervals==null){
            return null;
        }
        if(intervals.length==1){
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]!=o2[0]){
                    return o1[0]-o2[0];
                }
                else{
                    return o2[1]-o1[1];
                }
            }
        });
        List<int[]> list  = new ArrayList<int[] >();
        int[] now = intervals[0];
        for(int i = 1 ; i<intervals.length;i++){
            if(intervals[i][0]>now[1]||i==intervals.length-1){
                list.add(now);
                now = intervals[i];
            }
            else if(intervals[i][1]>now[1]){
                now[1] = intervals[i][1];
            }
        }
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
