import org.junit.Test;

import java.util.LinkedList;

public class Solution57 {
    public int[][] insertqqq(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> result = new LinkedList<>();
        int leftBound = -1,rightBound = -1;
        boolean leftFound = false,rightFound = false;

        for(int i = 0 ; i< intervals.length;i++){
            if(intervals[i][0]>=newInterval[0]&&intervals[i][1]>=newInterval[0]){
                leftFound = true;
                leftBound = i;
            }else if(leftBound ==-1&&intervals[i][0]>newInterval[0]){
                leftFound = false;
                leftBound = i-1;
            }

            if(intervals[i][0]>=newInterval[1]&&intervals[i][1]>=newInterval[1]){
                rightFound = true;
                rightBound = i;
            }else if(leftBound ==-1&&intervals[i][0]>newInterval[1]){
                rightFound = false;
                rightBound = i-1;
            }
        }
        int i = 0;
        while(i<leftBound){
            int[] entry=new int[2];
            entry[0] = intervals[i][0];
            entry[1] = intervals[i][1];
            i++;
        }
        int[] interval = new int[2];
        if(leftFound){
            interval[0]=intervals[leftBound][0];
        }else{
            interval[0]=newInterval[0];
        }

        if(rightFound){
            interval[1] = intervals[rightBound][1];
        }else{
            interval[1] = newInterval[1];
        }
        result.add(interval);

        while(i<intervals.length&&intervals[i][0]<=interval[1]){
            i++;
        }
        while(i<intervals.length){
            int[] entry=new int[2];
            entry[0] = intervals[i][0];
            entry[1] = intervals[i][1];
            i++;
        }
        return null;
    }

    public int[][] insertInerval(int[][] intervals, int[] newInterval) {
        int i = 0;
        LinkedList<int[]> result = new LinkedList<>();
        while(i<intervals.length&&intervals[i][1]<newInterval[0]){
            int[] entry = new int[2];
            entry[0]=intervals[i][0];
            entry[1] = intervals[i][1];
            result.add(entry);
            i++;
        }

        int left = newInterval[0],right = newInterval[1];
        while(i<intervals.length&&intervals[i][0]<=newInterval[1]){
            if(intervals[i][0]<left){
                left=intervals[i][0];
            }

            if(intervals[i][1]>right){
                right = intervals[i][1];
            }
            i++;
        }
        int[] newEntry = new int[2];
        newEntry[0]=intervals[i][0];
        newEntry[1] = intervals[i][1];
        result.add(newEntry);
        while(i<intervals.length){
            int[] entry = new int[2];
            entry[0]=intervals[i][0];
            entry[1] = intervals[i][1];
            result.add(entry);
        }
        return result.toArray(new int[result.size()][]);
    }

    @Test
    public void test1(){
        LinkedList<int[]> result = new LinkedList<>();
        for(int i = 0 ; i< 3;i++){
            int[] entry = new int[2];
            entry[0]=i;
            entry[1]=i;
            result.add(entry);
        }
        int[][] arr=result.toArray(new int[result.size()][]);
        for(int[] a:arr){
            System.out.printf("%d %d\n",a[0],a[1]);
        }
    }
}
