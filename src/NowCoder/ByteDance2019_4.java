package NowCoder;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class ByteDance2019_4 {
    /**
     * maxLen
     * lastLen
     * nowLen
     * 现有key
     *      if key 存在于lastLen中
     *          将lastLen中对应的value取出，然后++，放于nowLen中
     *      else
     *          将key添加进nowLen中，val=1
     *
     * 处理玩这一帧后，将所有没在此帧出现的key都写入到maxLen中
     * lastLen = nowlen
     * nowLen清空
     * 检查nowlen
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = 0;
        int x = 0;
        int y = 0;
        HashMap<String, Integer> maxSequence = new HashMap<>();
        HashMap<String,Integer> lastLen = new HashMap<String,Integer>();
        HashMap<String,Integer> nowLen = new HashMap<String,Integer>();
        for(int test=0;test<n;test++){
            m = in.nextInt();
            for(int piece=0;piece<m;piece++){
                int r = in.nextInt();//这一帧有O个特征
                while(r-->0){
                    x = in.nextInt();
                    y = in.nextInt();
                    String key = x+"_"+y;

                    if(lastLen.containsKey(key)){
                        nowLen.put(key,lastLen.get(key)+1);
                     //   System.out.printf("%s,1\n",key);
                    }
                    else{
                        nowLen.put(key,1);
                   //     System.out.printf("%s,2\n",key);
                    }
                }
                //将所有没在nowLen中出现的key写回到MaxSequence中
                Set<String> lastSet = lastLen.keySet();
                lastSet.removeAll(nowLen.keySet());
                for(String a:lastSet){
                    if(lastLen.get(a)>maxSequence.getOrDefault(a,0)){
                        maxSequence.put(a,lastLen.get(a));
                    }
                }
                HashMap<String,Integer> tem = nowLen;
                nowLen = lastLen;
                lastLen = tem;
                nowLen.clear();
            }
            for(String a:lastLen.keySet()){
                if(lastLen.get(a)>maxSequence.getOrDefault(a,0)){
                    maxSequence.put(a,lastLen.get(a));
                }
            }
        }
//        System.out.println(maxSequence);
        int max = 0;
        for(int a:maxSequence.values()){
            max = a>max?a:max;
        }
        System.out.println(max);
    }
}
