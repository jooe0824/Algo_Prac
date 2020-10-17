package DP;

import java.util.*;

public class Binarychin_2193 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][]D = new int[n+1][2];

        D[1][0] = 0; //시작할때 0으로 시작하면 안된다.
        D[1][1] = 1;

        for(int i=2; i<=n ; i++) { //i는 2부터 시작해야 함
//            D[i][0] = 0;
//            D[i][1] = 0;
            D[i][0] += D[i-1][0] + D[i-1][1];
            D[i][1] += D[i-1][0];
        }

        int sum = D[n][0] + D[n][1];
        System.out.println(sum);
    }
}
