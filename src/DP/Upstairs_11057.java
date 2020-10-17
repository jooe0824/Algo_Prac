package DP;

import java.util.*;
/*📌 DP 문제 푸는 방법
* 👉 마지막을 유의깊게 봐라
* 👉 점화식을 만들어라
* 👉 주어진 조건을 빠짐없이 잘 봐라
* 👉 예외를 찾아봐라
* 👉 처음 초기화 해줘야 하는 배열을 찾아라
* */
public class Upstairs_11057 {
    static int mod = 10007;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] D = new int[n+1][10];

        for(int i=0;i<=9;i++){ //초기화
            D[1][i] = 1;
        }

        for(int i=2;i<=n;i++) { //2개 오르막길부터
            for (int j = 0; j <= 9 ; j++) { //마지막 숫자에 올 수 있는 것 : 0-9
                D[i][j] = 0;
                if (j-1 >= 0) { //0보다 커야됨
                    for(int k=0; k<=j-1; k++) {
                        D[i][j] += D[i-1][k] ;
                    }
                }
                D[i][j] += D[i-1][j];

                D[i][j] %= mod;
            }
        }

        int sum = 0;
        for(int i=0; i<=9; i++){
            sum += D[n][i];
        }
        sum %= mod;
        System.out.println(sum);

    }
}
