package DP;

import java.util.*;

public class GrapeWine_2156 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] grape = new int[n+1];
        int[] D = new int[n+1]; //i까지 포도주를 마셨을 때 포도주 최대 양

        for(int i=1;i<n+1;i++){
            grape[i] = sc.nextInt();
        }

        D[1] = grape[1];
        D[2] = grape[1] + grape[2];

        for(int i=3;i<=n;i++){
            D[i] = D[i-1]; //현재 위치 포도주 안 마실 경우
            D[i] = Math.max(D[i], D[i-2]+grape[i]); //현재 위치 바로 직전 포도주 안 마실 경우
            D[i] = Math.max(D[i], D[i-3]+grape[i-1]+grape[i]); //현재 위치 바로 직전 포도주 마시고 그 전꺼 안 마시는 경우
        }

        int ans = D[1];
        for(int i=2;i<=n;i++){
            ans = Math.max(ans, D[i]); //2부터 max를 찾아간다
        }

//        D[1][0] = 0;
//        D[1][1] = grape[1];
//        int max = Math.max(D[1][0], D[1][1]);
//        D[2][0] = max;
//        D[2][1] = max + grape[2];
//
//        for(int i=3;i<=n;i++){
//            D[i][0] = Math.max(D[i-1][1], D[i-1][0]) + grape[i];
//            D[i][1] = Math.max(grape[i] + grape[i-1], grape[i] + grape[i-2]) + D[i-3][0];
//        }
//
//        int sum;
//        sum = Math.max(D[n][0], D[n][1]);

        System.out.println(ans);



    }
}
