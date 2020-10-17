package DP;

import java.util.*;

public class onetwothree_5_15990 {
    static int max = 100000;
    static long mod = 1000000009L;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[][] D = new int[max+1][4];


        for(int i = 1; i<= max; i++){
            if(i>= 1) {
                if (i == 1) {
                    D[i][1] = 1;
                }
                else {
                    D[i][1] = D[i - 1][2] + D[i - 1][3];
                }
            }
            if(i>=2) {
                if (i == 2) {
                    D[i][2] = 1;
                } else {
                    D[i][2] = D[i - 2][1] + D[i - 2][3]; //2를 뺀 수
                }
            }
            if(i>=3){
                if (i == 3) {
                    D[i][3] = 1;
                } else {
                    D[i][3] = D[i - 3][1] + D[i - 3][2]; //3을 뺀 수
                }
            }
            D[i][1] %= mod;
            D[i][2] %= mod;
            D[i][3] %= mod; //나눠주기
        }

        int test = sc.nextInt();

        while(test-- >0){
            int n = sc.nextInt();
            System.out.println((D[n][1] + D[n][2] + D[n][3])%mod);
        }
    }
}
