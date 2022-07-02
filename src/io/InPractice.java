package io;

import java.util.Scanner;

public class InPractice {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        for(int i = 0 ; i< 2; i++){
            int k = in.nextInt();
            if(k==0){
                break;
            }
            String str = in.nextLine();
            String[] strs = in.nextLine().split(" ");
            System.out.println(strs.length);
            for(String s : strs){
                System.out.println(s);
            }
        }
    }
}
