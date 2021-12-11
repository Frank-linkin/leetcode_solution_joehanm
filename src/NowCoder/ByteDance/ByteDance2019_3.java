package NowCoder.ByteDance;

import java.util.ArrayList;
import java.util.Scanner;

//15:00开始
//15:49编程结束
public class ByteDance2019_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] data = new int[10];
        for(int i= 0 ; i < 13 ; i++){
            data[in.nextInt()]++;
        }
      //  int[] data = {0,3,3,0,0,3,3,0,0,1};
        ArrayList<Integer> list = new ArrayList<>();
        ByteDance2019_3 main = new ByteDance2019_3();
        for(int i = 1 ; i< 10; i++){
            if(data[i]<4){
                data[i]++;
                for(int j =1;j<10;j++){
                    if(data[j]>=2){
                        data[j]-=2;
                        if(main.judge(data,4)){
                            list.add(i);
                          //  System.out.printf("i=%d,雀头j=%d\n",i,j);
                            data[j]+=2;
                          /*  System.out.printf("data:");
                            for(int a:data){
                                System.out.printf("%d ",a);
                            }
                            System.out.println();*/
                            break;
                        }
                        data[j]+=2;
                    }
                }
                data[i]--;
            }
        }
        for(int i = 1 ; i<list.size();i++){
            System.out.printf("%d ",list.get(i-1));
        }
        System.out.printf("%d",list.get(list.size()-1));
    }

    public boolean judge(int[] data,int k){
        if(k==0){
            return true;
        }
        int i = 1;
        for(i= 1; i < 8 ; i++){
            if(data[i]>2){
                data[i]=data[i]-3;
                if(judge(data,k-1)){
                    data[i]+=3;
                    return true;
                }
                data[i]+=3;
            }
            if(data[i]>=1&&data[i+1]>=1&&data[i+2]>=1){
                data[i]--;data[i+1]--;data[i+2]--;
                if(judge(data,k-1)){
                    data[i]++;data[i+1]++;data[i+2]++;
                    return true;
                }
                data[i]++;data[i+1]++;data[i+2]++;
            }
        }
        for(i=8;i<10;i++){
            if(data[i]>2){
                data[i]=data[i]-3;
                if(judge(data,k-1)){
                    data[i]+=3;
                    return true;
                }
                data[i]+=3;
            }
        }
        return false;
    }
}
