package DP;

import java.util.*;

public class BuyCard_11052 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n+1];
        int[] p = new int[n+1];

        for(int i=1;i<=n;i++){
            p[i] = sc.nextInt();
        }

        d[0] = 0;
        d[1] = p[1];
        int num=0;

        for(int i=2;i<=n;i++) {
            for(int j=1;j<=i;j++) {
                d[i] = p[j] + d[i - j];
                d[i] = Math.max(d[i], num);
                num=d[i];
            }
        }

        System.out.println(d[n]);
    }
}
