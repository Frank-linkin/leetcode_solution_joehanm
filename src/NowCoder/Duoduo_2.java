package NowCoder;

import java.util.Scanner;

public class Duoduo_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        String a = in.next();
        String b = in.next();

        int[] countA = new int[26];
        for(char c : a.toCharArray()){
            countA[c-'a']++;
        }
        for(char c : b.toCharArray()){
            countA[c-'a']--;
        }

        int cost = 0;
        for(int i = 0 ; i< 26 ; i++){
            //先向前搜索填上，再向后搜索填上
            if(countA[i]>0){
                //向前搜索
                for(int j = i-1; j>=0;j--) {
                    if (countA[j] < 0) {
                        if ((-countA[j]) <= countA[i]) {
                            countA[i] += countA[j];
                            cost += (i-j)*(-countA[j]);
                            countA[j] = 0;
                            if (countA[i] == 0) {
                                break;
                            }
                        } else {
                            countA[j] += countA[i];
                            cost += (i-j)*(countA[i]);

                            countA[i] = 0;
                            break;
                        }
                    }
                }
            }
            //向后搜索
            if(countA[i]>0) {
                //向前搜索
                for (int j = i + 1; j < 26; j++) {
                    if (countA[j] < 0) {
                        if ((-countA[j]) <= countA[i]) {
                            countA[i] += countA[j];
                            cost += (j-i)*(-countA[j]);

                            countA[j] = 0;
                            if (countA[i] == 0) {
                                break;
                            }
                        } else {
                            countA[j] += countA[i];
                            cost += (j-i)*(countA[i]);

                            countA[i] = 0;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(cost);
    }
}
