package NowCoder;

import java.util.*;

public class Huawei_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();
        boolean[][] matrix = new boolean[M][M];
        char[] p=null,q=null;
        int p1,q1;
        int[] countYiLai = new int[M];
        for(int n = 0 ; n < N ; n++) {
            p = in.next().toCharArray();
            q = in.next().toCharArray();
            matrix[q[3]-'a'][p[3]-'a'] = true;
        }
        LinkedList<Integer> root = new LinkedList<>();
        boolean isEnd = false;
        boolean youHuan = false;
        boolean isRoot = true;
        boolean isBegin = true;
        boolean[] visited = new boolean[M];
        boolean hasLeft = false;
        while(!isEnd){
            hasLeft = false;
            for(int j=0;j< M ; j++) {
                if(visited[j]==false){
                    hasLeft = true;
                    isRoot = true;
                    for(int i = 0 ; i<M ;i++){
                        if(visited[i]==false&&matrix[i][j]==true){
                            isRoot = false;
                        }
                    }
                    if(isRoot){
                        root.add(j);
                    }
                }
            }
            if(root.isEmpty()){
                if(hasLeft){
                    youHuan = true;
                    break;
                }
                else{
                    youHuan = false;
                    break;
                }

            }

            while(!root.isEmpty()){
                int tem = root.pollFirst();
                visited[tem] = true;
                p[3]=(char)(tem+'a');
                if(!isBegin){
                    System.out.printf(" ");
                }
                else{
                    isBegin = false;
                }
                System.out.printf("%s",new String(p));
            }
        }
    }
}
