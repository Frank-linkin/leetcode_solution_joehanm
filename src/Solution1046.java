import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1046 {
    public int lastStoneWeight(int[] stones) {
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o2-o1);
            }
        };
        PriorityQueue<Integer> q = new PriorityQueue<>(com);


        for(int a :stones){
            q.offer(a);
        }

        while(q.size()>1){
            int l = q.poll();
            int s = q.poll();
            if(l>s){
                q.offer(l-s);
            }
        }

        if(q.size()==1){
            return q.poll();
        }
        else{
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution1046 a = new Solution1046();
        int nums[] = {2,7,4,1,8,1};
        System.out.println(a.lastStoneWeight(nums));
    }
}
