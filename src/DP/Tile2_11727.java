package DP;

import java.util.*;

public class Tile2_11727 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n+1];
        num[0] = 1;
        num[1] = 1;

        for (int i = 2; i <= n; i++) {
            num[i] = num[i - 1] + num[i - 2]*2;
            //2*2 한개와 2*1 두개를 넣을 때는 D[n-2]의 방법의 수
            //1*2 한개를 넣을 때는 D[n-1]의 방법의 수

            num[i] %= 10007;
        }
        System.out.println(num[n]);
    }
}
