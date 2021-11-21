public class Solution79 {
    public boolean exist(char[][] board, String word) {
        if(board==null||board.length<1||board[0].length<1||word==null||word.length()<1) return false;
        char target = word.charAt(0);
        boolean[][] visited =  new boolean[board.length][board[0].length];
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ;j++){
                if(board[i][j]==target){
                    visited[i][j] = true;
                    if(search(board,i,j,1,word,visited)) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }
    public boolean search(char[][] board,int m,int n,int index ,String word,boolean[][] visited){
        if(index==word.length())
            return true;
        char target = word.charAt(index);
        if(m-1>=0&&!visited[m-1][n]&&board[m-1][n]==target){
            visited[m-1][n]= true;
            if(search(board,m-1,n,index+1,word,visited))
                return true;
            visited[m-1][n]= false;
        }
        if(m+1<board.length&&!visited[m+1][n]&&board[m+1][n]==target){
            visited[m+1][n]= true;
            if(search(board,m+1,n,index+1,word,visited)){
                return true;
            }
            visited[m+1][n]= false;
        }
        if(n-1>=0&&!visited[m][n-1]&&board[m][n-1]==target){
            visited[m][n-1]= true;
            if(search(board,m,n-1,index+1,word,visited))
                return true;
            visited[m][n-1]= false;
        }
        if(n+1<board[0].length&&!visited[m][n+1]&&board[m][n+1]==target){
            visited[m][n+1]= true;
            if(search(board,m,n+1,index+1,word,visited))
                return true;
            visited[m][n+1]= false;
        }
        return false;
    }
}
