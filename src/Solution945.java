import org.junit.Test;

import java.util.HashSet;

public class Solution945 {
    //时间复杂度超过
    public int minIncrementForUnique1(int[] A) {
        int count=0;
        HashSet set = new HashSet();
        for(int i = 0 ; i< A.length ; i ++){
            while(set.contains(A[i])){
                    count++;
                    A[i]++;
            }
            set.add(A[i]);
        }
        return count;
    }
    public int minIncrementForUnique(int[] A) {
        int[] count = new int[80000];
        int max = -1;
        int min = Integer.MAX_VALUE;
        for(int x : A){
            if(x>max)
                max = x;
            if(x<min)
                min = x;
            count[x]++;
        }

        int overlap = 0,ans = 0;
        for( int i = min ; i<80000 ; i++ ){
            if(count[i]>=2){
                overlap+=(count[i]-1);
                ans = ans - (i*(count[i]-1));
            }
            else if(overlap>0&&count[i]==0){
                ans+=i;
                overlap--;
            }
            if(overlap==0&&i>max)
                return ans;
        }
        return ans;
    }
        @Test
    public void test1(){
        int[] data = {1,2,2,2,3,5};
        System.out.println(minIncrementForUnique(data));
    }
}
