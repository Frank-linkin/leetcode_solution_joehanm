import java.util.ArrayList;
import java.util.List;

public class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null||triangle.size()==0) {
            return 0;
        }

        int[] distance = new int[triangle.size()];
        distance[0] = triangle.get(0).get(0);
        for(int i = 1 ; i< triangle.size();i++) {
            List<Integer> curRow = triangle.get(i);
            for(int j = curRow.size()-1  ; j>=0 ; j--) {
                if(j==0) {
                    distance[j] = distance[j]+curRow.get(j);
                }else if(j==i) {
                    distance[j] = distance[j-1]+curRow.get(j);
                }else{
                    distance[j] = Math.max(distance[j-1],distance[j])+curRow.get(j);
                }
            }
        }
        int min = 0x7fffffff;
        for(int a : distance) {
            min = min<a?min:a;
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
    /**
     * 使用一个数组distance[][]记录到达第m行，第n列的最短路程为distanche[m][n]
     * distance[m][n] = min(distance[m-1][n-1],distance[m-1][n]) + nums[m][n]
     * if m == n
     *     distance[m][n] = distance[m-1][n-1]+nums[m][n]
     * if n == 1
     *     distance[m][n] = distance[m-1][n]+nums[m][n]
     *
     *  2
     *  3 4
     *  6 5 7
     *  4 1 8 3
     */
}
