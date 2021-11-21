package NowCoder;

import java.util.Scanner;

public class ByteDance2018_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int m = in.nextInt();
        int c = in.nextInt();
        boolean[] isOverlap = new boolean[c+1];
        int[] contain = new int[c+1];
        Node1[] chuan =  new Node1[N];
        for(int i = 0 ;  i< N ; i++){
            int no = in.nextInt();
            if(no==0){
                chuan[i] = new Node1();
            }
            else{
                int[] color = new int[no];
                for(int j = 0; j < no ; j++){
                    color[j] = in.nextInt();
                }
                chuan[i] = new Node1(color);
            }
        }
        int index = 0 ;
        for(index = 0 ; index<m; index++){
            if((chuan[index]).color!=null){
                for(int i = 0 ; i < (chuan[index]).color.length;i++){
                    if(contain[(chuan[index]).color[i]]==0)
                        contain[(chuan[index]).color[i]] = 1;
                    else{
                        isOverlap[(chuan[index]).color[i]] = true;
                        contain[(chuan[index]).color[i]]++;
                    }
                }
            }
        }
        for(index = m ; index<N;index++){
            if((chuan[index-m]).color!=null){
                for(int i = 0 ; i < (chuan[index-m]).color.length;i++){
                    contain[ (chuan[index-m]).color[i] ]--;
                }
            }
            if((chuan[index]).color!=null){
                for(int i = 0 ; i < (chuan[index]).color.length;i++){
                    if(contain[(chuan[index]).color[i]]==0)
                        contain[(chuan[index]).color[i]] = 1;
                    else{
                        isOverlap[(chuan[index]).color[i]] = true;
                        contain[(chuan[index]).color[i]]++;
                    }
                }
            }
        }
        //0 1 2 3 4
        for(index = 0 ; index<m-1; index++){
            if((chuan[index-m+N]).color!=null) {
                for(int i = 0 ; i < (chuan[index-m+N]).color.length;i++){
                    contain[(chuan[index-m+N]).color[i]]--;
                }
            }
            if((chuan[index]).color!=null){
                for(int i = 0 ; i < (chuan[index]).color.length;i++){
                    if(contain[(chuan[index]).color[i]]==0)
                        contain[(chuan[index]).color[i]] = 1;
                    else{
                        isOverlap[(chuan[index]).color[i]] = true;
                        contain[(chuan[index]).color[i]]++;
                    }
                }
            }
        }
        int count  = 0;
        for(int i = 0 ; i<= c ; i++){
            if(isOverlap[i]){
                count++;
            }
        }
        System.out.println(count);
    }
}

class Node1{
    int[] color;
    public Node1(int[] color){
        this.color = color;
    }
    public Node1(){
        this.color = null;
    }
}
