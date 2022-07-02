import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution739 {
    class Data{
        int temperature;
        int index;
        public Data(int tem,int index) {
            this.temperature = tem;
            this.index= index;
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures==null||temperatures.length==0) {
            return null;
        }
        int[] nextLarger = new int[temperatures.length];

        LinkedList<Data> monotonousStack = new LinkedList<>();
        for(int i = 0 ; i < temperatures.length ;i++) {
            while(monotonousStack.size()>0&&monotonousStack.getLast().temperature<temperatures[i]){
                Data last = monotonousStack.pollLast();
                nextLarger[last.index]=i-last.index;
            }
            monotonousStack.addLast(new Data(temperatures[i],i));
        }
        return nextLarger;
    }

    @Test
    public void test1(){

    }
}
