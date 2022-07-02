import org.junit.Test;

import java.util.LinkedList;

public class Solution200 {
    class Node{
        int row;
        int column;

        public Node(int row,int column){
            this.row = row;
            this.column = column;
        }
    }
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length==0||grid[0].length==0){
            return 0;
        }


        int count = 0;

        for(int i = 0 ; i<grid.length;i++){
            for(int j = 0 ; j< grid[0].length; j++){
                if(grid[i][j]=='1') {
                    count++;
                    search_dfs(grid,i,j);
                }
            }
        }
        return count;
    }

    //WFS
    public void search(char[][] grid,int row,int column){
        int[] x = {1,0,-1,0};
        int[] y = {0,1,0,-1};
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(new Node(row,column));
        grid[row][column]='0';
        while(!queue.isEmpty()){
            Node curNode = queue.pollFirst();
            //grid[curNode.row][curNode.column]='0';
            for(int i = 0 ; i< 4;i++){
                int curRow = curNode.row+x[i];
                int curCol = curNode.column+y[i];
                if(curRow>=0&&curRow<grid.length&&curCol>=0&&curCol<grid[0].length){
                   // System.out.printf("(%d %d)\n",curRow,curCol);
                    if(grid[curRow][curCol]=='1'){
                        grid[curRow][curCol]='0';
                        queue.add(new Node(curRow,curCol));
                    }
                }
            }
        }
    }

    //DFS
    public void search_dfs(char[][] grid,int row,int column){
        grid[row][column]='0';
        int[] x = {1,0,-1,0};
        int[] y = {0,1,0,-1};
        for(int i = 0 ; i< 4;i++){
            int curRow = row+x[i];
            int curCol = column+y[i];
            if(curRow>=0&&curRow<grid.length&&curCol>=0&&curCol<grid[0].length){
                if(grid[curRow][curCol]=='1'){
                    search_dfs(grid,curRow,curCol);
                }
            }
        }
    }
    
    @Test
    public void test(){
        char[][] grid = {{'1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','0','1','0','1','1'},
        {'0','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','0'},
        {'1','0','1','1','1','0','0','1','1','0','1','1','1','1','1','1','1','1','1','1'},
        {'1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
        {'1','0','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
        {'1','0','1','1','1','1','1','1','0','1','1','1','0','1','1','1','0','1','1','1'},
        {'0','1','1','1','1','1','1','1','1','1','1','1','0','1','1','0','1','1','1','1'},
        {'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','1','1'},
        {'1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1'},
        {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
        {'0','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1'},
        {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
        {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
        {'1','1','1','1','1','0','1','1','1','1','1','1','1','0','1','1','1','1','1','1'},
        {'1','0','1','1','1','1','1','0','1','1','1','0','1','1','1','1','0','1','1','1'},
        {'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','0'},
        {'1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','0'},
        {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
        {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
        {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'}};
        System.out.println(numIslands(grid));
    }
    /**
     * 使用上述链表的方法会超出时间限制
     *
     */
    /**
     * grid = [
     *   ["1","1","1","1","0"],
     *   ["1","1","0","1","0"],
     *   ["1","1","0","0","0"],
     *   ["0","0","0","0","0"]
     * ]
     * 思路：
     *      使用广度优先搜索或深度优先搜索
     *      广度优先搜索
     *      使用WFS算法，写一个递归算法(所以递归的广度优先怎么写？)，好像就得用个链表
     *      使用WFS使用，应该在访问到的时候设置一个添加到队列标记。，这样才能避免元素被重复添加到队列里，
     *      遍历，假设遍历到grid[i][j],boolean flag[]
     *      深度优先搜索
     *      深度优先搜索
     *
     */
}
