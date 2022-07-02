import org.junit.Test;

import java.util.LinkedList;

public class Solution130 {
    class Data{
        int x;
        int y;
        public Data(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public void solve(char[][] board) {
        if(board==null||board.length==0) {
            return;
        }

        boolean[][] flag = new boolean[board.length][board[0].length];
        for(int i = 0 ; i < board.length; i++) {
            for(int j = 0 ; j < board[0].length;j++) {
                if(board[i][j]!='X'&&flag[i][j]==false){
                    expand(i,j,flag,board);
                }
            }
        }
    }

    public void expand(int m,int n,boolean[][] flag,char[][] board) {
        int[] row = {0,1,0,-1};
        int[] column = {1,0,-1,0};
        LinkedList<Data> queue = new LinkedList<>();
        queue.addLast(new Data(m,n));
        boolean isSurround = true;
        flag[m][n]=true;
        LinkedList<Data> history = new LinkedList<>();
        while(!queue.isEmpty()){
            Data now = queue.pollFirst();
            history.addLast(now);
            for(int i = 0 ; i< 4 ; i++) {
                int curm = now.x+row[i];
                int curn = now.y+column[i];

                if(curm<0||curm>=board.length||curn<0||curn>=board[0].length){
                    isSurround = false;
                }else if(board[curm][curn]=='O'&&flag[curm][curn]==false){
                    flag[curm][curn]=true;
                    queue.add(new Data(curm,curn));
                }
            }
        }

        if(isSurround){
            for(Data a:history){
                board[a.x][a.y]='X';
            }
        }
    }

    @Test
    public void test1(){
        char[][] data={
            {'O','O','O','O','X','X'},
            {'O','O','O','O','O','O'},
            {'O','X','O','X','O','O'},
            {'O','X','O','O','X','O'},
            {'O','X','O','X','O','O'},
            {'O','X','O','O','O','O'}
        };
//        char[][] data={
//                {'O','O','O'},
//                {'O','O','O'},
//                {'O','O','O'},
//        };
        solve(data);
        for(int i = 0; i< data.length;i++){
            for(int j = 0 ; j< data[0].length;j++) {
                System.out.printf("%C ",data[i][j]);
            }
            System.out.println();
        }
    }
    /**
     * 思路一：
     * 使用一个矩阵flag[][]来检测该位置是否已经探测过
     * 遍历board,当前遍历到board[i][j]
     * if (board[i]!='X')
     *  expand(i,j,flag,board)
     *
     * boolean expand(int i,int j, int[][] flag,int[][] board)
     *   检测i,j上下左右，记为m,n
     *   if board[m][n]=='O'
     *      if flag[m][n]==false
     *          expand(m,n)
     *
     * 这种思路有问题，是深度优先搜索，那么就可能，有一个点，上下左右都是O但是都被遍历过了，
     * 所以在这种思路下，它就会被变成X，显然不符合题意
     * 使用一个队列，实现广度优先搜索，同时，另一个队列，此块遍历过的O的左边
     *
     * if (board[i][j]=='O'&&flag[i][j]==false){
     *     入队
     * }
     *
     */
}
