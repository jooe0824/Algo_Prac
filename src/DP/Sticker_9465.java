package DP;

import java.util.*;

public class Sticker_9465 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();

        while(test-- > 0) {

            int n = sc.nextInt();
            int[][] D = new int[n+1][3];
            int[][] sticker = new int[2][n];
            for(int i=0;i<2;i++){
                for(int j=0;j<n;j++) {
                    sticker[i][j] = sc.nextInt();
                }
            }

            D[1][0] = 0;
            D[1][1] = sticker[0][0];
            D[1][2] = sticker[1][0];

            for (int i = 2; i <= n; i++) {
                D[i][0] = Math.max(D[i-1][2], Math.max(D[i - 1][0], D[i - 1][1]));

                D[i][1] = Math.max(D[i - 1][0], D[i - 1][2]) + sticker[0][i-1];

                D[i][2] = Math.max(D[i - 1][0], D[i - 1][1]) + sticker[1][i - 1];
            }

            int ans = 0;
            ans = Math.max(D[n][0], D[n][1]);
            ans = Math.max(ans, D[n][2]);

            System.out.println(ans);
        }
    }
}
