package DP;

import java.util.*;

public class Stairs_10844 {
    static long mod = 1000000000L;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] D = new long[n+1][10]; //1<n<=100, 맨 마지막에 올 수 있는 숫자 1-9

        for(int i=1;i<=9;i++){
            D[1][i] = 1; //자릿수 하나인 계단의 수는 9개 => 초기화
        }

        for(int i=2;i<=n;i++){
            for(int j=0;j<=9;j++){
                D[i][j] = 0;
                if(j-1 >= 0){ //j-1이 음수가 되면 안되니까
                    D[i][j] +=  D[i-1][j-1];
                }
                if(j+1 <= 9){ //j+1이 9를 넘어가면 안되니까
                    D[i][j] += D[i-1][j+1];
                }
                D[i][j] %= mod; //그때마다 나눠주기
            }
        }

        long sum = 0;
        for (int i=0;i<=9;i++){
            sum += D[n][i];
        }
        sum %= mod;
        System.out.println(sum);
    }
}
