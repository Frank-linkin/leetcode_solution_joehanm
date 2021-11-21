import java.util.ArrayList;
import java.util.List;

public class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();

        if(m==1){
            return triangle.get(0).get(0);
        }
        int[][] sum = new int[m][];

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j <= i;j++){
                if(i == j&&j==0){
                    sum[0][1] = triangle.get(0).get(0);
                }
                else if(i!=j&&j!=0){
                    sum[j][2] = triangle.get(i).get(j)+(sum[i-1][j-1]>sum[i-1][j]?sum[i-1][j]:sum[i-1][j-1]);
                }
                else if(i==j){
                    sum[i][j] = triangle.get(i).get(j) + sum [i-1][j-1];
                }
                else{
                    sum[i][j] = triangle.get(i).get(j) + sum [i-1][j];
                }
            }
        }

        int min = sum[m-1][0];
        for(int i = 0 ; i < m ; i++){
            if(sum[m-1][i]<min){
                min = sum[m-1][i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<Integer>();
        List<Integer> b = new ArrayList<Integer>();
        List<List<Integer>> list = new ArrayList<List<Integer>>();

        a.add(1);
        b.add(2);
        b.add(3);
        List<Integer> c = new ArrayList<Integer>();
        c.add(10);
        c.add(3);
        c.add(9);
        list.add(a);
        list.add(b);
        list.add(c);

        Solution120 solution120 = new Solution120();
        System.out.println(solution120.minimumTotal(list));
    }
}
