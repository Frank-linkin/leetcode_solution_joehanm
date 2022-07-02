import dataStructrue.ListNode;

import java.util.*;

public class Solution322 {
    //好像这种写法有点问题
    public int coinChange1(int[] coins, int amount) {
        if(coins==null||coins.length==0) {
            return 0;
        }

        Arrays.sort(coins);
        int count = coinChangeCore(coins,amount);
        return count;
    }

    public int coinChangeCore(int[] coins,int amount) {
        if(amount==0) {
            return 0;
        }
        for(int i = coins.length-1 ; i>=0;i--) {
            if(amount-coins[i]>=0){
                int resp= coinChangeCore(coins,amount-coins[i]);
                if(resp>=0) {
                    return resp++;
                }
            }
        }
        return -1;
    }

    /**
     * 为了测试TreeMap怎么操作更快。
     * 第一次使用Poll
     * 第二次使用higherKey
     * Conclusion:
     *      这两种方法的效率都很低。再做复杂问题的时候，还是最好用自己的数据结构
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {
        if(coins==null||coins.length==0) {
            return 0;
        }

        //感觉这种很不常用的数据结构还是不用
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        //初始化map
        treeMap.put(0,0);
        //Integer firstKey = treeMap.firstKey();
        while(treeMap.firstKey()<amount) {
            Map.Entry<Integer, Integer> first = treeMap.pollFirstEntry();
            int key = first.getKey();
            int count = first.getValue();
            for(int i = 0 ; i< coins.length; i++) {
                int newKey = key+coins[i];
                if(newKey>0){
                    if(!treeMap.containsKey(newKey)){
                        treeMap.put(newKey,count+1);
                    }else{
                        int countNow=treeMap.get(newKey);
                        if(count+1<countNow){
                            treeMap.put(newKey,count+1);
                        }
                    }
                }
            }
        }
        if(treeMap.firstKey()>amount) {
            return -1;
        }else{
            return treeMap.get(amount);
        }
    }

    public int coinChange(int[] coins, int amount) {
        if(coins==null||coins.length==0) {
            return 0;
        }

        //感觉这种很不常用的数据结构还是不用
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        //初始化map
        treeMap.put(0,0);
        Integer key = treeMap.firstKey();
        while(key<amount) {
            int count = treeMap.get(key);
            for(int i = 0 ; i< coins.length; i++) {
                int newKey = key+coins[i];
                if(newKey>0){
                    if(!treeMap.containsKey(newKey)){
                        treeMap.put(newKey,count+1);
                    }else{
                        int countNow=treeMap.get(newKey);
                        if(count+1<countNow){
                            treeMap.put(newKey,count+1);
                        }
                    }
                }
            }
            key = treeMap.higherKey(key);
        }
        if(key>amount) {
            return -1;
        }else{
            return treeMap.get(amount);
        }
    }

    public static void main(String[] args) {
        int[] coins = {1,2147483647};
        int amount = 2;
        Solution322 solution322 = new Solution322();
        System.out.println(solution322.coinChange(coins,amount));

        //测试一下使用poll的效率，很低。
    }
    /**
     * 思路1：
     *      使用深度优先搜索
     *      对于给定amont
     *      函数public int cointChargetCore,不能就返回0
     *      逆序遍历I,从最大的coins开始,因为是贪心算法，先用最大的，所以第一次返回true的路线就是最小硬币数的路线
     *      if(cointChargetCore(amount - coins[i])
     *          coins++;
     *          return coins;
     *
     * 思路二：
     *      设置一个dp[count+1],dp[t]表示和为t最小的硬币数量。
     *      dp[t] = min((0<=i<coins.length) dp[t-nums[i]]
     *      可以优化一下：
     *          我们计算dp[t]是不需要dp[t-1]的
     *      map[数值]最小硬币数
     *      初始化map[coins[i]]1
     *      2,3,4,5,7
     *      1 1 1
     */
}
