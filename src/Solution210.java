import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution210 {
    //存储有向图
    List<List<Integer>> edges;
    //标记每个节点的状态:0=未搜索，1=搜索中，2=已完成
    int[] visited;
    //用数组来模拟栈，下标n-1为栈底，0为栈顶
    int[] result;
    //判断有向图中是否有环
    boolean valid = true;

    //栈下标
    int index;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for(int i=0;i<numCourses;++i){
            edges.add(new ArrayList<Integer>());
        }

        for(int[] a:prerequisites){
            edges.get(a[1]).add(a[0]);
        }

        visited = new int[numCourses];
        result = new int[numCourses];
        index = numCourses-1;

        for(int i=0;i<numCourses;i++){
            if(visited[i]==0){
                DFS(i);
            }
        }
        if(!valid){
            return new int[0];
        }
        return result;
    }

    public boolean DFS(int num){
        visited[num] = 1;
        for(int i:edges.get(num)){
            if(visited[i]==0){
                DFS(i);
            }
            if(visited[i]==1){
                valid=false;
                return false;
            }
        }
        visited[num]=2;
        result[index--]=num;
        return true;
    }

    @Test
    public void test(){
        int[][] data = {{6,4},{6,5},{6,2}
        ,{5,3}
        ,{4,3}
        ,{3,1},{3,6}
        ,{2,1}
        ,{1,0}};

        Solution210 sol = new Solution210();
        int[] result = sol.findOrder(7,data);
        for(int a:result){
            System.out.println(a);
        }
    }

}
