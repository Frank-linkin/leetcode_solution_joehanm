import java.util.ArrayList;
import java.util.List;

public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<Integer> data = new ArrayList<Integer>();
        int[] row = new int[numRows+1];
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        data.set(1,1);
        for(int i = 0;i<numRows;i++){
            for(int j=i;j>=1;j++){
                data.set(j,data.get(j-1)+data.get(j));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(101);
        list.add(102);
        list.add(1,16);
        list.set(1,32);
        System.out.println(list.get(2));
        System.out.println(list.get(1));
    }
}
