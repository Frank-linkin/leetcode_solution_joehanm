import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static java.lang.Thread.sleep;

public class Solution933 {
    public static void main(String[] args) throws InterruptedException {


    }

    @Test
    public void test1(){
        RecentCounter rc = new RecentCounter();
        while(true){
            try {
                sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(rc.ping());

        }
    }
    class RecentCounter{

        int count;
        ArrayList<Long> list;

        public RecentCounter(){
            count = 0;
            list = new ArrayList<Long>();
        }

        int ping(){
            Date date = new Date();
            count++;
            list.add(date.getTime());

            int sum=0;
            Long tem;
            for(int i=count-1 ;i>=0;i--){
                tem = list.get(i);
                if(date.getTime()-tem<3000){
                    sum++;
                }
            }
            System.out.println("List:"+list);
            return sum;
        }
    }
}
