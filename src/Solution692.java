import java.util.*;

public class Solution692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> count = new HashMap();
        for(String word:words){
            count.put(word,count.getOrDefault(word,0)+1);
        }


        PriorityQueue<String> heap = new PriorityQueue<String>(
                new Comparator(){
                    @Override
                    public int compare(Object o1, Object o2) {
                        String w1 = (String)o1;
                        String w2 = (String)o2;
                        if(count.get(w1).equals(count.get(w2))){
                            return w2.compareTo(w1);
                        }
                        else{
                            return (count.get(w1)-count.get(w2));
                        }
                    }
                }
        );

        for(String word:count.keySet()){
            heap.offer(word);
            if(heap.size()>k) heap.poll();//控制堆的规模，只保留前k个大小的元素

        }

        List<String> ans = new ArrayList();
        while(!heap.isEmpty()){
            ans.add(heap.poll());
        }
        Collections.reverse(ans);
        return ans;
    }
}
