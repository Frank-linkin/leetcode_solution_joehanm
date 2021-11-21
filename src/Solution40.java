import java.util.*;

public class Solution40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> cur = new ArrayList<Integer>();
        ArrayList<List<Integer>> lists = new ArrayList<>();
        if(candidates==null||candidates.length==0){
            return null;
        }
        else if(candidates.length == 1){
            if(candidates[0]==target){
                cur.add(candidates[0]);
                lists.add(cur);
                return lists;
            }
            else{
                return lists;
            }

        }
        Arrays.sort(candidates);
        dfs(lists,cur,candidates,0,target);

        return lists;
    }


    public void dfs( List<List<Integer>> list , List<Integer> cur,int[] candidates,int point,int target){
        if( point == candidates.length ){
            return;
        }
        else if(candidates[point]>target){
            return;
        }
        else if(point+1<candidates.length&&candidates[point+1]==candidates[point]){
            int count = 2;//统计出现的次数
            for(int i = point + 2 ; i<candidates.length&&candidates[i]==candidates[point]; i++){
                count++;
            }

            int times=1,curTarget=target;
            for(times = 1 ; times <= count ; times++ ){
                if(curTarget - candidates[point]==0){
                    cur.add(candidates[point]);
                    List<Integer> curList = new ArrayList<>();
                    curList.addAll(cur);
                    list.add(curList);
//                    System.out.println(curList);
                    times++;
                    break;
                }
                else if(curTarget - candidates[point] > 0){
                    cur.add(candidates[point]);
                    curTarget -= candidates[point];
                    dfs(list,cur,candidates,point+count,curTarget);
                }
                else{
                    break;
                }
            }

            /*if(target-candidates[point]*times<0)
                times--;
            if(==0退出)
                ;
            if(循环完退出)
                times--;
            */

            times--;
            while((times--)>0){
                cur.remove(cur.size()-1);
            }

            dfs(list,cur,candidates,point+count,target);
        }
        else{
            if( target - candidates[point]<0){
                return;
            }
            else if(target - candidates[point]==0){
                cur.add(candidates[point]);
                List<Integer> curList = new ArrayList<>();
                curList.addAll(cur);
                list.add(curList);
                cur.remove(cur.size()-1);
            }
            else {
                cur.add(candidates[point]);
                dfs(list,cur,candidates,point+1,target-candidates[point]);
                cur.remove(cur.size()-1);
                dfs(list,cur,candidates,point+1,target);
            }
        }
    }
    public static void main(String[] args) {
        Solution40 solution40 = new Solution40();

        int[] data = {1,1};
        int target = 1;
        System.out.println(solution40.combinationSum2(data,target));
    }
}
