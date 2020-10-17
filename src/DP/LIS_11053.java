package DP;
//Longest Increasing Subsequence
import java.util.*;

public class LIS_11053 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        int[] D = new int[n+1];
        int[] V = new int[n+1];

        for(int i=0;i<n;i++){
            num[i] = sc.nextInt();
        }

        for(int i=0;i<n;i++){
            D[i] = 1; //자기 자신 포함
            V[i] = -1;
            for(int j=0; j<i; j++){ //자신의 위치 전까지
                if( num[j] < num[i] ){ //자신이 더 커야 하며
                    D[i] = Math.max(D[i], D[j]+1); //자신 혼자와 자신 혼자+그 전에 구한거 중 최댓값 구하기
                    if(D[i] == D[j]+1){
                        V[i] = j;
                    }
                    else{
                        V[i] = 0;
                    }
                }
            }
        }

        //무조건 맨 마지막꺼를 포함한게 크지 않을 수도 있다
        //마지막이 10이면 자기 자신밖에 포함 안되어 있으니까
        int ans = 0;
        int i = 0;
        int p = 0;

        for(;i<n;i++){
            ans = Math.max(ans,D[i]);
            p = i;
        }
        System.out.println(ans);
        print(p, V, num);
        System.out.println();

    }

    static void print(int p, int[] V, int[] num) {
        if(p==-1) return;
        print(V[p], V, num);
        System.out.println(num[p] + " ");

    }

}
