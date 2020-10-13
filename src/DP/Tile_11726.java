package DP;

import java.util.*;

public class Tile_11726 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n+1];
        num[0] = 1;
        num[1] = 1;

        for (int i = 2; i <= n; i++) {
            num[i] = num[i - 1] + num[i - 2];
            num[i] %= 10007;//왜 이게 들어가야 되는건지 이해가 안..나중에 자료 크기 넘을 수 있으므로
        }
        System.out.println(num[n]);
    }
}
